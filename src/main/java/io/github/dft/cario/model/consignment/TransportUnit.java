package io.github.dft.cario.model.consignment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransportUnit {
    public Integer itemNo;
    public String transportUnitType;
    public String productCode;
    public String description;
    public String containerType;
    public String reference;
    public Integer quantity;
    public Integer length;
    public Integer width;
    public Integer height;
    public Double volume;
    public Integer weight;
    public String shortIdentifier;
    public String barcode;
    public String packID;
    public String itemInstructions;
    public List<HazardousMaterial> hazardousMaterial;
    public List<Asset> assets;
}
