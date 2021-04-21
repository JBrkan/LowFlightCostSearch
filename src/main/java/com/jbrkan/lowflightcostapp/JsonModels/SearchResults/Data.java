package com.jbrkan.lowflightcostapp.JsonModels.SearchResults;

import java.util.List;

public class Data {
    private String id;
    private Price price;
    private List<Itineraries> itineraries;


    public Data() {
    }

    public String getId() {
        return id;
    }

    public Price getPrice() {
        return price;
    }

    public List<Itineraries> getItineraries() {
        return itineraries;
    }
}
