package net.zhanqi.app.cas.service.impl;

import net.zhanqi.app.cas.service.UserService;

import net.zhanqi.sshe.frame.core.BaseComponent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl extends BaseComponent implements UserService {

    @Override
    public void active(String email, String activeKey) {

    }
}
