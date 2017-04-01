package net.zhanqi.app.cas.extend;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import net.zhanqi.lib.component.sys.DaoInfo;
import net.zhanqi.lib.component.sys.impl.HibernateDaoInfoImpl;

import org.jasig.cas.ticket.ServiceTicket;
import org.jasig.cas.ticket.ServiceTicketImpl;
import org.jasig.cas.ticket.Ticket;
import org.jasig.cas.ticket.TicketGrantingTicketImpl;
import org.jasig.cas.ticket.registry.AbstractDistributedTicketRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class JdbcTicketRegistry extends AbstractDistributedTicketRegistry {

    @NotNull
    private DaoInfo dao;

    @NotNull
    private String ticketGrantingTicketPrefix = "TGT";

    @Autowired
    public void setDao(HibernateDaoInfoImpl dao) {
        this.dao = dao;
    }

    @Override
    public void addTicket(Ticket ticket) {
        dao.insert(ticket);
        log.debug("Added ticket [{}] to registry.", ticket);
    }

    @Override
    public Ticket getTicket(String ticketId) {
        return getProxiedTicketInstance(getRawTicket(ticketId));
    }

    @Override
    public boolean deleteTicket(String ticketId) {
        Ticket ticket = getRawTicket(ticketId);

        if (ticket == null) {
            return false;
        }

        if (ticket instanceof ServiceTicket) {
            removeTicket(ticket);
            log.debug("Deleted ticket [{}] from the registry.", ticket);
            return true;
        }

        deleteTicketAndChildren(ticket);
        log.debug("Deleted ticket [{}] and its children from the registry.", ticket);
        return true;
    }

    @Override
    public Collection<Ticket> getTickets() {
        List<TicketGrantingTicketImpl> tgts = dao.list(TicketGrantingTicketImpl.class);
        List<ServiceTicketImpl> sts = dao.list(ServiceTicketImpl.class);

        List<Ticket> tickets = new ArrayList<Ticket>();
        tickets.addAll(tgts);
        tickets.addAll(sts);

        return tickets;
    }

    @Override
    protected void updateTicket(Ticket ticket) {
        dao.update(ticket);
        log.debug("Updated ticket [{}].", ticket);
    }

    @Override
    protected boolean needsCallback() {
        return false;
    }

    private void deleteTicketAndChildren(Ticket ticket) {
        TicketGrantingTicketImpl tgt = dao.unique(TicketGrantingTicketImpl.class,
                ticket.getId());

        ServiceTicketImpl st = dao.unique(ServiceTicketImpl.class, ticket.getId());

        if (st != null) {
            removeTicket(st);
        }

        if (tgt != null) {
            deleteTicketAndChildren(tgt);
        }

        if (tgt != null) {
            removeTicket(ticket);
        }
    }

    private void removeTicket(Ticket ticket) {
        try {
            if (log.isDebugEnabled()) {
                Date creationDate = new Date(ticket.getCreationTime());
                log.debug("Removing Ticket [{}] created: {}", ticket,
                        creationDate.toString());
            }
            dao.delete(ticket);
        } catch (Exception e) {
            log.error("Error removing {} from registry.", ticket, e);
        }
    }

    private Ticket getRawTicket(String ticketId) {
        try {
            if (ticketId.startsWith(this.ticketGrantingTicketPrefix)) {
                return dao.unique(TicketGrantingTicketImpl.class, ticketId);
            }

            return dao.unique(ServiceTicketImpl.class, ticketId);
        } catch (Exception e) {
            log.error("Error getting ticket {} from registry.", ticketId, e);
        }

        return null;
    }

    public int sessionCount() {
        return countToInt(dao.queryScalar(
                "select count(t) from TicketGrantingTicketImpl t", Long.class));
    }

    public int serviceTicketCount() {
        return countToInt(dao.queryScalar("select count(t) from ServiceTicketImpl t",
                Long.class));
    }

    private int countToInt(Object result) {
        int intval;
        if (result instanceof Long) {
            intval = ((Long) result).intValue();
        } else if (result instanceof Integer) {
            intval = (Integer) result;
        } else {
            // Must be a Number of some kind
            intval = ((Number) result).intValue();
        }
        return intval;
    }

    public void setDao(DaoInfo dao) {
        this.dao = dao;
    }

    public void setTicketGrantingTicketPrefix(String ticketGrantingTicketPrefix) {
        this.ticketGrantingTicketPrefix = ticketGrantingTicketPrefix;
    }

}
