package net.zhanqi.app.cas.open.client;

import net.sf.json.JSONObject;
import net.zhanqi.app.cas.open.profile.RenrenProfile;

import org.pac4j.core.client.BaseClient;
import org.pac4j.core.context.WebContext;
import org.pac4j.oauth.client.BaseOAuth20Client;
import org.pac4j.oauth.credentials.OAuthCredentials;
import org.scribe.builder.api.RenrenApi;
import org.scribe.model.OAuthConfig;
import org.scribe.model.Token;
import org.scribe.oauth.OAuth20ServiceImpl;

public class RenrenClient extends BaseOAuth20Client<RenrenProfile> {
    
    private String scope;

    @Override
    protected boolean requiresStateParameter() {
        return false;
    }

    @Override
    protected boolean hasBeenCancelled(WebContext context) {
        return false;
    }

    @Override
    protected void internalInit() {
        super.internalInit();
        OAuthConfig config = new OAuthConfig(key, secret, callbackUrl, null, scope, null);
        this.service = new OAuth20ServiceImpl(new RenrenApi(), config);
    }

    @Override
    protected String getProfileUrl(Token token) {
        return "https://api.renren.com/v2/user/login/get";
    }

    @Override
    protected RenrenProfile extractUserProfile(String body) {
        JSONObject json = JSONObject.fromObject(body);
        if (json.get("response") == null) {
            return null;
        }

        RenrenProfile profile = new RenrenProfile();
        profile.setId(json.getJSONObject("response").getString("id"));

        return profile;
    }

    @Override
    protected BaseClient<OAuthCredentials, RenrenProfile> newClient() {
        return new RenrenClient();
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

}
