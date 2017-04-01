package net.zhanqi.app.cas.extend;

import net.zhanqi.sshe.frame.core.BaseComponent;
import net.zhanqi.sshe.frame.core.BusinessException;
import org.jasig.cas.services.RegexRegisteredService;
import org.jasig.cas.services.RegisteredService;
import org.jasig.cas.services.RegisteredServiceImpl;
import org.jasig.cas.services.ServiceRegistryDao;
import org.jasig.cas.support.oauth.services.OAuthRegisteredService;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
public class JdbcServiceRegistryDaoImpl extends BaseComponent implements
        ServiceRegistryDao {

    @Override
    public RegisteredService save(RegisteredService registeredService) {
        throw new BusinessException("JdbcServiceRegistryDaoImpl.save");
    }

    @Override
    public boolean delete(RegisteredService registeredService) {
        throw new BusinessException("JdbcServiceRegistryDaoImpl.delete");
    }

    @Override
    public List<RegisteredService> load() {
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
    public RegisteredService findServiceById(long id) {
        List<RegisteredService> retList = load();

        for (RegisteredService service : retList) {
            if (service.getId() == id) {
                return service;
            }
        }

        return null;
    }

}
