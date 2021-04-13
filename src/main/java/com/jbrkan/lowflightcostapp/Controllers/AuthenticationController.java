package com.jbrkan.lowflightcostapp.Controllers;

import com.jbrkan.lowflightcostapp.Services.ServicesImpl.TokenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

    @Autowired
    TokenServiceImpl tokenServiceImpl;

    @GetMapping("/hello")
    public String getHello(){
        return "Hello";
    }

    @GetMapping("/Token")
    public String getToken(){
        return tokenServiceImpl.getToken();
    }


}
