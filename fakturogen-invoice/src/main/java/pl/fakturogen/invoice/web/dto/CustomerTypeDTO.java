package pl.fakturogen.invoice.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author ewa-git
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerTypeDTO {

    private Long id;

    private String description;

}
