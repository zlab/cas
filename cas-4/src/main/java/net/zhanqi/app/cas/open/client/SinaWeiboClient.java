package net.zhanqi.app.cas.open.client;

import java.util.Map.Entry;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.zhanqi.app.cas.open.profile.SinaWeiboProfile;

import org.pac4j.core.client.BaseClient;
import org.pac4j.core.context.WebContext;
import org.pac4j.oauth.client.BaseOAuth20Client;
import org.pac4j.oauth.credentials.OAuthCredentials;
import org.scribe.builder.api.SinaWeiboApi20;
import org.scribe.model.OAuthConfig;
import org.scribe.model.Token;
import org.scribe.oauth.OAuth20ServiceImpl;

public class SinaWeiboClient extends BaseOAuth20Client<SinaWeiboProfile> {
    
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
        this.service = new OAuth20ServiceImpl(new SinaWeiboApi20(), config);
    }

    @Override
    protected String getProfileUrl(Token token) {
        return "https://api.weibo.com/2/statuses/user_timeline.json?count=1";
    }

    @Override
    protected SinaWeiboProfile extractUserProfile(String body) {
        SinaWeiboProfile profile = new SinaWeiboProfile();
        JSONObject json = JSONObject.fromObject(body);
        JSONArray statuses = json.getJSONArray("statuses");
        if (statuses != null && statuses.size() > 0) {
            JSONObject user = statuses.getJSONObject(0).getJSONObject("user");
            @SuppressWarnings("unchecked")
            Set<Entry<String, Object>> set = user.entrySet();
            profile.setId(user.get("id"));
            for (Entry<String, Object> entry : set) {
                profile.addAttribute(entry.getKey(), entry.getValue());
            }
        }

        return profile;
    }

    @Override
    protected BaseClient<OAuthCredentials, SinaWeiboProfile> newClient() {
        return new SinaWeiboClient();
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
    
    
}
