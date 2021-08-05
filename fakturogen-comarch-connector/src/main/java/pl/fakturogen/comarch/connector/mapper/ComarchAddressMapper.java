package pl.fakturogen.comarch.connector.mapper;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.fakturogen.comarch.connector.dto.ComarchAddressDTO;
import pl.fakturogen.comarch.connector.model.ComarchAddress;
/**
 * @author ewa-git
 */

@Component
@Slf4j
public class ComarchAddressMapper {

    public ComarchAddressDTO from(ComarchAddress comarchAddress){
        log.info("from {}", comarchAddress);
        ModelMapper mapper = new ModelMapper();

        ComarchAddressDTO comarchAddressDTO = mapper.map(comarchAddress, ComarchAddressDTO.class);
        log.info("mapping from {} = {}", comarchAddress, comarchAddressDTO);
        return  comarchAddressDTO;
    }

    public ComarchAddress from(ComarchAddressDTO comarchAddressDTO) {
        log.info("from {}", comarchAddressDTO);
        ModelMapper mapper = new ModelMapper();

        ComarchAddress comarchAddress = mapper.map(comarchAddressDTO, ComarchAddress.class);
        log.info("mapping from {} = {}", comarchAddressDTO, comarchAddress);
        return comarchAddress;
    }
}
