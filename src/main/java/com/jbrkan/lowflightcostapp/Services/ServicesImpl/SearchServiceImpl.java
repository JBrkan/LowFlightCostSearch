package com.jbrkan.lowflightcostapp.Services.ServicesImpl;

import com.jbrkan.lowflightcostapp.JsonModels.SearchResults.Data;
import com.jbrkan.lowflightcostapp.JsonModels.SearchResults.SearchResults;
import com.jbrkan.lowflightcostapp.JsonModels.Token;
import com.jbrkan.lowflightcostapp.Services.SearchService;
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
import org.springframework.web.util.UriBuilder;

import java.util.Date;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    public RestTemplate restTemplate;
    public TokenService tokenService;

    public SearchServiceImpl(RestTemplate restTemplate, TokenService tokenService){
        this.restTemplate = restTemplate;
        this.tokenService = tokenService;
    }


    final static String URI = "https://test.api.amadeus.com/v2/shopping/flight-offers";

    @Override
    public List<Data> searchResults(
            String originLocationCode,
            String destinationLocationCode,
            String departureDate,
            int adults,
            String currencyCode) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type","application/json");
       httpHeaders.setBearerAuth(tokenService.token.getAccess_token());

       String SearchURI = URI + "?originLocationCode=" + originLocationCode +
               "&destinationLocationCode=" + destinationLocationCode +
               "&departureDate=" + departureDate +
               "&adults=" + adults +
               "&currencyCode=" + currencyCode;

       HttpEntity<HttpHeaders> httpEntity = new HttpEntity(httpHeaders);

       ResponseEntity<SearchResults> responseEntity = restTemplate.exchange(SearchURI, HttpMethod.GET, httpEntity, SearchResults.class);

       return responseEntity.getBody().getData();
    }

}
