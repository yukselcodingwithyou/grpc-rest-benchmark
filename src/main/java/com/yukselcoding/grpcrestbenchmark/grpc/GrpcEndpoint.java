package com.yukselcoding.grpcrestbenchmark.grpc;


import com.yukselcoding.proto.BenchmarkServiceGrpc;
import com.yukselcoding.proto.Benchmarks;
import com.yukselcoding.proto.Empty;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class GrpcEndpoint extends BenchmarkServiceGrpc.BenchmarkServiceImplBase {

    @Autowired
    private Benchmarks benchmarks;

    @Override
    public void get(Empty request, StreamObserver<Benchmarks> responseObserver) {
        responseObserver.onNext(benchmarks);
        responseObserver.onCompleted();
    }
}
