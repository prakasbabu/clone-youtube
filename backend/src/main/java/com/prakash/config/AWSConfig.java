package com.prakash.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AWSConfig {
    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;

    @Value("${cloud.aws.credentials.secret-key}")
    private String secretKey;


    @Value("${cloud.aws.region.static}")
    private String region;


    @Bean
    public AmazonS3Client amazonS3Client() {
        AmazonS3ClientBuilder builder = AmazonS3ClientBuilder.standard();
        builder.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)));
        builder.setRegion(region);
        AmazonS3Client amazonS3 = (AmazonS3Client) builder.build();
        return amazonS3;
    }
}
