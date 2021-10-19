package pl.fakturogen.user.service.mapper;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import pl.fakturogen.user.dao.entity.User;
import pl.fakturogen.user.web.dto.UserDTO;
/**
 * @author ewa-git
 */

@Component
@Slf4j
public class UserMapper {

    private  ModelMapper modelMapper;

    public UserMapper(){
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public UserDTO from(User user) {
        log.info("Mapping from {}", user);
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        log.info("mapping from {} = {}", user, userDTO);
        return userDTO;
    }

    public User from(UserDTO userDTO){
        log.info("mapping from {}", userDTO);
        User user = modelMapper.map(userDTO, User.class);
        log.info("mapping from {} = {}", userDTO, user);
        return user;
    }
}
