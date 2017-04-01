package net.zhanqi.app.cas.extend;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.zhanqi.sshe.frame.core.BaseComponent;
import org.jasig.cas.authentication.principal.Service;
import org.jasig.cas.services.RegexRegisteredService;
import org.jasig.cas.services.RegisteredService;
import org.jasig.cas.services.RegisteredServiceImpl;
import org.jasig.cas.services.ServicesManager;
import org.jasig.cas.support.oauth.services.OAuthRegisteredService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JdbcServicesManager extends BaseComponent implements ServicesManager {

    private static final Logger logger = LoggerFactory
            .getLogger(JdbcServicesManager.class);

    @Override
    public RegisteredService save(RegisteredService service) {
        logger.info("Adding registered service {}", service.getServiceId());
        return null;
    }

    @Override
    public RegisteredService findServiceBy(Service service) {

        if (service == null) {
            return null;
        }

        Collection<RegisteredService> retList = getAllServices();

        for (RegisteredService rs : retList) {
            if (service.getId().equals(rs.getServiceId())) {
                return rs;
            }
        }

        return null;
    }

    @Override
    public Collection<RegisteredService> getAllServices() {

        List<RegisteredService> retList = new ArrayList<RegisteredService>();

        StringBuilder sb = new StringBuilder();
        // allowedattributes,expressiontype,requiredHandlers
        sb.append("select serviceid id, serviceurl serviceId, name, theme, description,");
        sb.append(" enabled, ssoenabled ssoEnabled, allowedtoproxy allowedToProxy,");
        sb.append(" anonymousaccess anonymousAccess, evaluationorder evaluationOrder,");
        sb.append(" ignoreattributes ignoreAttributes, usernameattribute usernameAttribute,");
        sb.append(" clientid clientId, clientsecret clientSecret");
        sb.append(" from cas_registered_service where servicetype=?");

        List<RegexRegisteredService> rrsList = getDao().queryList(sb.toString(),
                RegexRegisteredService.class, "1");

        List<RegisteredServiceImpl> rsList = getDao().queryList(sb.toString(),
                RegisteredServiceImpl.class, "2");

        List<OAuthRegisteredService> orsList = getDao().queryList(sb.toString(),
                OAuthRegisteredService.class, "3");

        retList.addAll(rrsList);
        retList.addAll(rsList);
        retList.addAll(orsList);

        return retList;
    }

    @Override
    public boolean matchesExistingService(Service service) {
        return findServiceBy(service) != null;
    }

    @Override
    public RegisteredService delete(long id) {
        throw new RuntimeException("not implement!");
    }

    @Override
    public RegisteredService findServiceBy(long id) {
        throw new RuntimeException("not implement!");
    }
}
