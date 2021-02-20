package pl.fakturogen.invoice.web.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private Long id;

    private Long idExternalApi;

    @NotBlank
    private String name;

    private String nip;

    private String pesel;

    private String customerCode;

    private String mail;

    private String phoneNumber;

    private CustomerTypeDTO customerType;

    private AddressDTO address;

}
