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
 * CasRegisteredService
 * 
 * @author zhanqi
 * @since 2012-08-08
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "cas_registered_service")
public class CasRegisteredService implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String serviceurl;
    private String servicetype;
    private String description;
    private String name;
    private String theme;
    private Boolean allowedtoproxy = false;
    private Boolean enabled = true;
    private Boolean ssoenabled = true;
    private Boolean anonymousaccess = false;
    private Boolean ignoreattributes = false;
    private Integer evaluationorder;
    private String usernameattribute;
    private String expressiontype = "ant";

    private String clientsecret;
    private String clientid;

    private String allowedattributes;

    @Id
    @Column(name = "serviceid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceurl() {
        return serviceurl;
    }

    public void setServiceurl(String serviceurl) {
        this.serviceurl = serviceurl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Boolean getAllowedtoproxy() {
        return allowedtoproxy;
    }

    public void setAllowedtoproxy(Boolean allowedtoproxy) {
        this.allowedtoproxy = allowedtoproxy;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getSsoenabled() {
        return ssoenabled;
    }

    public void setSsoenabled(Boolean ssoenabled) {
        this.ssoenabled = ssoenabled;
    }

    public Boolean getAnonymousaccess() {
        return anonymousaccess;
    }

    public void setAnonymousaccess(Boolean anonymousaccess) {
        this.anonymousaccess = anonymousaccess;
    }

    public Boolean getIgnoreattributes() {
        return ignoreattributes;
    }

    public void setIgnoreattributes(Boolean ignoreattributes) {
        this.ignoreattributes = ignoreattributes;
    }

    public Integer getEvaluationorder() {
        return evaluationorder;
    }

    public void setEvaluationorder(Integer evaluationorder) {
        this.evaluationorder = evaluationorder;
    }

    public String getUsernameattribute() {
        return usernameattribute;
    }

    public void setUsernameattribute(String usernameattribute) {
        this.usernameattribute = usernameattribute;
    }

    public String getExpressiontype() {
        return expressiontype;
    }

    public void setExpressiontype(String expressiontype) {
        this.expressiontype = expressiontype;
    }

    public String getClientsecret() {
        return clientsecret;
    }

    public void setClientsecret(String clientsecret) {
        this.clientsecret = clientsecret;
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }

    public String getAllowedattributes() {
        return allowedattributes;
    }

    public void setAllowedattributes(String allowedattributes) {
        this.allowedattributes = allowedattributes;
    }

    public String getServicetype() {
        return servicetype;
    }

    public void setServicetype(String servicetype) {
        this.servicetype = servicetype;
    }

}
