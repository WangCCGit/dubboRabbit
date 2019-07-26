package com.it.controller;

import com.it.service.UserSV;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController implements UserSV{

    @Reference(version = "1.0.0")
    private UserSV userSV;

    @RequestMapping(value = "say",method = RequestMethod.GET)
    public String get(){
        return userSV.say();
    }

    @Override
    @RequestMapping(value = "say/s",method = RequestMethod.GET)
    public String say() {
        return userSV.say();
    }
}
