package com.jbrkan.lowflightcostapp.Services.ServicesImpl;

import com.jbrkan.lowflightcostapp.JsonModels.Token.Token;
import com.jbrkan.lowflightcostapp.Services.TokenService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class TokenServiceImpl implements TokenService {

    private final RestTemplate restTemplate;
    private Token token;
    final static String URI = "https://test.api.amadeus.com/v1/security/oauth2/token";

    public TokenServiceImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public void setToken(Token token){this.token = token;}
    @Override
    public Token getToken() {
        return token;
    }


    @Override
    public String fetchToken() {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/x-www-form-urlencoded");

        LinkedMultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "client_credentials");
        body.add("client_id","Gx47ZZBcvKDmDNQPAiSv7gPTUOyETMXb");
        body.add("client_secret","oNu9vK8Jeru8OETw");


        RestTemplate restTemplate = new RestTemplate();
        HttpEntity httpEntity = new HttpEntity(body, httpHeaders);

        ResponseEntity<Token> responseEntity = restTemplate.exchange(URI, HttpMethod.POST,httpEntity,Token.class);

        this.setToken(responseEntity.getBody());

        return "Token dohvacen";
    }

}
