package com.smtcl.controlling.service.impl;

import com.smtcl.controlling.dao.*;
import com.smtcl.controlling.models.controlling.*;
import com.smtcl.controlling.service.*;
import org.json.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.Lifecycle;
import org.springframework.stereotype.*;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * Created by guofeng on 2016/7/21.
 */
@Service
public class AccountConfigurePermissionService implements IAccountConfigurePermissionService {

    @Autowired
    IGenericDAO dao;

    @Override
    public Object checkUser(String name) {

        JSONObject result = new JSONObject();
        try {

            List list = dao.executeQuery("select cr.name from CRegist cr where cr.name='" + name + "'");
            if (list.size() > 0 && list.get(0) != null) {

                result.append("result", "true");

            } else {

                result.append("result", "false");
            }

        } catch (Exception e) {

            e.printStackTrace();
            result.append("result", e.getMessage());
        }
        return result.toString();
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
}
