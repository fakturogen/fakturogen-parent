package pl.fakturogen.comarch.connector.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComarchInvoiceDTO {

    private Integer paymentStatus;
    private Integer purchasingPartyId;
    private Integer receivingPartyId;
    private Integer paymentTypeId;
    private Integer bankAccountId;
    private String salesDate;
    private Integer invoiceType;
    private List<ComarchProductDTO> items = null;
    private String description;
    private String issueDate;
    private String number;
    private Integer status;
    private Long id;

}
