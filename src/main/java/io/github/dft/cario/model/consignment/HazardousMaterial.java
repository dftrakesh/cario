package io.github.dft.cario.model.consignment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class HazardousMaterial {
    public String unCode;
    public String properShippingName;
    public String name;

    @JsonProperty("class")
    public String hazardousClass;
    public String subsidiaryHazard;
    public String packingGroup;
    public Integer quantity;
    public Integer aggregateQuantity;
    public String uom;
    public String receptacle;
}
