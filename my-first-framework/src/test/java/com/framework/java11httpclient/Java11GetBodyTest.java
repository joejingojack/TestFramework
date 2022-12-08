package com.framework.java11httpclient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Java11GetBodyTest {

    private static final String BASE_URL = "https://api.github.com/";

    @Test
    void bodyContainsCurrentUserUrl() throws IOException, InterruptedException {

        // Arrange - create client
        HttpClient httpClient = HttpClient.newBuilder().build();

        // Arrange - create request
        HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_URL + "user/joejingojack"))
                .setHeader("User-Agent", "Java 11 HttpClient bot")
                .build();

        // Act - send request
        HttpResponse<String> response = httpClient.send(get, HttpResponse.BodyHandlers.ofString());
        String body = response.body();

        // Assert
        Assertions.assertTrue(body.contains("\"login\":\"joejingojack\""));
    }
}
