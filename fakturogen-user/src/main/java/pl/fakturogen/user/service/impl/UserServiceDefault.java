package pl.fakturogen.user.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.fakturogen.user.dao.entity.User;
import pl.fakturogen.user.dao.repositories.UserRepository;
import pl.fakturogen.user.exception.UserException;
import pl.fakturogen.user.service.UserService;
import pl.fakturogen.user.service.mapper.UserMapper;
import pl.fakturogen.user.web.dto.UserDTO;

import java.util.Optional;

/**
 * @author ewa-git
 */
@Slf4j
@Service
public class UserServiceDefault implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserServiceDefault(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO create(UserDTO userDTO) throws UserException {
        try {
            User user = userMapper.from(userDTO);
            User userSaved = userRepository.save(user);
            return userMapper.from(userSaved);
        } catch (Exception e) {
            log.warn(e.getMessage(), e);
            throw new UserException("There was an unexpected error during saving user in database");
        }
    }

    @Override
    public Optional<UserDTO> read(Long id) throws UserException {
        try {
            Optional<User> optionalUser = userRepository.findById(id);
            UserDTO userDTO = null;
            if (optionalUser.isPresent()) {
                userDTO = userMapper.from(optionalUser.get());
            }
            return Optional.ofNullable(userDTO);
        } catch (Exception e) {
            log.warn(e.getMessage(), e);
            throw new UserException("There was an unexpected error during finding user in database");
        }
    }

    @Override
    public void update(UserDTO userDTO, Long id) throws UserException {
        try {
            Optional<User> optionalUser = userRepository.findById(id);
            optionalUser.orElseThrow(() -> new UserException("There was an unexpected error during finding user in database"));
            userDTO.setId(optionalUser.get().getId());
            User user = userMapper.from(userDTO);
            userRepository.save(user);
        } catch (Exception e) {
            log.warn(e.getMessage(), e);
            throw new UserException("There was an unexpected error during updating user in database");
        }
    }

    @Override
    public void delete(UserDTO userDTO, Long id) throws UserException {
        try {
            Optional<User> optionalUser = userRepository.findById(id);
            optionalUser.orElseThrow(() -> new UserException("There was an unexpected error during finding user in database"));
            userDTO.setId(optionalUser.get().getId());
            User user = userMapper.from(userDTO);
            userRepository.delete(user);
        } catch (Exception e) {
            log.warn(e.getMessage(), e);
            throw new UserException("There was an unexpected error during deleting user in database");
        }

    }
}
