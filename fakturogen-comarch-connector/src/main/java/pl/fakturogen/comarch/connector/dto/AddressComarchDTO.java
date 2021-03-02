package pl.fakturogen.comarch.connector.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressComarchDTO {

    private Long id;

    private Long idExternalApi;

    private String street;

    private String buildingNumber;

    private String flatNumber;

    private String postalCode;

    private String city;
}
