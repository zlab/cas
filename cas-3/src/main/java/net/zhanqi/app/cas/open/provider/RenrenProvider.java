package net.zhanqi.app.cas.open.provider;

import net.sf.json.JSONObject;

import org.scribe.builder.api.RenrenApi;
import org.scribe.model.OAuthConfig;
import org.scribe.oauth.OAuth20ServiceImpl;
import org.scribe.up.profile.UserProfile;
import org.scribe.up.provider.BaseOAuth20Provider;
import org.scribe.up.provider.BaseOAuthProvider;

public class RenrenProvider extends BaseOAuth20Provider {

    private String scope;

    @Override
    protected UserProfile extractUserProfile(String body) {
        JSONObject json = JSONObject.fromObject(body);
        if (json.get("response") == null) {
            return null;
        }

        UserProfile profile = new UserProfile();
        profile.setId(json.getJSONObject("response").getString("id"));

        return profile;
    }

    @Override
    protected String getProfileUrl() {
        return "https://api.renren.com/v2/user/login/get";
    }

    @Override
    protected void internalInit() {
        OAuthConfig config = new OAuthConfig(key, secret, callbackUrl, null, scope, null);
        this.service = new OAuth20ServiceImpl(new RenrenApi(), config);
    }

    @Override
    protected BaseOAuthProvider newProvider() {
        return new RenrenProvider();
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

}
