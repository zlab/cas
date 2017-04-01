package net.zhanqi.app.cas.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterAction {

    @RequestMapping("/register")
    public String register() throws Exception {
        return "casRegister";
    }
}
