package com.payease.controller;

import com.payease.domain.Result;
import com.payease.entity.Girl;
import com.payease.respository.GirlResposity;
import com.payease.service.GirlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by hrym13 on 2018/3/31.
 */
@RestController
public class GirlController {

    //日志
    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);


    @Autowired
    private GirlService girlService;



    @Autowired
    private GirlResposity girlResposity;
    

    @GetMapping("/getGirls")
    public List<Girl> girls(){
        logger.info("girlList方法！");
        return girlService.findAll();
    }


    /**
     * 创建一个女生
     */
    @PostMapping("/getGirls")
    public Girl girlAdd(@RequestParam("cupSize")String cupSize,
                        @RequestParam("age")Integer age){
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlService.save(girl);
    }
    /**
     * 通过ID查询一个女生
     */
    @PostMapping("/girls/{id}")
    public Girl getgirl(@PathVariable("id")Integer id){
        return girlService.findById(id).orElse(null);
    }

    /**
     * 通过ID更新一个女生
     */
    @PutMapping("/girls/{id}")
    public Girl girlUpdate  (@PathVariable("id")Integer id,
                             @RequestParam("cupSize") String cupSize,
                             @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlService.save(girl);
    }

//    /**
//     * 通过ID删除一个女生
//     */
//    @DeleteMapping("/girls/{id}")
//    public void girlDelete(@PathVariable("id")Integer id){
//        girlService.delete(id);
//    }

    /**
     * 通过年龄查询女生列表
     */
//    @GetMapping("/girls/age/{age}")
//    public List<Girl> girlListByAge(@PathVariable("age")Integer age){
//        return girlService.findByAge(age);
//    }

}
