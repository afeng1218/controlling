package com.smtcl.controlling.controllers.page;

import com.smtcl.controlling.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

/**
 * Created by guofeng on 2016/6/1.
 */
@RestController
@ResponseBody
@RequestMapping("/accountConfigurePermission")
public class AccountConfigurePermission {

    @Autowired
    IAccountConfigurePermissionService iAccountConfigurePermissionService;

    /**
     * 检查用户是否存在
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/checkUser", method = RequestMethod.GET)
    Object checkUser(@RequestParam("name") String name) {

        return iAccountConfigurePermissionService.checkUser(name);
    }

    /**
     * 检查用户是否需要密码登陆
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/checkNeedPassword", method = RequestMethod.GET)
    Object checkNeedPassword(@RequestParam("name") String name) {

        return iAccountConfigurePermissionService.checkNeedPassword(name);
    }
}
