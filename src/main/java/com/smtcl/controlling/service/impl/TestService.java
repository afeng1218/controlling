package com.smtcl.controlling.service.impl;

import com.smtcl.controlling.dao.IGenericDAO;
import com.smtcl.controlling.models.controlling.CTest;
import com.smtcl.controlling.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService implements ITestService {

    @Autowired
    private IGenericDAO dao;

    @Override
    public String setNameAndDept(String name, String dept) {

        String sql = "insert into c_test_demo(name,dept) values('" + name + "','" + dept + "')";
        dao.sqlUpdate(sql);
// dao.sqlUpdate(sql;sql=null;
        return "true";
    }

    @Override
    public List getTestList() {
        String sql = "select ct.id,ct.name,ct.dept from c_test_demo ct where 1=1";
        return dao.createSQL(sql);
    }

    /**
     * @return
     * @Title: zhangtianhan
     * @Description:
     */
    @Override
    public String deleteTest(String id) {
        String sql = "delete from c_test_demo where id in (" + id + ")";
        dao.sqlUpdate(sql);
        return "true";
    }

    /**
     * @return
     * @Title: zhangtianhan
     * @Description:
     */
    @Override
    public String updateTest(String id, String name, String dept) {

        String sql = "update c_test_demo set name ='" + name + "',dept ='"+dept+"' where id = '" + id + "'";
        dao.sqlUpdate(sql);
        return "true";
    }

    @Override
    public List findTest(String id) {
        String sql = "select id,name,dept from c_test_demo where id = '" + id + "'";
        return dao.createSQL(sql);
    }

    @Override
    public List findTestByName(String name) {
        String sql = "select id,name,dept from c_test_demo where name = '" + name + "'";
        return dao.createSQL(sql);
    }

    @Override
    public List findTestByDept(String dept) {
        String sql = "select id,name,dept from c_test_demo where dept = '" + dept + "'";
        return dao.createSQL(sql);
    }
}