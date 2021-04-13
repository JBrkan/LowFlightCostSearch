package com.jbrkan.lowflightcostapp.Services.ServicesImpl;

import com.jbrkan.lowflightcostapp.JsonModels.Token;
import com.jbrkan.lowflightcostapp.Services.TokenService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


@Service
public class TokenServiceImpl implements TokenService {
    
    final static String URI = "https://test.api.amadeus.com/v1/security/oauth2/token";
    
    @Override
    public String getToken() {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("Content-Type", "application/x-www-form-urlencoded");

    MultiValueMap body = new LinkedMultiValueMap();
    body.add("grant_type", "client_credentials");
    body.add("client_id","CLIENT_ID");
    body.add("client_secret","CLIENT_SECRET");


    RestTemplate restTemplate = new RestTemplate();
    HttpEntity httpEntity = new HttpEntity(body, httpHeaders);
    ResponseEntity<Token> responseEntity = restTemplate.exchange(URI, HttpMethod.POST,httpEntity,Token.class);

    return responseEntity.getBody().getAccess_token();
    }
}
