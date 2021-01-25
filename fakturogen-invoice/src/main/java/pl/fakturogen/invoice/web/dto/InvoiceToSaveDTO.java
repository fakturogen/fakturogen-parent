package pl.fakturogen.invoice.web.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import pl.fakturogen.invoice.dao.entity.Product;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class InvoiceToSaveDTO {
    private String number;
    @DateTimeFormat(pattern = "dd-MM-YYYY")
    private LocalDate issueDate;
    private LocalDate saleDate;
    private LocalDate dueDate;
    private Integer paymentMethod;
    private double total;
    private double tax;
    private double net;
    private double discount;
    private Integer status;
    private Integer customerId;
    private List<Product> items;
    private Integer bankAccountId;
    private Integer invoiceType;
    private String additionalInformation;
    private Long originalId; // Document id from provider database
}
