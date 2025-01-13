package com.ndhuy.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import io.grpc.CompressorRegistry;
import net.devh.boot.grpc.client.channelfactory.GrpcChannelConfigurer;

@Configuration
public class GrpcConfiguration {
       @Bean
    @Primary
     CompressorRegistry compressorRegistry(GrpcChannelConfigurer codecConfigurer) {
        return CompressorRegistry.getDefaultInstance();
    }
}
