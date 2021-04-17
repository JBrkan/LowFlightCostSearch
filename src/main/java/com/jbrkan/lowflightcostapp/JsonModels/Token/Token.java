package com.jbrkan.lowflightcostapp.JsonModels.Token;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Token {
    private String username;
    @JsonProperty("application_name")
    private String applicationName;
    @JsonProperty("client_id")
    private String clientId;
    @JsonProperty("token_type")
    private String tokenType;
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("expires_in")
    private int expiresIn;
    private String state;
    private String scope;

    public Token() {
    }

    public String getUsername() {
        return username;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public String getClientId() {
        return clientId;
    }

    public String getTokenType() {
        return tokenType;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public String getState() {
        return state;
    }

    public String getScope() {
        return scope;
    }
}


