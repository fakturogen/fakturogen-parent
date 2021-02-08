package pl.fakturogen.user.service.mapper;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.fakturogen.user.dao.entity.User;
import pl.fakturogen.user.web.dto.UserSaveDTO;

@Component
@Slf4j
public class UserSaveMapper {
    ModelMapper modelMapper = new ModelMapper();
    public User from(UserSaveDTO userToSave){
        log.info("Mapping user from {}", userToSave);
        User user = new User();
        user = modelMapper.map(userToSave,User.class);
        log.info("to {}", user);
        return user;
    }
}
