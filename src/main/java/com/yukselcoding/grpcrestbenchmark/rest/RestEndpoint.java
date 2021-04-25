package com.yukselcoding.grpcrestbenchmark.rest;


import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import com.yukselcoding.grpcrestbenchmark.service.BenchmarksGenerator;
import com.yukselcoding.proto.Benchmarks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestEndpoint {

    @Autowired
    private BenchmarksGenerator benchmarksGenerator;

    @GetMapping("/{count}")
    public ResponseEntity<?> get(@PathVariable("count") Long count) throws InvalidProtocolBufferException {
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .contentType(MediaType.APPLICATION_JSON)
                .body(JsonFormat.printer().print(benchmarksGenerator.generate(count)));
    }
}
