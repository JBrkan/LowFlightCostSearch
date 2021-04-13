package com.jbrkan.lowflightcostapp.Services.ServicesImpl;

import com.jbrkan.lowflightcostapp.Services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;

import java.util.List;

public class SearchServiceImpl implements SearchService {

    @Autowired
    TokenServiceImpl tokenService;
    @Autowired
    HttpHeaders httpHeaders;

    @Override
    public List searchByIATI() {
       String token = tokenService.getToken();
       httpHeaders.setBearerAuth(token);




       return null;
    }

    @Override
    public List searchByDate() {
        return null;
    }

    @Override
    public int searchByPassengerCount() {
        return 0;
    }
}
