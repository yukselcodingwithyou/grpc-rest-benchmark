package com.yukselcoding.grpcrestbenchmark.service;


import com.yukselcoding.proto.Benchmark;
import com.yukselcoding.proto.BenchmarkDetail;
import com.yukselcoding.proto.Benchmarks;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BenchmarksGenerator {
    public Benchmarks generate() {
        final List<Benchmark> benchmarks = new ArrayList<>();
        for(int i = 0; i < 50000; i++) {
            benchmarks.add(Benchmark.newBuilder()
                    .setId(i)
                    .setTitle("Title " + i)
                    .setDetail(BenchmarkDetail.newBuilder()
                            .setId(i)
                            .setTitle("Title " + i)
                            .setDescription("Description " + i)
                            .build())
                    .build());
        }
        return Benchmarks.newBuilder().addAllBenchmarks(benchmarks).build();
    }
}
