package pl.fakturogen.user.service.mapper;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.fakturogen.user.dao.entity.User;
import pl.fakturogen.user.web.dto.UserDTO;

@Component
@Slf4j
public class UserMapper {
    ModelMapper modelMapper = new ModelMapper();
    public UserDTO from(User user) {
        log.info("Mapping from {}", user);
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        log.info("mapped to {}", userDTO);
        return userDTO;
    }
}
