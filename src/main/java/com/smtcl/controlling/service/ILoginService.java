package com.smtcl.controlling.service;

import org.json.*;

/**
 * Created by guofeng on 2016/2/25. TODO 用户登录service
 */
public interface ILoginService{

	/**
	 * 验证用户名接口
	 * @param name
	 * 		用户名
	 * @param password
	 * 		密码
	 * @return 返回登陆结果 TRUE or FALSE
	 */
	String checkUser(String name, String password);
	/**
	 * 检查用户是否需要密码登陆
	 * @param name
	 * @return
	 */
	Object checkNeedPassword(String name);
	/**
	 * 获取用户审批权限
	 * @param name
	 * 		用户名
	 * @return 审批权限
	 */
	Object getApprovalAuthorityAndDefault(String name);
}
