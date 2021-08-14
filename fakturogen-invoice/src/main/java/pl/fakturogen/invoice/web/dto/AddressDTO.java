package pl.fakturogen.invoice.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author ewa-git
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    private Long id;

    private Long idExternalApi;

    private String street;

    private String buildingNumber;

    private String flatNumber;

    private String postalCode;

    private String city;
}
