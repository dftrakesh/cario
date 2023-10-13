package io.github.dft.cario.model.consignment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.dft.cario.model.common.LocalDateTimeDeserializer;
import io.github.dft.cario.model.common.LocalDateTimeSerializer;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteResponse {
    public Integer id;
    public Integer carrierId;
    public String carrierCode;
    public String carrierName;
    public Integer serviceId;
    public String serviceCode;
    public String serviceName;
    public Double freight;
    public Double fees;
    public Double net;
    public Double tax;
    public Double total;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    public LocalDateTime eta;
}
