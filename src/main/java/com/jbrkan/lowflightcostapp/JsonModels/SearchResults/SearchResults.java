package com.jbrkan.lowflightcostapp.JsonModels.SearchResults;

import java.util.ArrayList;

public class SearchResults {

    private Meta meta;
    private ArrayList<Data> data;

    public SearchResults() {
    }

    public Meta getMeta() {
        return meta;
    }

    public ArrayList<Data> getData() {
        return data;
    }
}
