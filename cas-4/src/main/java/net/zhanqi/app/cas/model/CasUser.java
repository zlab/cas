package net.zhanqi.app.cas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

/**
 * 
 * CasUser
 * 
 * @author zhanqi
 * @since 2012-08-08
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "cas_user")
public class CasUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long uid;
    private String username;
    private String password;
    private String activekey;
    private String status;

    private String qzoneid;
    private String qzonetoken;

    private String sinaweiboid;
    private String sinaweibotoken;

    private String renrenid;
    private String renrentoken;

    private String githubid;
    private String githubtoken;

    @Id
    @Column(name = "userid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getActivekey() {
        return activekey;
    }

    public void setActivekey(String activekey) {
        this.activekey = activekey;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getQzoneid() {
        return qzoneid;
    }

    public void setQzoneid(String qzoneid) {
        this.qzoneid = qzoneid;
    }

    public String getSinaweiboid() {
        return sinaweiboid;
    }

    public void setSinaweiboid(String sinaweiboid) {
        this.sinaweiboid = sinaweiboid;
    }

    public String getRenrenid() {
        return renrenid;
    }

    public void setRenrenid(String renrenid) {
        this.renrenid = renrenid;
    }

    public String getGithubid() {
        return githubid;
    }

    public void setGithubid(String githubid) {
        this.githubid = githubid;
    }

    public String getQzonetoken() {
        return qzonetoken;
    }

    public void setQzonetoken(String qzonetoken) {
        this.qzonetoken = qzonetoken;
    }

    public String getSinaweibotoken() {
        return sinaweibotoken;
    }

    public void setSinaweibotoken(String sinaweibotoken) {
        this.sinaweibotoken = sinaweibotoken;
    }

    public String getRenrentoken() {
        return renrentoken;
    }

    public void setRenrentoken(String renrentoken) {
        this.renrentoken = renrentoken;
    }

    public String getGithubtoken() {
        return githubtoken;
    }

    public void setGithubtoken(String githubtoken) {
        this.githubtoken = githubtoken;
    }

}
