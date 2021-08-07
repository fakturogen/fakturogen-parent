package pl.fakturogen.web.controller.rest;

import org.springframework.boot.ApplicationArguments;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.fakturogen.comarch.connector.model.ComarchToken;
import pl.fakturogen.comarch.connector.connector.ComarchApiTokenConnector;

import java.io.IOException;

@RestController
public class TokenController {
    private ApplicationArguments applicationArguments;
    private ComarchApiTokenConnector comarchApiTokenConnector;

    public TokenController(ApplicationArguments applicationArguments, ComarchApiTokenConnector comarchApiTokenConnector) {
        this.applicationArguments = applicationArguments;
        this.comarchApiTokenConnector = comarchApiTokenConnector;
    }

    @RequestMapping("/getToken")
    public ComarchToken getToken() throws IOException {
        String[] args = applicationArguments.getSourceArgs();
        comarchApiTokenConnector.setClientId(args[0]);
        comarchApiTokenConnector.setSecret(args[1]);
        return comarchApiTokenConnector.getToken();
    }
}
