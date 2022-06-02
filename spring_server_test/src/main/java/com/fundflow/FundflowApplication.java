package com.fundflow;

import com.fundflow.config.aws.AwsConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AwsConfigProperties.class)
public class FundflowApplication {

    public static void main(String[] args) {
        SpringApplication.run(FundflowApplication.class, args);
    }
}
