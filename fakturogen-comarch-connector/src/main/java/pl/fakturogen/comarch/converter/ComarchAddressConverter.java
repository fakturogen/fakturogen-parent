package pl.fakturogen.comarch.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.fakturogen.comarch.api.customer.Address;
import pl.fakturogen.invoice.web.dto.AddressDTO;

@Component
@Slf4j
public class ComarchAddressConverter {

    public AddressDTO from(Address addressComarch) {
        AddressDTO addressDTO = new AddressDTO();
        log.info("mapping from {}", addressComarch);
        addressDTO.setIdExternalApi(addressComarch.getId().longValue());
        addressDTO.setStreet(addressComarch.getStreet());
        addressDTO.setBuildingNumber(addressComarch.getBuildingNumber());
        addressDTO.setFlatNumber(addressComarch.getFlatNumber());
        addressDTO.setPostalCode(addressComarch.getPostalCode());
        addressDTO.setCity(addressComarch.getCity());
        log.info("mapping from {} = {}", addressComarch, addressDTO);
        return addressDTO;
    }
}
