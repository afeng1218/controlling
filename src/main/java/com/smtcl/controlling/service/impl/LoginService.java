package com.smtcl.controlling.service.impl;

import com.smtcl.controlling.dao.IGenericDAO;
import com.smtcl.controlling.models.controlling.*;
import com.smtcl.controlling.service.ILoginService;
import org.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by guofeng on 2016/2/25.
 */
@Service
public class LoginService implements ILoginService {

    @Autowired
    private IGenericDAO dao;

    @Override
    public String checkUser(String name, String password) {
        List<CRegist> resultList = dao.executeQuery("from CRegist cr where cr.name='" + name + "'");
        if (resultList.size() > 0) {
            CRegist regist = resultList.get(0);
            /*** 需要密码 ***/
            if (regist.getNeedPasswordOrnot().equals("是")) {
                if (regist.getPassword().equals(password)) {
                    return name + ":TRUE";
                } else {
                    return name + ":FALSE";
                }
            } else {
                return name + ":TRUE";
            }
        } else {
            return name + ":FALSE";
        }
    }
    @Override
    public Object checkNeedPassword(String name) {
        JSONObject result = new JSONObject();
        try {
            List<CRegist> list = dao.executeQuery("from CRegist cr where cr.name='" + name + "'");
            if (list.size() > 0 && list.get(0) != null) {
                CRegist regist = list.get(0);
                if (regist.getNeedPasswordOrnot().equals("是")) {
                    result.append("result", "true");
                } else {
                    result.append("result", "false");
                }
            } else {
                result.append("result", "true");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.append("result", e.getMessage());
        }
        return result.toString();
    }
	/**
	 * 获取权限
     * @param name
     * 		用户名
     *
     * @return
     */
    @Override
    public Object getApprovalAuthorityAndDefault(String name) {
        Map result = new HashMap();
        List<Map<String, String>> resultList = dao.executeQuery("select " +
                " new Map(cr.orderApprovalAuthority as orderApprovalAuthority) " +
                " from CRegist cr " +
                " where cr.name='" + name + "' ");

        String orderApprovalAuthority = resultList.get(0).get("orderApprovalAuthority");
        result.put("orderApprovalAuthority", orderApprovalAuthority);
        /**
         * 获取用户页面权限
         */
        if (!name.equals("admin")) {

            List list = dao.executeQuery("select new Map(cam.linkPage as linkPage,caa.authority as authority) " +
                    "from CAccountAuthority caa,CAuthorityMenu cam " +
                    " where caa.id.functionNode=cam.nodeId " +
                    " and caa.id.account='" + name + "' " +
                    " and caa.authority=1" );

            result.put("pageAuthority", list);
        }
        return result;
    }

}
