package net.zhanqi.app.cas.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloAction {

    @RequestMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @RequestMapping("/sayHello")
    public String sayHello(String name, Model mode) {
        mode.addAttribute("msg", "测试");
        return "hello";
    }

}
