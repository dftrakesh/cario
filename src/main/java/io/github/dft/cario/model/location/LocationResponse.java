package io.github.dft.cario.model.location;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationResponse {
    public Integer id;
    public String description;
}