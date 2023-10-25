package io.github.dft.cario;

import io.github.dft.cario.model.auth.AccessCredential;
import io.github.dft.cario.model.location.LocationResponseWrapper;

import java.net.URI;
import java.net.http.HttpRequest;

import static io.github.dft.cario.constantcode.ConstantCodes.LOCATION_ENDPOINT;

public class LocationAPI extends CarioSdk {

    public LocationAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    public LocationResponseWrapper findByCountryId(String countryId, String postalCode) {
        URI uri = baseUrl(LOCATION_ENDPOINT + "FindByCountryId/" + countryId + "/" + postalCode);
        HttpRequest httpRequest = get(uri);

        return getRequestWrapped(httpRequest, LocationResponseWrapper.class);
    }
}
