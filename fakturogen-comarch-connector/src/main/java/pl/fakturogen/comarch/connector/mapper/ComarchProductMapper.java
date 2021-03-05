package pl.fakturogen.comarch.connector.mapper;

import org.springframework.stereotype.Component;
import pl.fakturogen.comarch.connector.dto.ComarchProductDTO;
import pl.fakturogen.comarch.connector.model.ComarchProduct;

import java.util.List;

@Component
public class ComarchProductMapper {
    public ComarchProductDTO from(ComarchProduct comarchProduct) {
    }

    public List<ComarchProductDTO> fromList(List<ComarchProduct> comarchProduct) {
    }
}
