package pl.fakturogen.api.token;

import lombok.Data;

@Data
public class ApiToken {
    private String accessToken;
    public String tokenType;
    public int expires;
}
