package net.zhanqi.app.cas.extend;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import net.zhanqi.sshe.frame.component.DaoInfo;
import org.jasig.cas.ticket.ServiceTicket;
import org.jasig.cas.ticket.ServiceTicketImpl;
import org.jasig.cas.ticket.Ticket;
import org.jasig.cas.ticket.TicketGrantingTicketImpl;
import org.jasig.cas.ticket.registry.AbstractDistributedTicketRegistry;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class JdbcTicketRegistry extends AbstractDistributedTicketRegistry {

    @NotNull
    private DaoInfo dao;

    @NotNull
    private String ticketGrantingTicketPrefix = "TGT";

    @Override
    public void addTicket(Ticket ticket) {
       // dao.insert(ticket);
        logger.debug("Added ticket [{}] to registry.", ticket);
    }

    @Override
    public Ticket getTicket(String ticketId) {
        return getProxiedTicketInstance(getRawTicket(ticketId));
    }

    @Override
    public boolean deleteTicket(String ticketId) {
        final Ticket ticket = getRawTicket(ticketId);

        if (ticket == null) {
            return false;
        }

        if (ticket instanceof ServiceTicket) {
            removeTicket(ticket);
            logger.debug("Deleted ticket [{}] from the registry.", ticket);
            return true;
        }

        deleteTicketAndChildren(ticket);
        logger.debug("Deleted ticket [{}] and its children from the registry.", ticket);
        return true;
    }

    @Override
    public Collection<Ticket> getTickets() {
        final List<TicketGrantingTicketImpl> tgts = dao.queryList(
                "select t from TicketGrantingTicketImpl t",
                TicketGrantingTicketImpl.class);
        final List<ServiceTicketImpl> sts = dao.queryList(
                "select s from ServiceTicketImpl s", ServiceTicketImpl.class);

        final List<Ticket> tickets = new ArrayList<Ticket>();
        tickets.addAll(tgts);
        tickets.addAll(sts);

        return tickets;
    }

    @Override
    protected void updateTicket(Ticket ticket) {
       // dao.update(ticket);
        logger.debug("Updated ticket [{}].", ticket);
    }

    @Override
    protected boolean needsCallback() {
        return false;
    }

    private void deleteTicketAndChildren(final Ticket ticket) {
        String hql = "select t from TicketGrantingTicketImpl t where t.ticketGrantingTicket.id = :id";
        List<TicketGrantingTicketImpl> tgts = dao.queryList(hql,
                TicketGrantingTicketImpl.class, ticket.getId());

        hql = "select s from ServiceTicketImpl s where s.ticketGrantingTicket.id = :id";
        List<ServiceTicketImpl> sts = dao.queryList(hql, ServiceTicketImpl.class,
                ticket.getId());

        for (ServiceTicketImpl s : sts) {
            removeTicket(s);
        }

        for (TicketGrantingTicketImpl t : tgts) {
            deleteTicketAndChildren(t);
        }

        removeTicket(ticket);
    }

    private void removeTicket(final Ticket ticket) {
        try {
            if (logger.isDebugEnabled()) {
                final Date creationDate = new Date(ticket.getCreationTime());
                logger.debug("Removing Ticket [{}] created: {}", ticket,
                        creationDate.toString());
            }
          //  dao.delete(ticket);
        } catch (final Exception e) {
            logger.error("Error removing {} from registry.", ticket, e);
        }
    }

    private Ticket getRawTicket(final String ticketId) {
        try {
            if (ticketId.startsWith(this.ticketGrantingTicketPrefix)) {
                return dao.unique(TicketGrantingTicketImpl.class, ticketId);
            }

            return dao.unique(ServiceTicketImpl.class, ticketId);
        } catch (final Exception e) {
            logger.error("Error getting ticket {} from registry.", ticketId, e);
        }

        return null;
    }

    public int sessionCount() {
        return countToInt(dao
                .queryCount("select count(t) from TicketGrantingTicketImpl t"));
    }

    public int serviceTicketCount() {
        return countToInt(dao.queryCount("select count(t) from ServiceTicketImpl t"));
    }

    private int countToInt(final Object result) {
        final int intval;
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
