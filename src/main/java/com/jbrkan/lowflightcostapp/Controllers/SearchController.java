package com.jbrkan.lowflightcostapp.Controllers;

import com.jbrkan.lowflightcostapp.JsonModels.SearchResults.Data;
import com.jbrkan.lowflightcostapp.Services.ServicesImpl.SearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SearchController {

    private SearchServiceImpl searchService;

    public SearchController(SearchServiceImpl searchService){
        this.searchService = searchService;
    }

    @GetMapping("/search")
    public List<Data> getSearchResults(
            @RequestParam(name ="olc") String olc,
            @RequestParam(name="dlc") String dlc,
            @RequestParam(name="date")String date,
            @RequestParam(name="adults") int adults,
            @RequestParam(name="currency")String currency
            ){
        return searchService.searchResults(olc,dlc,date,adults,currency);
    }
}
