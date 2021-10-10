package pl.fakturogen.web.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WebErrorResponse {
    private String errorStatus;
    private String errorMessage;
    private String [] errorDetails;
}
