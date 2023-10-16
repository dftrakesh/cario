package io.github.dft.cario.model.consignment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Contact {
    public String name;
    public String phone;
    public String mobile;
    public String fax;
    public String email;
}
