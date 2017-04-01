package net.zhanqi.app.cas.open.client;

import net.sf.json.JSONObject;
import net.zhanqi.app.cas.open.api.QzoneApi;
import net.zhanqi.app.cas.open.profile.QzoneProfile;

import org.pac4j.core.client.BaseClient;
import org.pac4j.core.context.WebContext;
import org.pac4j.oauth.client.BaseOAuth20Client;
import org.pac4j.oauth.credentials.OAuthCredentials;
import org.scribe.model.OAuthConfig;
import org.scribe.model.Token;
import org.scribe.oauth.OAuth20ServiceImpl;

public class QzoneClient extends BaseOAuth20Client<QzoneProfile> {

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
        this.service = new OAuth20ServiceImpl(new QzoneApi(), config);
    }
    
    @Override
    protected String getProfileUrl(Token token) {
        return "https://graph.qq.com/oauth2.0/me";
    }

    @Override
    protected QzoneProfile extractUserProfile(String body) {
        body = body.replaceAll("callback\\((.*)\\);", "$1");
        JSONObject json = JSONObject.fromObject(body);
        if (json.get("error") != null) {
            return null;
        }

        QzoneProfile profile = new QzoneProfile();
        profile.setId(json.getString("openid"));
        
//        final JsonNode json = JsonHelper.getFirstNode(body);
//        if (json != null) {
//            profile.setId(JsonHelper.get(json, "id"));
//            for (final String attribute : OAuthAttributesDefinitions.githubDefinition.getAllAttributes()) {
//                profile.addAttribute(attribute, JsonHelper.get(json, attribute));
//            }
//        }

        return profile;
    }

    @Override
    protected BaseClient<OAuthCredentials, QzoneProfile> newClient() {
        return new QzoneClient();
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

}
