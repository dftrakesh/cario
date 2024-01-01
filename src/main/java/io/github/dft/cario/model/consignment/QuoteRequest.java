package io.github.dft.cario.model.consignment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteRequest {
    public String id;
    public String customerId;
    public String customerCode;
    public String costCentre;
    public String orderKey;
    public String connoteNumber;
    public String customerReference;
    public List<String> references;
    public Service service;
    public String pickupDate;
    public String pickupEarliestTime;
    public String pickupLatestTime;
    public PickupAddress pickupAddress;
    public DeliveryAddress deliveryAddress;
    public Boolean authorityToLeave;
    public String authorisationCode;
    public Boolean bookInRequired;
    public String timeSlotDate;
    public String timeSlotTime;
    public String deliverOnDate;
    public Integer totalItems;
    public Integer totalWeight;
    public Double totalVolume;
    public Integer totalPalletSpaces;
    public Integer travelDistance;
    public String description;
    public String specialInstructions;
    public Integer goodsValue;
    public Integer amountInsured;
    public String insuranceClass;
    public Boolean customsClearanceRequired;
    public Boolean dutiesAndTaxesPaid;
    public Boolean optionHandUnload;
    public Boolean optionPickupTailLift;
    public Boolean optionDeliveryTailLift;
    public List<TransportUnit> transportUnits;
    public String consolidationKey;
    public String movementFlag;
    public String customValue1;
    public String customValue2;
    public String customValue3;
    public String customValue4;
    public String customValue5;
    public String customValue6;
    public String customValue7;
    public String customValue8;
}
