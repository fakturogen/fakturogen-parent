package pl.fakturogen.comarch.connector.mapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.fakturogen.comarch.connector.dto.ComarchAddressDTO;
import pl.fakturogen.invoice.web.dto.AddressDTO;

@Component
@Slf4j
public class FakturogenAddressMapper {

    public AddressDTO from(ComarchAddressDTO comarchAddressDTO) {
       AddressDTO addressDTO = new AddressDTO();
        log.info("mapping from {}", comarchAddressDTO);
        addressDTO.setIdExternalApi(comarchAddressDTO.getId().longValue());
        addressDTO.setStreet(comarchAddressDTO.getStreet());
        addressDTO.setBuildingNumber(comarchAddressDTO.getBuildingNumber());
        addressDTO.setFlatNumber(comarchAddressDTO.getFlatNumber());
        addressDTO.setPostalCode(comarchAddressDTO.getPostalCode());
        addressDTO.setCity(comarchAddressDTO.getCity());
        log.info("mapping from {} = {}", comarchAddressDTO, addressDTO);
        return addressDTO;
    }
}
