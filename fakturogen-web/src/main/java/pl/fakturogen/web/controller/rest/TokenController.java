package pl.fakturogen.web.controller.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.ApplicationArguments;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.fakturogen.comarchconnector.connector.ComarchApiTokenConnector;

import java.io.IOException;

@RestController
@Getter
@Setter
@AllArgsConstructor
public class TokenController {
    private ApplicationArguments applicationArguments;
    private ComarchApiTokenConnector comarchApiTokenConnector;

    @RequestMapping("/getToken")
    public String getToken() throws IOException {
        String[] args = applicationArguments.getSourceArgs();
        comarchApiTokenConnector.setClientId(args[0]);
        comarchApiTokenConnector.setSecret(args[1]);
        return comarchApiTokenConnector.getToken();
    }

}
