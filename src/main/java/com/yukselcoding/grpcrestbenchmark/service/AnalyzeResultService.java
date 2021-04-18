package com.yukselcoding.grpcrestbenchmark.service;


import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.yukselcoding.grpcrestbenchmark.dto.Response;
import com.yukselcoding.proto.Benchmarks;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

@Service
public class AnalyzeResultService {
    public Response get(int runs) throws UnirestException, IOException {
        getJson();
        getProtobuf();

        long protobufTimes = 0;
        long jsonTimes = 0;

        for (int i = 0; i < runs; i++) {
            protobufTimes += getProtobuf();
            jsonTimes += getJson();
        }
        long totalProtobuf = protobufTimes / runs;
        long totalJson = jsonTimes / runs;
        return new Response(String.format("%s ms", totalProtobuf), String.format("%s ms", totalJson));
    }

    private long getProtobuf() throws UnirestException, IOException {
        long start = (new Date()).getTime();
        Benchmarks benchmarks = Benchmarks.parseFrom(Unirest.get("http://localhost:8080/protobuf/benchmarks").asBinary().getRawBody());
        long time = (new Date()).getTime() - start;
        System.out.println("protobuf took " + time + "ms to load " + benchmarks.getBenchmarksList().size() + " benchmarks.");
        return time;
    }

    private long getJson() throws UnirestException, InvalidProtocolBufferException {
        long start = (new Date()).getTime();
        Benchmarks.Builder benchmarks = Benchmarks.newBuilder();
        JsonFormat.parser()
                .merge(Unirest.get("http://localhost:8080/json/benchmarks")
                        .asString().getBody(), benchmarks);
        long time = (new Date()).getTime() - start;
        System.out.println("json took " + time + "ms to load " +  benchmarks.getBenchmarksList().size() + " benchmarks.");
        return time;
    }
}
