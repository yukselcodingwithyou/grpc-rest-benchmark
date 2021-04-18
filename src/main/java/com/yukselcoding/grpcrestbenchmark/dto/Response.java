package com.yukselcoding.grpcrestbenchmark.dto;

public class Response {
    private String protobufAverage;
    private String jsonAverage;

    public Response(String protobufAverage, String jsonAverage) {
        this.protobufAverage = protobufAverage;
        this.jsonAverage = jsonAverage;
    }

    public String getProtobufAverage() {
        return protobufAverage;
    }

    public String getJsonAverage() {
        return jsonAverage;
    }
}
