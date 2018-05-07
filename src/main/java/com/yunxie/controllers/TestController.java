package com.yunxie.controllers;

import com.yunxie.models.Test;
import com.yunxie.repositories.TestRepository;
import com.yunxie.repositories.TestXMLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by WXH on 2017/11/20.
 */

@Controller
@RequestMapping("test")
public class TestController {

    @Autowired
    TestRepository testRepository;

    @Autowired
    TestXMLRepository testXMLRepository;

    @RequestMapping("test")
    @ResponseBody
    public Test test(){
        Test test = new Test();
        test.setId(Long.valueOf(1));
        test.setName("张三");
        return test;

    }

    @RequestMapping("getTest")
    @ResponseBody
    public Test getTest(Long id){
        return testRepository.getById(id);

    }

    @RequestMapping("getTest1")
    @ResponseBody
    public Test getTest1(Integer id){
        return testXMLRepository.selectByPrimaryKey(id);

    }


    //跳转页面
    @RequestMapping("index")
    public String index(){
        return "test/index";
    }

}
