package pl.fakturogen.invoice.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.fakturogen.invoice.dao.entity.CustomerType;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private long id;

    @NotBlank
    private String name;

    private String customerTaxNumber;

    private String customerCode;

    private String mail;

    private String phoneNumber;

    private CustomerType customerType;

    private AddressDTO address;
}
