package com.yunxie.controllers;

import com.yunxie.models.Test;
import com.yunxie.repositories.TestRepository;
import com.yunxie.repositories.TestXMLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by WXH on 2017/11/20.
 */

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    TestRepository testRepository;

    @Autowired
    TestXMLRepository testXMLRepository;

    @RequestMapping("test")
    public Test test(){
        Test test = new Test();
        test.setId(Long.valueOf(1));
        test.setName("张三");
        return test;

    }

    @RequestMapping("getTest")
    public Test getTest(Long id){
        return testRepository.getById(id);

    }

    @RequestMapping("getTest1")
    public Test getTest1(Integer id){
        return testXMLRepository.selectByPrimaryKey(id);

    }

}
