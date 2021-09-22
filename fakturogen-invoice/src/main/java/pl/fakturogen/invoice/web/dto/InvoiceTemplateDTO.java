package pl.fakturogen.invoice.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * @author damian
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceTemplateDTO {

    private Long id;
    private LocalDate issueDate;
    private LocalDate saleDate;
    private String paymentMethod;
    private Double priceTotal;
    private Double priceTax;
    private Double priceNet;
    private Double discountAmount;
    private CustomerDTO customer;
    private List<ProductDTO> products;

}