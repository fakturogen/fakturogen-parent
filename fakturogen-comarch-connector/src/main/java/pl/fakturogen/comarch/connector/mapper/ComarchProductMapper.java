package pl.fakturogen.comarch.connector.mapper;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.fakturogen.comarch.connector.dto.ComarchProductDTO;
import pl.fakturogen.comarch.connector.model.ComarchProduct;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author damian
 */

@Component
@Slf4j
public class ComarchProductMapper {
    public ComarchProductDTO from(ComarchProduct comarchProduct) {
        log.info("from ({})", comarchProduct);
        ModelMapper mapper = new ModelMapper();

        ComarchProductDTO productDTO = mapper.map(comarchProduct, ComarchProductDTO.class);
        log.info("to ({})", productDTO);
        return productDTO;
    }

    public List<ComarchProductDTO> fromList(List<ComarchProduct> comarchProductList) {
        return comarchProductList.stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

}