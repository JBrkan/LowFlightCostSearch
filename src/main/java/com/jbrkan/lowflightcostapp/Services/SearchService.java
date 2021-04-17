package com.jbrkan.lowflightcostapp.Services;

import com.jbrkan.lowflightcostapp.JsonModels.SearchResults.Data;

import java.util.List;

public interface SearchService {

    List<Data> searchResults(String originLocationCode, String destinationLocationCode, String departureDate, String returnDate, String currencyCode);

}
