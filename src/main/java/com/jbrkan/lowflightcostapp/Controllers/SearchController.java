package com.jbrkan.lowflightcostapp.Controllers;

import com.jbrkan.lowflightcostapp.Exceptions.TokenNotFoundException;
import com.jbrkan.lowflightcostapp.JsonModels.SearchResults.Data;
import com.jbrkan.lowflightcostapp.Services.SearchService;
import com.jbrkan.lowflightcostapp.Services.TokenService;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SearchController {

    private final SearchService searchService;
    public SearchController(SearchService searchService){
        this.searchService = searchService;
    }

    @GetMapping("/hello")
    public String helloWorld(){
        return "hello";
    }

    @GetMapping("/search")
    public LinkedMultiValueMap<?,?> getSearchResults(
            @RequestParam(name = "olc") String olc,
            @RequestParam(name = "dlc") String dlc,
            @RequestParam(name = "date") String date,
            @RequestParam(name = "rDate") String rDate,
            @RequestParam(name = "currency") String currency
    )
    {

        int adults = 1;
        return searchService.searchResults(olc,dlc,date,rDate, adults,currency);
    }
}
