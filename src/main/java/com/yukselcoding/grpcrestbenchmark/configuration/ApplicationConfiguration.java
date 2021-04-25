package com.yukselcoding.grpcrestbenchmark.configuration;


import com.yukselcoding.grpcrestbenchmark.service.BenchmarksGenerator;
import com.yukselcoding.proto.Benchmarks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;

@Configuration
public class ApplicationConfiguration {

    @Autowired
    private BenchmarksGenerator generator;

    @Bean
    public ProtobufHttpMessageConverter protobufHttpMessageConverter() {
        return new ProtobufHttpMessageConverter();
    }

    @Bean
    public Benchmarks benchmarks() {
        return generator.generate(50000L);
    }


}
