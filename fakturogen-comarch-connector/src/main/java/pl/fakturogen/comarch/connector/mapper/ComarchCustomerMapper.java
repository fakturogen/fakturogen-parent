package pl.fakturogen.comarch.connector.mapper;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.fakturogen.comarch.connector.dto.ComarchAddressDTO;
import pl.fakturogen.comarch.connector.dto.ComarchCustomerDTO;
import pl.fakturogen.comarch.connector.model.ComarchAddress;
import pl.fakturogen.comarch.connector.model.ComarchCustomer;

import java.util.List;
import java.util.stream.Collectors;
/**
 * @author ewa-git
 */

@Component
@Slf4j
public class ComarchCustomerMapper {

    private final ComarchAddressMapper comarchAddressMapper;

    public ComarchCustomerMapper(ComarchAddressMapper comarchAddressMapper) {
        this.comarchAddressMapper = comarchAddressMapper;
    }

    public ComarchCustomerDTO from(ComarchCustomer comarchCustomer) {

        log.info("from {}", comarchCustomer);
        ModelMapper mapper = new ModelMapper();

        ComarchCustomerDTO comarchCustomerDTO = mapper.map(comarchCustomer, ComarchCustomerDTO.class);
        ComarchAddressDTO comarchAddressDTO = comarchAddressMapper.from(comarchCustomer.getAddress());
        comarchCustomerDTO.setAddress(comarchAddressDTO);
        log.info("mapping from {} = {}", comarchCustomer, comarchCustomerDTO);
        return comarchCustomerDTO;
    }

    public ComarchCustomer from(ComarchCustomerDTO comarchCustomerDTO) {
        log.info("from {}", comarchCustomerDTO);
        ModelMapper mapper = new ModelMapper();

        ComarchCustomer comarchCustomer = mapper.map(comarchCustomerDTO, ComarchCustomer.class);
        ComarchAddress comarchAddress = comarchAddressMapper.from(comarchCustomerDTO.getAddress());
        comarchCustomer.setAddress(comarchAddress);
        log.info("mapping from {} = {}", comarchCustomerDTO, comarchCustomer);
        return comarchCustomer;
    }

    public List<ComarchCustomerDTO> fromList(List<ComarchCustomer> comarchCustomerList) {
        comarchCustomerList.stream().forEach(s -> log.info("from {}", s));
        ModelMapper mapper = new ModelMapper();

        List<ComarchCustomerDTO> comarchCustomerDTOList = comarchCustomerList.stream()
                .map(s -> from(s)).collect(Collectors.toList());

        return comarchCustomerDTOList;

    }
}
