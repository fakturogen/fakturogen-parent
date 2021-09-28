package pl.fakturogen.comarch.connector.dto;

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
public class ComarchCustomerDTO {


    private String name;
    private String customerTaxNumber;
    private String customerCode;
    private String mail;
    private String phoneNumber;
    private Integer customerType;
    private ComarchAddressDTO address;
    private Integer id;
}
