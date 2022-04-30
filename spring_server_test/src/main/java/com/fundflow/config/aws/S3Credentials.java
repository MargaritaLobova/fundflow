package com.fundflow.config.aws;

import com.amazonaws.auth.BasicAWSCredentials;
import lombok.Value;

@Value
public class S3Credentials {

    BasicAWSCredentials awsCredentials;
    String bucketName;
}
