package com.jbrkan.lowflightcostapp.JsonModels;

public class Token {
    private String username;
    private String application_name;
    private String client_id;
    private String token_type;
    private String access_token;
    private int expires_in;
    private String state;
    private String scope;

    public Token() {
    }

    public String getUsername() {
        return username;
    }

    public String getApplication_name() {
        return application_name;
    }

    public String getClient_id() {
        return client_id;
    }

    public String getToken_type() {
        return token_type;
    }

    public String getAccess_token() {
        return access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public String getState() {
        return state;
    }

    public String getScope() {
        return scope;
    }
}


