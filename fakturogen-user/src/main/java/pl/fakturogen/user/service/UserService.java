package pl.fakturogen.user.service;

import org.springframework.stereotype.Service;
import pl.fakturogen.user.exception.UserException;
import pl.fakturogen.user.web.dto.UserDTO;

/**
 * @author ewa-git
 */
@Service
public interface UserService {
    UserDTO create(UserDTO userDTO) throws UserException;


}
