package com.smtcl.controlling.service;

import java.util.List;

public interface ITestService {
    /**
    * @Title: zhangtianhan
    * @Description: 新增表格数据方法
    * @return String
    */
    String setNameAndDept(String name,String dept);
    /**
    * @Title: zhangtianhan
    * @Description: 查询表格数据
    * @return List
    */
    List getTestList();
    List findTest(String id);
    List findTestByName(String name);
    List findTestByDept(String dept);
    /**
    * @Title: zhangtianhan
    * @Description:
    * @return
    */
    String deleteTest(String id);
    /**
    * @Title: zhangtianhan
    * @Description:
    * @return
    */
    String updateTest(String id,String name,String dept);
}
