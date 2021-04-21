package com.jbrkan.lowflightcostapp.Services.ServicesImpl;

import com.jbrkan.lowflightcostapp.JsonModels.SearchResults.Data;
import com.jbrkan.lowflightcostapp.JsonModels.SearchResults.SearchResults;
import com.jbrkan.lowflightcostapp.Services.SearchService;
import com.jbrkan.lowflightcostapp.Services.TokenService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SearchServiceImpl implements SearchService {

    public RestTemplate restTemplate;
    public TokenService tokenService;
    final static String URI = "https://test.api.amadeus.com/v2/shopping/flight-offers";

    public SearchServiceImpl(RestTemplate restTemplate, TokenService tokenService){
        this.restTemplate = restTemplate;
        this.tokenService = tokenService;
    }




    @Override
    public LinkedMultiValueMap<?,?> searchResults(
            String originLocationCode,
            String destinationLocationCode,
            String departureDate,
            String returnDate,
            int adults,
            String currencyCode) {


        if(tokenService.getToken()==null){
            tokenService.fetchToken();
        }

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type","application/json");
       httpHeaders.setBearerAuth(tokenService.getToken().getAccessToken());


       String SearchURI = URI + "?originLocationCode=" + originLocationCode +
               "&destinationLocationCode=" + destinationLocationCode +
               "&departureDate=" + departureDate +
               "&returnDate=" + returnDate +
               "&adults=" + adults +
               "&currencyCode=" + currencyCode;

       HttpEntity httpEntity = new HttpEntity(httpHeaders);

       ResponseEntity<SearchResults> responseEntity = restTemplate.exchange(SearchURI, HttpMethod.GET, httpEntity, SearchResults.class);
       MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();



       responseEntity.getBody().getData().forEach(data -> {multiValueMap.add(data.getId(), data.getPrice().getCurrency());});

       return (LinkedMultiValueMap<?, ?>) multiValueMap.get(1);
    }

}
