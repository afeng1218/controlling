package com.smtcl.controlling.controllers.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by guofeng on 2016/2/20.
 */
@Controller
public class WelcomeAndError {

    /*默认跳转欢迎页面*/
    @RequestMapping("/")
    String home() {
        return "redirect:/login.html";
    }
}
