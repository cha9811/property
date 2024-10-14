package com.example.property.property;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiResponse {
    @JsonProperty("response")
    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}