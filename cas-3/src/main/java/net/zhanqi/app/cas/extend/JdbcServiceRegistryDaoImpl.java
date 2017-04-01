package net.zhanqi.app.cas.extend;

import java.util.List;

import net.zhanqi.lib.component.sys.DaoInfo;
import net.zhanqi.lib.component.sys.impl.HibernateDaoInfoImpl;

import org.jasig.cas.services.RegisteredService;
import org.jasig.cas.services.ServiceRegistryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class JdbcServiceRegistryDaoImpl implements ServiceRegistryDao {
    
    private DaoInfo dao;
    
    @Autowired
    public void setDao(HibernateDaoInfoImpl dao) {
        this.dao = dao;
    }

    @Override
    public RegisteredService save(RegisteredService registeredService) {
        if (registeredService.getId() == -1) {
            dao.insert(registeredService);
        } else {
            dao.update(registeredService);
        }
        
        return registeredService;
    }

    @Override
    public boolean delete(RegisteredService registeredService) {
        dao.delete(registeredService);
        return true;
    }

    @Override
    public List<RegisteredService> load() {
        return dao.list(RegisteredService.class);
    }

    @Override
    public RegisteredService findServiceById(long id) {
        return dao.unique(RegisteredService.class, id);
    }

}
