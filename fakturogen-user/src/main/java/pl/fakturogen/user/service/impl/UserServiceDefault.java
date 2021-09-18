package pl.fakturogen.user.service.impl;

import pl.fakturogen.user.dao.entity.User;
import pl.fakturogen.user.exception.UserException;
import pl.fakturogen.user.service.UserService;
import pl.fakturogen.user.web.dto.UserDTO;

import java.util.Optional;

public class UserServiceDefault implements UserService {
    @Override
    public User create(UserDTO userDTO) throws UserException {
        return null;
    }

    @Override
    public Optional<UserDTO> read(Long id) throws UserException {
        return Optional.empty();
    }

    @Override
    public void update(UserDTO userDTO) throws UserException {

    }

    @Override
    public void delete(UserDTO userDTO) throws UserException {

    }
}
