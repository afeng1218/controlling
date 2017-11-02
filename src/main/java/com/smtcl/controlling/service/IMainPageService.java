package com.smtcl.controlling.service;
/**
 * Created by guofeng on 2017/11/01. TODO 主页面service接口
 */
public interface IMainPageService{
	/**
	 * 获取用户权限信息
	 * @param username
	 * 		用户名
	 * @return 用户权限菜单信息
	 */
	String getAuthorityMenu(String username, Integer getAll);
	/**
	 * 获取子节点
	 * @param id
	 * @return
	 */
	String getMenuButton(String id);
}
