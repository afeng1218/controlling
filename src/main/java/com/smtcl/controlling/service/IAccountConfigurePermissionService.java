package com.smtcl.controlling.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Created by guofeng on 2016/7/21.
 */
public interface IAccountConfigurePermissionService{

	/**
	 * 检查用户是否存在
	 * @param name
	 * @return
	 */
	Object checkUser(String name);

	/**
	 * 检查用户是否需要密码登陆
	 * @param name
	 * @return
	 */
	Object checkNeedPassword(String name);
}
