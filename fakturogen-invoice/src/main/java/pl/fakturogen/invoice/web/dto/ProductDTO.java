package pl.fakturogen.invoice.web.dto;

import pl.fakturogen.invoice.dao.entity.Rate;

@Data
public class ProductDTO {

    private String name;
    private String description;
    private String itemCode;
    private String unitOfMeasurement;
    private double saleNetPrice;
    private double saleGrossPrice;
    private Rate rate;
    private long idExternalApi;
}
