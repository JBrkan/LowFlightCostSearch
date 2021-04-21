package com.jbrkan.lowflightcostapp.JsonModels.SearchResults;


import java.util.List;

public class SearchResults {

    private Meta meta;
    private List<Data> data;

    public SearchResults() {
    }

    public Meta getMeta() {
        return meta;
    }

    public List<Data> getData() {
        return data;
    }
}
