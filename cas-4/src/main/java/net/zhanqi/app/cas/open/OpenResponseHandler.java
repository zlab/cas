package net.zhanqi.app.cas.open;

import java.io.IOException;

import net.zhanqi.sshe.frame.core.Result;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

/**
 * 
 * 
 * @author zhanqi
 * @date 2012-10-18
 */
public class OpenResponseHandler<T> implements ResponseHandler<Result<T>> {

    @Override
    public Result<T> handleResponse(HttpResponse response) throws IOException {
        Result<T> rs = new Result<T>();
        StatusLine statusLine = response.getStatusLine();
        HttpEntity entity = response.getEntity();
        if (statusLine.getStatusCode() != 200) {
            EntityUtils.consume(entity);
            rs.setFailure(statusLine.getReasonPhrase());
            return rs;
        }
        String text = EntityUtils.toString(entity, Consts.UTF_8);
        EntityUtils.consume(entity);
        if (text == null) {
            rs.setFailure("服务器无数据返回");
            return rs;
        }
        return handleResponse(rs, text.replaceAll("[\r|\n|\t]", ""));
    }

    protected Result<T> handleResponse(Result<T> rs, String text) {
        return rs;
    }

}
