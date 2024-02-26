package com.example.pastebin.CloudStorage;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


@Component
public class CloudStorageManager {

    @Value("${cloud.storage.bucket}")
    private String bucketName;
    private final AmazonS3 s3Client;

    CloudStorageManager(AmazonS3 s3Client) {
        this.s3Client = s3Client;
    }

    public void writeFile(String fileName, String data) {
        s3Client.putObject(bucketName, fileName, data);
    }

    public String readFile(String fileName) throws IOException {
        S3Object object = s3Client.getObject(new GetObjectRequest(bucketName, fileName));
        BufferedReader reader = new BufferedReader(new InputStreamReader(object.getObjectContent()));

        String s;
        StringBuilder stringBuilder = new StringBuilder();
        while ((s = reader.readLine()) != null) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
