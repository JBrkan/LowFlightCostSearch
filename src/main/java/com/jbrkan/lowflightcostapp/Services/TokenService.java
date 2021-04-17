package com.jbrkan.lowflightcostapp.Services;


import com.jbrkan.lowflightcostapp.JsonModels.Token.Token;

public interface TokenService {
    public abstract Token getToken();
    void setToken(Token token);
    public abstract String fetchToken();
}
