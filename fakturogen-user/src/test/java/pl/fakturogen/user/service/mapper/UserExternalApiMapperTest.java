package pl.fakturogen.user.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import pl.fakturogen.user.dao.entity.User;
import pl.fakturogen.user.dao.entity.UserExternalApi;
import pl.fakturogen.user.web.dto.UserDTO;
import pl.fakturogen.user.web.dto.UserExternalApiDTO;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("UserExternalApi mapper specification")
public class UserExternalApiMapperTest {
    private static final Long ID = 1L;
    private static final String CLIENT_ID = "Rg+9hk";
    private static final String CLIENT_SECRET = "Rg+9hk";
    private static final String FIRST_NAME = "Testowe imie";
    private static final String LAST_NAME = "Testowe nazwisko";
    private static final String EMAIL = "Testowy email";



    private UserExternalApiMapper userExternalApiMapper;
    private UserExternalApi userExternalApi;
    private UserExternalApiDTO userExternalApiDTO;
    private UserExternalApi emptyUserExternalApi;
    private UserExternalApiDTO emptyUserExternalApiDTO;
    private UserExternalApi partiallyEmptyUserExternalApi;
    private UserExternalApiDTO partiallyEmptyUserExternalApiDTO;
    private User user;
    private UserDTO userDTO;

    @BeforeEach
    public void prepareTest() {
        userExternalApiMapper = new UserExternalApiMapper();

        user = new User();
        user.setId(ID);
        user.setFirstName(FIRST_NAME);
        user.setLastName(LAST_NAME);
        user.setEmail(EMAIL);

        userDTO = UserDTO.builder()
                .id(ID)
                .firstname(FIRST_NAME)
                .lastname(LAST_NAME)
                .email(EMAIL)
                .build();

        userExternalApi = new UserExternalApi();
        userExternalApi.setId(ID);
        userExternalApi.setClientId(CLIENT_ID);
        userExternalApi.setClientSecret(CLIENT_SECRET);
        userExternalApi.setUser(user);

        userExternalApiDTO = UserExternalApiDTO.builder()
                .id(ID)
                .clientId(CLIENT_ID)
                .clientSecret(CLIENT_SECRET)
                .user(userDTO)
                .build();


        emptyUserExternalApi = new UserExternalApi();
        emptyUserExternalApiDTO = new UserExternalApiDTO();

        partiallyEmptyUserExternalApi = new UserExternalApi();
        partiallyEmptyUserExternalApi.setId(ID);
        partiallyEmptyUserExternalApi.setClientId(CLIENT_ID);

        partiallyEmptyUserExternalApiDTO = new UserExternalApiDTO();
        partiallyEmptyUserExternalApiDTO.setClientSecret(CLIENT_SECRET);
    }

    @Nested
    @DisplayName("Mapping from UserExternalApi to UserExternalApiDTO")
    class UserExternalApiToUserExternalApiDTO {

        @Test
        @DisplayName("Should map provided UserExternalApi to UserExternalApiDTO")
        void test1() {
            UserExternalApiDTO mappedUserExternalApiDTO = userExternalApiMapper.from(userExternalApi);

            assertAll(() -> assertEquals(userExternalApi.getId(), mappedUserExternalApiDTO.getId()),
                    () -> assertEquals(userExternalApi.getClientId(), mappedUserExternalApiDTO.getClientId()),
                    () -> assertEquals(userExternalApi.getClientSecret(), mappedUserExternalApiDTO.getClientSecret()),
                    () -> assertEquals(userExternalApi.getUser().getId(), mappedUserExternalApiDTO.getUser().getId()),
                    () -> assertEquals(userExternalApi.getUser().getFirstName(), mappedUserExternalApiDTO.getUser().getFirstname()),
                    () -> assertEquals(userExternalApi.getUser().getLastName(), mappedUserExternalApiDTO.getUser().getLastname()),
                    () -> assertEquals(userExternalApi.getUser().getEmail(), mappedUserExternalApiDTO.getUser().getEmail()));
        }

        @Test
        @DisplayName("Should map empty UserExternalApi to empty UserExternalApiDTO")
        void test2() {
            UserExternalApiDTO mappedUserExternalApiDTO = userExternalApiMapper.from(emptyUserExternalApi);

            assertAll(() -> assertEquals(emptyUserExternalApi.getId(), mappedUserExternalApiDTO.getId()),
                    () -> assertEquals(emptyUserExternalApi.getClientId(), mappedUserExternalApiDTO.getClientId()),
                    () -> assertEquals(emptyUserExternalApi.getClientSecret(), mappedUserExternalApiDTO.getClientSecret()),
                    () -> assertEquals(emptyUserExternalApi.getUser(), mappedUserExternalApiDTO.getUser()));
        }

        @Test
        @DisplayName("Should map partially empty UserExternalApi to partially empty UserExternalApiDTO")
        void test3() {
            UserExternalApiDTO mappedUserExternalApiDTO = userExternalApiMapper.from(partiallyEmptyUserExternalApi);
            assertAll(() -> assertEquals(partiallyEmptyUserExternalApi.getId(), mappedUserExternalApiDTO.getId()),
                    () -> assertEquals(partiallyEmptyUserExternalApi.getClientId(), mappedUserExternalApiDTO.getClientId()),
                    () -> assertEquals(partiallyEmptyUserExternalApi.getClientSecret(), mappedUserExternalApiDTO.getClientSecret()),
                    () -> assertEquals(partiallyEmptyUserExternalApi.getUser(), mappedUserExternalApiDTO.getUser()));
        }
    }

    @Nested
    @DisplayName("Mapping from UserExternalApiDTO to UserExternalApi")
    class UserExternalApidtoToUserExternalApi {

        @Test
        @DisplayName("Should map provided UserExternalApiDTO to UserExternalApi")
        void test1() {
            UserExternalApi mappedUserExternalApi = userExternalApiMapper.from(userExternalApiDTO);

            assertAll(() -> assertEquals(userExternalApiDTO.getId(), mappedUserExternalApi.getId()),
                    () -> assertEquals(userExternalApiDTO.getClientId(), mappedUserExternalApi.getClientId()),
                    () -> assertEquals(userExternalApiDTO.getClientSecret(), mappedUserExternalApi.getClientSecret()),
                    () -> assertEquals(userExternalApiDTO.getUser().getId(), mappedUserExternalApi.getUser().getId()),
                    () -> assertEquals(userExternalApiDTO.getUser().getFirstname(), mappedUserExternalApi.getUser().getFirstName()),
                    () -> assertEquals(userExternalApiDTO.getUser().getLastname(), mappedUserExternalApi.getUser().getLastName()),
                    () -> assertEquals(userExternalApiDTO.getUser().getEmail(), mappedUserExternalApi.getUser().getEmail()));
        }

        @Test
        @DisplayName("Should map empty UserExternalApiDTO to empty UserExternalApi")
        void test2() {
            UserExternalApi mappedUserExternalApi = userExternalApiMapper.from(emptyUserExternalApiDTO);

            assertAll(() -> assertEquals(emptyUserExternalApiDTO.getId(), mappedUserExternalApi.getId()),
                    () -> assertEquals(emptyUserExternalApiDTO.getClientId(), mappedUserExternalApi.getClientId()),
                    () -> assertEquals(emptyUserExternalApiDTO.getClientSecret(), mappedUserExternalApi.getClientSecret()),
                    () -> assertEquals(emptyUserExternalApiDTO.getUser(), mappedUserExternalApi.getUser()));
        }

        @Test
        @DisplayName("Should map partially empty UserExternalApiDTO to partially empty UserExternalApi")
        void test3() {
            UserExternalApi mappedUserExternalApi = userExternalApiMapper.from(partiallyEmptyUserExternalApiDTO);
            assertAll(() -> assertEquals(partiallyEmptyUserExternalApiDTO.getId(), mappedUserExternalApi.getId()),
                    () -> assertEquals(partiallyEmptyUserExternalApiDTO.getClientId(), mappedUserExternalApi.getClientId()),
                    () -> assertEquals(partiallyEmptyUserExternalApiDTO.getClientSecret(), mappedUserExternalApi.getClientSecret()),
                    () -> assertEquals(partiallyEmptyUserExternalApiDTO.getUser(), mappedUserExternalApi.getUser()));
        }
    }

}