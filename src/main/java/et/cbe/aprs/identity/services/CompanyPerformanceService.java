package et.cbe.aprs.identity.services;

import et.cbe.aprs.identity.models.CompanyPerformance;

import java.time.LocalDate;
import java.util.List;

public interface CompanyPerformanceService {
    public CompanyPerformance saveCompanyPerformance(CompanyPerformance companyPerformance);

    public List<CompanyPerformance> findCompanyPerformances();

    public List<CompanyPerformance> findByCompanyIdAndDateRange(Long companyId, LocalDate startDate, LocalDate endDate);
}
