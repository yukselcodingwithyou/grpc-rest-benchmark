package com.yukselcoding.grpcrestbenchmark.protovsjson;


import com.mashape.unirest.http.exceptions.UnirestException;
import com.yukselcoding.grpcrestbenchmark.dto.Response;
import com.yukselcoding.grpcrestbenchmark.service.AnalyzeResultService;
import com.yukselcoding.proto.Benchmarks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ProtoVsJsonEndpoint {

    @Autowired
    private Benchmarks benchmarks;

    @Autowired
    private AnalyzeResultService resultService;

    @RequestMapping(path = "/protobuf/benchmarks", method= RequestMethod.GET, produces = "application/x-protobuf")
    public Benchmarks getBenchmarksProto() {
        return benchmarks;
    }

    @RequestMapping(path = "/json/benchmarks", method= RequestMethod.GET, produces = "application/json")
    public Benchmarks getBenchmarksJSON() {
        return benchmarks;
    }


    @RequestMapping(path = "/b2b/result/{runs}", method= RequestMethod.GET)
    public Response b2bGetResults(@PathVariable("runs") int runs) throws UnirestException, IOException {
        return resultService.get(runs);
    }
}
