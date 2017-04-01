package net.zhanqi.app.cas.bo.open;

import java.io.Serializable;

/**
 * WeiboUser
 * 
 * @author zhanqi
 * @date 2012-11-28
 */
public class WeiboUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 帐号
     */
    private String name;
    private String nick;
    // 30/50/100
    private String head;
    private String location;
    private String introduction;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getHead() {
        return head;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
