package com.smtcl.controlling.controllers.util;

/**
 * Created by guofeng on 2016/4/12.
 */
public class UUID{

	/**
	 * 生成UUID
	 * @param args 参数
	 */
	public static void main(String args[]){

		String uuid = java.util.UUID.randomUUID().toString().replace("-","");

		System.out.println(uuid);
	}
}
