package net.zhanqi.app.cas.open.provider;

import java.util.Map.Entry;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.scribe.builder.api.SinaWeiboApi20;
import org.scribe.model.OAuthConfig;
import org.scribe.oauth.OAuth20ServiceImpl;
import org.scribe.up.profile.UserProfile;
import org.scribe.up.provider.BaseOAuth20Provider;
import org.scribe.up.provider.BaseOAuthProvider;

public class SinaWeiboProvider extends BaseOAuth20Provider {

    private String scope;

    @Override
    protected UserProfile extractUserProfile(String body) {
        UserProfile profile = new UserProfile();
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
    protected String getProfileUrl() {
        return "https://api.weibo.com/2/statuses/user_timeline.json?count=1";
    }

    @Override
    protected void internalInit() {
        OAuthConfig config = new OAuthConfig(key, secret, callbackUrl, null, scope, null);
        this.service = new OAuth20ServiceImpl(new SinaWeiboApi20(), config);
    }

    @Override
    protected BaseOAuthProvider newProvider() {
        return new SinaWeiboProvider();
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

}
