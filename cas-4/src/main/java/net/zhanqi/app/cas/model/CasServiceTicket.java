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
@Table(name = "cas_service_ticket")
public class CasServiceTicket implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long serviceid;
    private Boolean fromnewlogin;
    private Boolean grantedticketalready = false;

    @Id
    @Column(name = "stid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getServiceid() {
        return serviceid;
    }

    public void setServiceid(Long serviceid) {
        this.serviceid = serviceid;
    }

    public Boolean getFromnewlogin() {
        return fromnewlogin;
    }

    public void setFromnewlogin(Boolean fromnewlogin) {
        this.fromnewlogin = fromnewlogin;
    }

    public Boolean getGrantedticketalready() {
        return grantedticketalready;
    }

    public void setGrantedticketalready(Boolean grantedticketalready) {
        this.grantedticketalready = grantedticketalready;
    }

}
