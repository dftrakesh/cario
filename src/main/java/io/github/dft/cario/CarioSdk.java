package io.github.dft.cario;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.dft.cario.model.auth.AccessCredential;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

import static io.github.dft.cario.constantcode.ConstantCodes.*;

public class CarioSdk {

    protected HttpClient client;
    protected AccessCredential accessCredential;
    private ObjectMapper objectMapper;
    
    public CarioSdk(AccessCredential accessCredential) {
        client = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
        this.accessCredential = accessCredential;
    }

    @SneakyThrows
    public <T> T getRequestWrapped(HttpRequest request, Class<T> tClass) {

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .thenComposeAsync(response -> CompletableFuture.completedFuture(response))
            .thenApplyAsync(HttpResponse::body)
            .thenApplyAsync(responseBody -> convertBody(responseBody, tClass))
            .get();
    }

    @SneakyThrows
    private <T> T convertBody(String body, Class<T> tClass) {
        return objectMapper.readValue(body, tClass);
    }

    @SneakyThrows
    protected URI baseUrl(String path) {
        return new URI(new StringBuilder().append(HTTPS)
            .append(BASE_ENDPOINT)
            .append(SLASH_CHARACTER)
            .append(path)
            .toString());
    }

    @SneakyThrows
    protected HttpRequest post(URI uri, final String jsonBody) {

        return HttpRequest.newBuilder(uri)
            .header(AUTHORIZATION_HEADER, TOKEN_TYPE.concat(accessCredential.getAccessToken()))
            .header(CONTENT_TYPE, "application/json")
            .header(ACCEPT, "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
            .build();
    }
}