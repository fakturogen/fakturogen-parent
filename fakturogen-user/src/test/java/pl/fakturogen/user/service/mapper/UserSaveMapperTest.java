package pl.fakturogen.user.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.fakturogen.user.dao.entity.User;
import pl.fakturogen.user.web.dto.UserSaveDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserSaveMapperTest {
    UserSaveMapper userSaveMapper;
    UserSaveDTO userSaveDTO;
    User user;

    @BeforeEach
    void setup() {
        userSaveMapper = new UserSaveMapper();
    }

    @DisplayName(" - should return User filled with all fields")
    @Test
    public void test1() {
        userSaveDTO = UserSaveDTO.builder()
                .id(1L)
                .email("test@email.com")
                .firstname("Jan")
                .lastname("Kowalski")
                .password("passwd")
                .rePassword("passwd")
                .build();

        user = new User();
        user.setId(userSaveDTO.getId());
        user.setEmail(userSaveDTO.getEmail());
        user.setFirstName(userSaveDTO.getFirstname());
        user.setLastName(userSaveDTO.getLastname());
        user.setPassword(userSaveDTO.getPassword());

        User result = userSaveMapper.from(userSaveDTO);

        assertEquals(user, result);
    }

    @DisplayName(" - should return empty object")
    @Test
    public void test2() {
        userSaveDTO = new UserSaveDTO();
        user = new User();

        User result = userSaveMapper.from(userSaveDTO);

        assertEquals(user, result);
    }

}