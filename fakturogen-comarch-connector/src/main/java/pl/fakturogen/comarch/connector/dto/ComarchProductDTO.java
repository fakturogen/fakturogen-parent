package pl.fakturogen.comarch.connector.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComarchProductDTO {
    private String $id;
    private String name;
    private String description;
    private String itemCode;
    private String productCode;
    private String unitOfMeasurment;
    private Integer rate;
    private Double saleNetPrice;
    private Double saleGrossPrice;
    private Double quantity;
    private Long id;
}
