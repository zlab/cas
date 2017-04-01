package net.zhanqi.app.cas.bo.open;

import java.io.Serializable;

/**
 * 
 * 
 * @author zhanqi
 * @date 2012-10-18
 */
public class OpenUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * qq/sina
     */
    private String platform;

    private String openId;
    private String accessToken;
    private String nickname;
    private String avatar;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

}
