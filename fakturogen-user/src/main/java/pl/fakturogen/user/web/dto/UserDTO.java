package pl.fakturogen.user.web.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private Long id;
    private String email;
    private String firstname;
    private String lastname;
}
