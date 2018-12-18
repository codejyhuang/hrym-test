package com.payease;

import com.payease.controller.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlApplicationTests {
    
    @Autowired
    private UserController userController;
   
    @Test
    public void contextLoads() {
    }
    
    @Test
    public void ss(){
        System.setProperty("es.set.netty.runtime.available.processors", "false");
    
        userController.findAllUser();
    }
}
