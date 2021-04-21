package com.jbrkan.lowflightcostapp.Controllers;

import com.jbrkan.lowflightcostapp.Exceptions.TokenNotFoundException;
import com.jbrkan.lowflightcostapp.Services.TokenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

    TokenService tokenService;

    public AuthenticationController(TokenService tokenService){
        this.tokenService = tokenService;
    }

    @GetMapping("/Token")
    public String getToken(){
        throw new TokenNotFoundException("gas");

    }


}
