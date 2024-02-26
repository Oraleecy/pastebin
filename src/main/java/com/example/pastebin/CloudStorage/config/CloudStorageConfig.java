package com.example.pastebin.CloudStorage.config;


import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudStorageConfig {

    @Value("${cloud.storage.endpoint}")
    private String serviceEndpoint;

    @Value("${cloud.storage.region}")
    private String region;

    @Bean
    public AmazonS3 amazonS3() {
        return AmazonS3ClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(serviceEndpoint, region))
                .build();
    }
}
