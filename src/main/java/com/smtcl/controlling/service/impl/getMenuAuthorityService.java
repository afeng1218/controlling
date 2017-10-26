package com.smtcl.controlling.service.impl;

import com.smtcl.controlling.dao.IGenericDAO;
import com.smtcl.controlling.service.IgetMenuAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by guofeng on 2016/8/15.
 */
@Service
public class getMenuAuthorityService implements IgetMenuAuthorityService {

    @Autowired
    IGenericDAO dao;

    @Override
    public Object getMenuAuthority(HttpServletRequest request) {

        return null;
    }
}
