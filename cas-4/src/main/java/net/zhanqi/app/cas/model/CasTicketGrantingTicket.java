package net.zhanqi.app.cas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * 
 * CasServiceTicket
 * 
 * @author zhanqi
 * @since 2012-08-08
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "cas_ticket_granting_ticket")
public class CasTicketGrantingTicket implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Boolean expired = false;

    @Id
    @Column(name = "tgtid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getExpired() {
        return expired;
    }

    public void setExpired(Boolean expired) {
        this.expired = expired;
    }

}
