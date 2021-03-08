package pl.fakturogen.comarch.connector.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComarchProductDTO {
    private String $id;
    private String name;
    private String description;
    private String itemCode;
    private String productCode;
    private String unitOfMeasurement;
    private Integer rate;
    private Double saleNetPrice;
    private Double saleGrossPrice;
    private Double quantity;
    private Long id;
}
