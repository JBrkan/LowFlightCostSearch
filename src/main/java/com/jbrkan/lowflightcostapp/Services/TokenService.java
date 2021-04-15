package com.jbrkan.lowflightcostapp.Services;

import com.jbrkan.lowflightcostapp.JsonModels.Token;
import com.jbrkan.lowflightcostapp.Services.ServicesImpl.SearchServiceImpl;
import com.jbrkan.lowflightcostapp.Services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


@Service
public class TokenService {

    public RestTemplate restTemplate;
    public Token token;

    public TokenService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    private void setToken(Token token){this.token = token;}


    final static String URI = "https://test.api.amadeus.com/v1/security/oauth2/token";

    public String fetchToken() {

    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("Content-Type", "application/x-www-form-urlencoded");

    LinkedMultiValueMap<String, String> body = new LinkedMultiValueMap<>();
    body.add("grant_type", "client_credentials");
    body.add("client_id","Client_ID");
    body.add("client_secret","Client_Secret");


    RestTemplate restTemplate = new RestTemplate();
    HttpEntity httpEntity = new HttpEntity(body, httpHeaders);

    ResponseEntity<Token> responseEntity = restTemplate.exchange(URI, HttpMethod.POST,httpEntity,Token.class);

    this.setToken(responseEntity.getBody());

    return "Token dohvacen";
    }
}
