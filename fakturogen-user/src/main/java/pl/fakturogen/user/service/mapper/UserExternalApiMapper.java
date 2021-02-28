package pl.fakturogen.user.service.mapper;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.fakturogen.user.dao.entity.UserExternalApi;
import pl.fakturogen.user.web.dto.UserExternalApiDTO;

@Component
@Slf4j
public class UserExternalApiMapper {

    private ModelMapper modelMapper;

    public UserExternalApiMapper() {
        modelMapper = new ModelMapper();
    }

    public UserExternalApi from(UserExternalApiDTO userExternalApiDTO) {
        log.info("from({})", userExternalApiDTO);
        UserExternalApi userExternalApi = modelMapper.map(userExternalApiDTO, UserExternalApi.class);
        log.info("from({}) = {}", userExternalApiDTO, userExternalApi);
        return userExternalApi;
    }

    public UserExternalApiDTO from(UserExternalApi userExternalApi) {
        log.info("from({})", userExternalApi);
        UserExternalApiDTO userExternalApiDTO = modelMapper.map(userExternalApi, UserExternalApiDTO.class);
        log.info("from({}) = {}", userExternalApi, userExternalApiDTO);
        return userExternalApiDTO;
    }
}