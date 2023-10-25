package io.github.dft.cario;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.dft.cario.model.auth.AccessCredential;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

import static io.github.dft.cario.constantcode.ConstantCodes.BASE_ENDPOINT;
import static io.github.dft.cario.constantcode.ConstantCodes.HTTPS;
import static io.github.dft.cario.constantcode.ConstantCodes.AUTHORIZATION_HEADER;
import static io.github.dft.cario.constantcode.ConstantCodes.ACCEPT;
import static io.github.dft.cario.constantcode.ConstantCodes.CONTENT_TYPE;
import static io.github.dft.cario.constantcode.ConstantCodes.TOKEN_TYPE_BEARER;

public class CarioSdk {

    private ObjectMapper objectMapper;
    protected HttpClient client;
    protected AccessCredential accessCredential;

    public CarioSdk(AccessCredential accessCredential) {
        client = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
        this.accessCredential = accessCredential;
    }

    @SneakyThrows
    public <T> T getRequestWrapped(HttpRequest request, Class<T> tClass) {

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .thenComposeAsync(CompletableFuture::completedFuture)
            .thenApplyAsync(HttpResponse::body)
            .thenApplyAsync(responseBody -> convertBody(responseBody, tClass))
            .get();
    }

    @SneakyThrows
    private <T> T convertBody(String body, Class<T> tClass) {
        return objectMapper.readValue(body, tClass);
    }

    @SneakyThrows
    private <T> String convertBodyToString(T tClass) {
        return objectMapper.writeValueAsString(tClass);
    }

    @SneakyThrows
    protected URI baseUrl(String path) {
        return new URI(HTTPS +
            BASE_ENDPOINT +
            path);
    }

    @SneakyThrows
    protected <T> HttpRequest post(URI uri, T tClass) {
        String jsonBody = convertBodyToString(tClass);

        return HttpRequest.newBuilder(uri)
            .header(AUTHORIZATION_HEADER, TOKEN_TYPE_BEARER + accessCredential.getAccessToken())
            .header(CONTENT_TYPE, "application/json")
            .header(ACCEPT, "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
            .build();
    }

    @SneakyThrows
    protected HttpRequest get(URI uri) {
        return HttpRequest.newBuilder(uri)
                .header(AUTHORIZATION_HEADER, TOKEN_TYPE_BEARER + accessCredential.getAccessToken())
                .header(CONTENT_TYPE, "application/json")
                .GET()
                .build();
    }
}