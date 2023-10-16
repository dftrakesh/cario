package io.github.dft.cario;

import io.github.dft.cario.model.auth.AccessCredential;
import io.github.dft.cario.model.consignment.QuoteRequest;
import io.github.dft.cario.model.consignment.QuoteResponseWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;

import static io.github.dft.cario.constantcode.ConstantCodes.CONSIGNMENT_ENDPOINT;

public class ConsignmentAPI extends CarioSdk {

    public ConsignmentAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public QuoteResponseWrapper getQuote(QuoteRequest quoteRequest) {
        URI uri = baseUrl(CONSIGNMENT_ENDPOINT + "GetQuotes");
        String quoteRequestString = objectMapper.writeValueAsString(quoteRequest);
        HttpRequest post = post(uri, quoteRequestString);

        return getRequestWrapped(post, QuoteResponseWrapper.class);
    }
}
