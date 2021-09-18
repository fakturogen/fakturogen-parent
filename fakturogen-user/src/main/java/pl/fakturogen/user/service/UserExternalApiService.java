package pl.fakturogen.user.service;

import org.springframework.stereotype.Service;
import pl.fakturogen.user.dao.entity.UserExternalApi;
import pl.fakturogen.user.exception.UserExternalApiException;
import pl.fakturogen.user.web.dto.UserExternalApiDTO;

import java.util.Optional;

@Service
public interface UserExternalApiService {
    UserExternalApi create(UserExternalApiDTO userExternalApiDTO) throws UserExternalApiException;
    Optional<UserExternalApiDTO> read(Long id) throws UserExternalApiException;
    void update(UserExternalApiDTO userExternalApiDTO) throws UserExternalApiException;
    void delete(UserExternalApiDTO userExternalApiDTO) throws UserExternalApiException;
}
