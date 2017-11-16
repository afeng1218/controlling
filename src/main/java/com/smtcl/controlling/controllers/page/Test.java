package com.smtcl.controlling.controllers.page;

import com.smtcl.controlling.service.ITestService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/test")
public class Test {

    @Autowired
    private ITestService service;

    @RequestMapping(value = "/setNameAndDept")
    String setNameAndDept(@RequestParam("name") String name, @RequestParam("dept") String dept,
              HttpServletRequest request) throws IOException {
        return service.setNameAndDept(name,dept);

    }

    @RequestMapping(value = "/getTestList", method = RequestMethod.GET)
    List getTestList() throws IOException {
        return service.getTestList();
    }

    @RequestMapping(value = "/deleteTest")
    String deleteTest(@RequestParam("ids")String ids)throws IOException{
        System.out.println(ids);
        return service.deleteTest(ids);
    }

    @RequestMapping(value = "findTest",method = RequestMethod.GET)
    List findTest(@RequestParam("id")String id,HttpServletRequest request)throws IOException{
        return service.findTest(id);
    }

    @RequestMapping(value = "/updateTest",method = RequestMethod.GET)
    String updateTest(@RequestParam("id")String id,@RequestParam("name")String name,@RequestParam("dept")String dept)throws IOException{
        return service.updateTest(id,name,dept);
    }

    @RequestMapping(value = "findTestByName",method = RequestMethod.GET)
    List findTestByName(@RequestParam("name")String name,HttpServletRequest request)throws IOException{
        return service.findTestByName(name);
    }

    @RequestMapping(value = "findTestByDept",method = RequestMethod.GET)
    List findTestByDept(@RequestParam("dept")String dept,HttpServletRequest request)throws IOException{
        return service.findTestByDept(dept);
    }

}
