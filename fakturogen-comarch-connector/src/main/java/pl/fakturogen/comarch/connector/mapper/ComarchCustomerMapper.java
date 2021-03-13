package pl.fakturogen.comarch.connector.mapper;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.fakturogen.comarch.connector.dto.ComarchCustomerDTO;
import pl.fakturogen.comarch.connector.model.ComarchCustomer;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class ComarchCustomerMapper {

    public ComarchCustomerDTO from(ComarchCustomer comarchCustomer){
        log.info("from {}", comarchCustomer);
        ModelMapper mapper = new ModelMapper();

        ComarchCustomerDTO comarchCustomerDTO = mapper.map(comarchCustomer, ComarchCustomerDTO.class);
        log.info("mapping from {} = {}", comarchCustomer, comarchCustomerDTO);
        return comarchCustomerDTO;
    }

    public ComarchCustomer from(ComarchCustomerDTO comarchCustomerDTO) {
        log.info("from {}", comarchCustomerDTO);
        ModelMapper mapper = new ModelMapper();

        ComarchCustomer comarchCustomer = mapper.map(comarchCustomerDTO, ComarchCustomer.class);
        log.info("mapping from {} = {}", comarchCustomerDTO, comarchCustomer);
        return comarchCustomer;
    }

    public List<ComarchCustomerDTO> fromList(List<ComarchCustomer> comarchCustomerList) {
        comarchCustomerList.stream().forEach(s -> log.info("from {}", s));
        ModelMapper mapper = new ModelMapper();

        List<ComarchCustomerDTO> comarchCustomerDTOList = comarchCustomerList.stream()
                .map(s -> mapper.map(s, ComarchCustomerDTO.class)).collect(Collectors.toList());

        return comarchCustomerDTOList;

    }
}
