package pl.fakturogen.invoice.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceSaveDTO {

    private String number;
    private LocalDate issueDate;
    private LocalDate saleDate;
    private Integer paymentMethod;
    private Double total;
    private Double tax;
    private Double net;
    private Double discount;
    private Integer status;
    private CustomerDTO customer;
    private List<ProductDTO> items;
    private Integer bankAccountId;
    private Integer invoiceType;
    private String additionalInformation;
    private Long originalId; // Document id from provider database
}
