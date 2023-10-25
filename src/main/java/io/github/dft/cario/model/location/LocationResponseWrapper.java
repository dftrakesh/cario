package io.github.dft.cario.model.location;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationResponseWrapper extends ArrayList<LocationResponse> {
}