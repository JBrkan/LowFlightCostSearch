package com.jbrkan.lowflightcostapp.Services;

import java.util.List;

public interface SearchService {

    public List<? extends Object> searchResults(String originLocationCode, String destinationLocationCode, String departureDate, int Adults, String currencyCode);

}
