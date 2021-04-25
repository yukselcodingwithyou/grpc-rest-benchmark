package com.yukselcoding.grpcrestbenchmark.grpc;


import com.yukselcoding.grpcrestbenchmark.service.BenchmarksGenerator;
import com.yukselcoding.proto.BenchmarkServiceGrpc;
import com.yukselcoding.proto.Benchmarks;
import com.yukselcoding.proto.GetBenchmarksRequest;
import io.grpc.stub.StreamObserver;

import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GRpcService
public class GrpcEndpoint extends BenchmarkServiceGrpc.BenchmarkServiceImplBase {

    @Autowired
    private BenchmarksGenerator benchmarksGenerator;

    @Override
    public void get(GetBenchmarksRequest request, StreamObserver<Benchmarks> responseObserver) {
        responseObserver.onNext(benchmarksGenerator.generate(request.getCount()));
        responseObserver.onCompleted();
    }
}
