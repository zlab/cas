package net.zhanqi.app.cas.open.provider;

import net.sf.json.JSONObject;
import net.zhanqi.app.cas.open.api.QzoneApi;

import org.scribe.model.OAuthConfig;
import org.scribe.oauth.OAuth20ServiceImpl;
import org.scribe.up.profile.UserProfile;
import org.scribe.up.provider.BaseOAuth20Provider;
import org.scribe.up.provider.BaseOAuthProvider;

public class QzoneProvider extends BaseOAuth20Provider {

    private String scope;

    @Override
    protected UserProfile extractUserProfile(String body) {
        body = body.replaceAll("callback\\((.*)\\);", "$1");
        JSONObject json = JSONObject.fromObject(body);
        if (json.get("error") != null) {
            return null;
        }

        UserProfile profile = new UserProfile();
        profile.setId(json.getString("openid"));

        return profile;
    }

    @Override
    protected String getProfileUrl() {
        // String profileUrl = getProfileUrl() + "?openid=" +
        // json.getString("openid");
        // profileUrl += "&oauth_consumer_key=" + json.get("client_id");
        // return "https://graph.qq.com/user/get_user_info";
        return "https://graph.qq.com/oauth2.0/me";
    }

    @Override
    protected void internalInit() {
        OAuthConfig config = new OAuthConfig(key, secret, callbackUrl, null, scope, null);
        this.service = new OAuth20ServiceImpl(new QzoneApi(), config);
    }

    @Override
    protected BaseOAuthProvider newProvider() {
        return new QzoneProvider();
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

}
