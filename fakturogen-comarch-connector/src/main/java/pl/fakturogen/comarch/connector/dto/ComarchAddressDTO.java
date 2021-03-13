package pl.fakturogen.comarch.connector.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComarchAddressDTO {

    private String $id;
    private String street;
    private String buildingNumber;
    private String flatNumber;
    private String postalCode;
    private String city;
    private Integer id;
}
