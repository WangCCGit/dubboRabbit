package com.it.iservice.imp;

import com.it.service.UserSV;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class UserSVImp implements UserSV {

    @Override
    public String say() {
        System.out.println("-----------");
        return "你好dubbo";
    }
}
