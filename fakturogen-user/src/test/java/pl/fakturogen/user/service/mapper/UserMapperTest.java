package pl.fakturogen.user.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.fakturogen.user.dao.entity.User;
import pl.fakturogen.user.web.dto.UserDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserMapperTest {
    UserMapper userMapper;
    User user;
    // czy wrzucać deklaracje wszystkich obiektów w tym miejscu?

    @BeforeEach
    void setUp() {
        userMapper = new UserMapper();
    }
    @DisplayName(" - should return only fields from UserDTO")
    @Test
    void from() {
        user = new User();
        user.setId(1L);
        user.setFirstName("Jan");
        user.setLastName("Kowalski");
        user.setEmail("test@email.com");
        user.setPassword("passwd");

        UserDTO userDTO = UserDTO.builder()
                .id(user.getId())
                .firstname(user.getFirstName())
                .lastname(user.getLastName())
                .email(user.getEmail())
                .build();

        UserDTO result = userMapper.from(user);

        assertEquals(userDTO,result);

    }

    @DisplayName(" - should return null in certain fields")
    @Test
    void test2() {
        user = new User();
        user.setId(1L);
        user.setFirstName("Jan");

        UserDTO userDTO = UserDTO.builder()
                .id(user.getId())
                .firstname(user.getFirstName())
                .lastname(user.getLastName())
                .email(user.getEmail())
                .build();

        UserDTO result = userMapper.from(user);

        assertEquals(userDTO,result);
    }

    @DisplayName(" - should return empty fields")
    @Test
    void test3 () {
        user = new User();
        UserDTO userDTO = new UserDTO();

        UserDTO result = userMapper.from(user);

        assertEquals(userDTO,result);
    }
}