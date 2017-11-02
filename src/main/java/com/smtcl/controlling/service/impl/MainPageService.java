package com.smtcl.controlling.service.impl;

import com.smtcl.controlling.dao.*;
import com.smtcl.controlling.models.controlling.*;
import com.smtcl.controlling.service.*;
import org.json.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;
/**
 * Created by guofeng on 2017/11/01.
 */
@Service
public class MainPageService implements IMainPageService{
	@Autowired
	IGenericDAO dao;

	/*根据用户账号 查询用户权限信息*/
	@Override
	public String getAuthorityMenu(String username, Integer getAll){
		/*取出首尾空格*/
		username = username.trim();
		/*返回数据*/
		JSONObject returnData = new JSONObject();
		/*根据用户权限遍历菜单节点信息*/
		String json="";
		/*根据用户名查找权限信息*/
		/**********************遍历整个树信息******************************/
		List<CAuthorityMenu> list = dao.executeQuery("from CAuthorityMenu cam where cam.nodeId>0 and cam.PNode='-999' order by cam.nodeId asc");
		if(list.size()>0){
			returnData.put("id",list.get(0).getNodeId());
			returnData.put("name",list.get(0).getNodeName());
		};
		for (int i=0;i<list.size();i++){
			json+="<div class='col-md-3 menuClick' data='"+list.get(i).getNodeId()+"'>"+list.get(i).getNodeName()+"</div>";
		};list=null;
        /*获取账号订单审批权限*/
		List<CRegist> cRegists = dao.executeQuery("from CRegist crt where crt.name='" + username + "'");
		if (cRegists.size() > 0 && cRegists.get(0) != null){
			returnData.append("applyAuthority", cRegists.get(0).getOrderApprovalAuthority());/*审批权限*/
		};cRegists=null;
		/*限菜单数据*/
		returnData.append("json", json);json=null;
		return returnData.toString();
	}
	/**
	 * 获取子节点
	 * @param id
	 * @return
	 */
	@Override
	public String getMenuButton(String id){
		try{
			List<CAuthorityMenu> list = dao.executeQuery("from CAuthorityMenu cam where cam.PNode='"+id+"' order by cam.nodeId asc");
			JSONArray obj=new JSONArray();
			for (int i=0;i<list.size();i++){
				HashMap map=new HashMap();
				map.put("title",list.get(i).getNodeName());
				map.put("name",list.get(i).getNodeName());
				map.put("url",list.get(i).getLinkPage().equals("")?"null.html":list.get(i).getLinkPage());
				if(i>0){
					map.put("style","margin-left:15px;");
				};
				obj.put(i,map);
			};
			return obj.toString();
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
