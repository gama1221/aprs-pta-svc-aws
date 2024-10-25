package et.cbe.aprs.identity.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Company {
    private Long id;
    private String name;
    private String industry;
    private String headquarters;
    private LocalDate foundedDate;
}
