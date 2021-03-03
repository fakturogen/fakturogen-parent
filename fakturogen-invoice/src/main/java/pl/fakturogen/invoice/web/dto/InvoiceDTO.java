package pl.fakturogen.invoice.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.fakturogen.invoice.dao.entity.Product;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDTO {

    private Long id;
    private Integer purchasingPartyId;
    private Integer receivingPartyId;
    private Integer customerId;
    private Integer bankAccountId;
    private Integer invoiceType;
    private Product items;
    private String description;
    private LocalDateTime issueDate;
    private String number;
    private Integer status;
    private Long originalId; // Document id from provider database
    private LocalDateTime createdOn;

}
