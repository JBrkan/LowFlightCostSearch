package com.jbrkan.lowflightcostapp.Services;

import java.util.List;

public interface SearchService {

    public List searchByIATI();
    public List searchByDate();
    public int searchByPassengerCount();
}
