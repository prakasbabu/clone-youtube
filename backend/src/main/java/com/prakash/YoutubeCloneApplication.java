package com.prakash;

import com.amazonaws.services.s3.AmazonS3Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class YoutubeCloneApplication {

    public static void main(String[] args) {
        SpringApplication.run(YoutubeCloneApplication.class, args);
    }

    @Bean
    public AmazonS3Client getAmazonS3ClinetBean() {
        return new AmazonS3Client();
    }
}
