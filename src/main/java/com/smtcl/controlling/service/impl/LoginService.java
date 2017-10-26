package com.smtcl.controlling.service.impl;

import com.smtcl.controlling.dao.IGenericDAO;
import com.smtcl.controlling.models.controlling.*;
import com.smtcl.controlling.service.ILoginService;
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

            /**
             * 需要密码
             */
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
    public Object getApprovalAuthorityAndDefaultStorage(String name) {

        Map result = new HashMap();

        List<Map<String, String>> resultList = dao.executeQuery("select " +
                " new Map(cr.orderApprovalAuthority as orderApprovalAuthority) " +
                " from CRegist cr " +
                " where cr.name='" + name + "' ");

        String orderApprovalAuthority = resultList.get(0).get("orderApprovalAuthority");

        result.put("orderApprovalAuthority", orderApprovalAuthority);

        List<Map<String, String>> storageNo = dao.executeQuery("select " +
                " new Map(csrd.storageRoomNo as storageRoomNo) " +
                " from CRegist cr,CStorageRoomDefinition csrd " +
                " where cr.storageRoomId=csrd.storageRoomId " +
                " and cr.name='" + name + "' ");

        if (storageNo.size() > 0 && storageNo.get(0) != null) {

            result.put("storageRoomNo", storageNo.get(0).get("storageRoomNo"));

        } else {

            result.put("storageRoomNo", "");
        }
        return result;
    }

}
