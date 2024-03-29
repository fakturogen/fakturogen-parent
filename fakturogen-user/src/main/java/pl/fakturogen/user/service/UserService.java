package pl.fakturogen.user.service;

import org.springframework.stereotype.Service;
import pl.fakturogen.user.exception.UserException;
import pl.fakturogen.user.web.dto.UserDTO;

import java.util.Optional;

/**
 * @author ewa-git
 */
@Service
public interface UserService {
    UserDTO create(UserDTO userDTO) throws UserException;
    Optional<UserDTO> read(Long id) throws UserException;
    void update(UserDTO userDTO, Long id) throws UserException;
    void delete(UserDTO userDTO, Long id) throws UserException;
}
