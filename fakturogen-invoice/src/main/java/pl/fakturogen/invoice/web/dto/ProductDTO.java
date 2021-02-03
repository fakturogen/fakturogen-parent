package pl.fakturogen.invoice.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.fakturogen.invoice.dao.entity.Rate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String name;
    private String description;
    private String itemCode;
    private String unitOfMeasurement;
    private double saleNetPrice;
    private double saleGrossPrice;
    private Rate rate;
    private Long idExternalApi;

}
