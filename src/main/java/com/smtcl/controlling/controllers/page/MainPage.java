package com.smtcl.controlling.controllers.page;

import com.smtcl.controlling.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

/**
 * Created by guofeng on 2017/11/01. TODO 主页面：获取不同用户权限信息、用户退出操作
 */
@Controller
@RequestMapping("/main")
public class MainPage{
	/**
	 * 主页面service接口
	 */
	@Autowired
	IMainPageService service;
	/**
	 * 根据用户名获取权限菜单
	 * @param username 用户名
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/authority", method = RequestMethod.GET)
	public String getAuthorityMenu(@RequestParam("username") String username){
		return service.getAuthorityMenu(username, 0);
	}
	/**
	 * 获取子节点
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getMenuButton", method = RequestMethod.GET)
	public String getMenuButton(@RequestParam("id") String id){
		return service.getMenuButton(id);
	}
}
