package io.github.dft.cario.model.consignment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryAddress {
    public Integer id;
    public String code;
    public String name;
    public String line1;
    public String line2;
    public String line3;
    public Location location;
    public Contact contact;
    public Boolean isPostal;
    public Boolean isResidential;
    public Boolean isMineSite;
    public String notes;
}
