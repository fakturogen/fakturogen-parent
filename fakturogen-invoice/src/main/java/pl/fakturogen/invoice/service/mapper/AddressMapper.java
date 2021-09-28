package pl.fakturogen.invoice.service.mapper;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import pl.fakturogen.invoice.dao.entity.Address;
import pl.fakturogen.invoice.web.dto.AddressDTO;
/**
 * @author ewa-git
 */

@Component
@Slf4j
public class AddressMapper {

    private ModelMapper modelMapper;

    public AddressMapper() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public AddressDTO from(Address address) {
        log.info("mapping from {}", address);
        AddressDTO addressDTO = modelMapper.map(address, AddressDTO.class);
        log.info("mapping from {} = {}", address, addressDTO);
        return addressDTO;
    }

    public Address from(AddressDTO addressDTO) {
        log.info("mapping from {}", addressDTO);
        Address address = modelMapper.map(addressDTO, Address.class);
        log.info("mapping from {} = {}", addressDTO, address);
        return address;
    }
}
