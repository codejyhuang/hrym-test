package com.payease.controller;

import com.payease.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hrym13 on 2018/3/31.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

//    @Value("${server.cupSize}")
//    private String cupSize;
    @Autowired
    private GirlProperties girlProperties;
    @GetMapping({"/say","/api"})
    public String say(@RequestParam (value = "id",required = false, defaultValue = "0") Integer myid ){
//        return girlProperties.toString();
        return "id:"+myid;
    }
}
