package pl.fakturogen.comarch.connector.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.fakturogen.comarch.api.customer.Address;
import pl.fakturogen.comarch.connector.dto.AddressComarchDTO;

@Component
@Slf4j
public class ComarchAddressConverter {

    public AddressComarchDTO from(Address addressComarch) {
        AddressComarchDTO addressComarchDTO = new AddressComarchDTO();
        log.info("mapping from {}", addressComarch);
        addressComarchDTO.setIdExternalApi(addressComarch.getId().longValue());
        addressComarchDTO.setStreet(addressComarch.getStreet());
        addressComarchDTO.setBuildingNumber(addressComarch.getBuildingNumber());
        addressComarchDTO.setFlatNumber(addressComarch.getFlatNumber());
        addressComarchDTO.setPostalCode(addressComarch.getPostalCode());
        addressComarchDTO.setCity(addressComarch.getCity());
        log.info("mapping from {} = {}", addressComarch, addressComarchDTO);
        return addressComarchDTO;
    }
}
