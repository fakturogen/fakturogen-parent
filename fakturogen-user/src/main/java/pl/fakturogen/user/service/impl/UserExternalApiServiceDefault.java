package pl.fakturogen.user.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.fakturogen.user.dao.entity.UserExternalApi;
import pl.fakturogen.user.dao.repositories.UserExternalApiRepository;
import pl.fakturogen.user.exception.UserException;
import pl.fakturogen.user.exception.UserExternalApiException;
import pl.fakturogen.user.service.UserExternalApiService;
import pl.fakturogen.user.service.mapper.UserExternalApiMapper;
import pl.fakturogen.user.web.dto.UserExternalApiDTO;

import java.util.Optional;

/**
 * @author ewa-git
 */
@Slf4j
@Service
public class UserExternalApiServiceDefault implements UserExternalApiService {

    private UserExternalApiRepository userExternalApiRepository;
    private UserExternalApiMapper userExternalApiMapper;

    public UserExternalApiServiceDefault(UserExternalApiRepository userExternalApiRepository, UserExternalApiMapper userExternalApiMapper) {
        this.userExternalApiRepository = userExternalApiRepository;
        this.userExternalApiMapper = userExternalApiMapper;
    }

    @Override
    public UserExternalApiDTO create(UserExternalApiDTO userExternalApiDTO) throws UserExternalApiException {
        try {
            UserExternalApi userExternalApi = userExternalApiMapper.from(userExternalApiDTO);
            UserExternalApi userSaved = userExternalApiRepository.save(userExternalApi);
            return userExternalApiMapper.from(userSaved);
        } catch (Exception e) {
            log.warn(e.getMessage(), e);
            throw new UserExternalApiException("There was an unexpected error during saving user external api data in database");
        }
    }

    @Override
    public Optional<UserExternalApiDTO> read(Long id) throws UserExternalApiException {
        try {
            Optional<UserExternalApi> optionalUserExternalApi = userExternalApiRepository.findById(id);
            UserExternalApiDTO userExternalApiDTO = null;
            if (optionalUserExternalApi.isPresent()) {
                userExternalApiDTO = userExternalApiMapper.from(optionalUserExternalApi.get());
            }
            return Optional.ofNullable(userExternalApiDTO);
        } catch (Exception e) {
            log.warn(e.getMessage(), e);
            throw new UserExternalApiException("There was an unexpected error during finding user external api data in database");
        }
    }

    @Override
    public void update(UserExternalApiDTO userExternalApiDTO, Long id) throws UserExternalApiException {
        try {
            Optional<UserExternalApi> optionalUserExternalApi = userExternalApiRepository.findById(id);
            optionalUserExternalApi.orElseThrow(() -> new UserException("There was an unexpected error during finding user external api data in database"));
            userExternalApiDTO.setId(optionalUserExternalApi.get().getId());
            UserExternalApi userExternalApi = userExternalApiMapper.from(userExternalApiDTO);
            userExternalApiRepository.save(userExternalApi);
        } catch (Exception e) {
            log.warn(e.getMessage(), e);
            throw new UserExternalApiException("There was an unexpected error during updating user external api data in database");
        }
    }

}
