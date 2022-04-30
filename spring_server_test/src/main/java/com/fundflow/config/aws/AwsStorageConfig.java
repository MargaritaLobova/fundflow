package com.fundflow.config.aws;

import com.amazonaws.auth.BasicAWSCredentials;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsStorageConfig {

    @Bean(name = "awsCredentials")
    public S3Credentials credentials() {
        return new S3Credentials(
                // TODO: Get credentials from props
                new BasicAWSCredentials(
                        "<AWS accesskey>",
                        "<AWS secretkey>"
                ),
                ""
        );
    }
}
