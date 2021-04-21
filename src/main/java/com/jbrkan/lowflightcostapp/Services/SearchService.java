package com.jbrkan.lowflightcostapp.Services;

import com.jbrkan.lowflightcostapp.JsonModels.SearchResults.Data;
import org.springframework.util.LinkedMultiValueMap;

import java.util.List;

public interface SearchService {

    LinkedMultiValueMap searchResults(String originLocationCode, String destinationLocationCode, String departureDate, String returnDate, int adults, String currencyCode);

}
