package et.cbe.aprs.identity.controllers;

import et.cbe.aprs.identity.models.CompanyPerformance;
import et.cbe.aprs.identity.services.CompanyPerformanceService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/company-performance")
public class CompanyPerformanceController {
    private final CompanyPerformanceService companyPerformanceService;

    public CompanyPerformanceController(CompanyPerformanceService companyPerformanceService) {
        this.companyPerformanceService = companyPerformanceService;
    }

    @GetMapping
    public List<CompanyPerformance> getAllCompanies() {
        return companyPerformanceService.findCompanyPerformances();
    }

    @PostMapping
    public CompanyPerformance saveCompany(@RequestBody CompanyPerformance company) {
        return companyPerformanceService.saveCompanyPerformance(company);
    }

    @GetMapping("/search")
    public List<CompanyPerformance> getPerformanceByCompanyIdAndDateRange(@RequestParam Long companyId,
                                                                          @RequestParam String startDate,
                                                                          @RequestParam String endDate) {
        return companyPerformanceService.findByCompanyIdAndDateRange(companyId,
                LocalDate.parse(startDate),
                LocalDate.parse(endDate));
    }
}
