package pl.fakturogen.comarch.connector.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerComarchDTO {

    private Long id;

    private Long idExternalApi;

    @NotBlank
    private String name;

    private String nip;

    private String pesel;

    private String customerCode;

    private String mail;

    private String phoneNumber;

    private CustomerTypeComarchDTO customerType;

    private AddressComarchDTO address;
}
