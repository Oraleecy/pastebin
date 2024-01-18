package com.example.pastebin.controllers;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class PutObject {
    public static void main(String[] args) throws IOException {
        String bucketName = "pastebin_oraleecy";

        // Create an Amazon S3 client
//        AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withEndpointConfiguration(
//                new AwsClientBuilder.EndpointConfiguration("https://hb.ru-msk.vkcs.cloud", "ru-msk")).build();
//
//        s3Client.putObject(bucketName, "randomkey", "test text");


//        System.out.println((s3Client.getObject(bucketName, "randomkey")));

        AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withEndpointConfiguration(
                new AwsClientBuilder.EndpointConfiguration("https://hb.ru-msk.vkcs.cloud", "ru-msk")).build();
        S3Object object = s3Client.getObject(new GetObjectRequest(bucketName, "randomkey"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(object.getObjectContent()));
        String s = null;
        while ((s = reader.readLine()) != null)
        {
            System.out.println(s);
            //your business logic here
        }
    }

}