package pl.fakturogen.user.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSaveDTO {

    private Long id;
    private String email;
    private String password;
    private String rePassword;
    private String firstname;
    private String lastname;

}
