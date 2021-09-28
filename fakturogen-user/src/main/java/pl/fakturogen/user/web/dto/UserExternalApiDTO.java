package pl.fakturogen.user.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author ewa-git
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserExternalApiDTO {

    private Long id;
    private String clientId;
    private String clientSecret;
    private UserDTO user;

}