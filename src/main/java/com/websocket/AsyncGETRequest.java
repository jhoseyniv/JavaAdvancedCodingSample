package com.websocket;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AsyncGETRequest {
    public static void main(String args[]) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
         URI uri2 = URI.create("https://reqres.in/api/users/2");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri2)
                .build();
        HttpResponse<String> response
                = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status code: " + response.statusCode());
        System.out.println("\n Body: " + response.body());

    }
}
