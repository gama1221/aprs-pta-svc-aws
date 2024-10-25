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
public class CompanyPerformance {
    private Long id;
    private Long companyId;
    private LocalDate date;
    private Double revenue;
    private Double profile;
    private Double expenditure;
}
