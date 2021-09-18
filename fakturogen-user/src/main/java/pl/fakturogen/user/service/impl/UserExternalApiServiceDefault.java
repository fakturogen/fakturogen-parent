package pl.fakturogen.user.service.impl;

import pl.fakturogen.user.dao.entity.UserExternalApi;
import pl.fakturogen.user.exception.UserExternalApiException;
import pl.fakturogen.user.service.UserExternalApiService;
import pl.fakturogen.user.web.dto.UserExternalApiDTO;

import java.util.Optional;

public class UserExternalApiServiceDefault implements UserExternalApiService {
    @Override
    public UserExternalApi create(UserExternalApiDTO userExternalApiDTO) throws UserExternalApiException {
        return null;
    }

    @Override
    public Optional<UserExternalApiDTO> read(Long id) throws UserExternalApiException {
        return Optional.empty();
    }

    @Override
    public void update(UserExternalApiDTO userExternalApiDTO) throws UserExternalApiException {

    }

    @Override
    public void delete(UserExternalApiDTO userExternalApiDTO) throws UserExternalApiException {

    }
}
