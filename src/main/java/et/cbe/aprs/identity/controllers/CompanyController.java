package et.cbe.aprs.identity.controllers;

import et.cbe.aprs.identity.models.Company;
import et.cbe.aprs.identity.services.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getAllCompanies() {
        return companyService.findCompany();
    }
    @GetMapping("/{id}")
    public Optional<Company> getCompanyById(@PathVariable Long id){
        return companyService.findCompanyById(id);
    }
    @PostMapping
    public Company saveCompany(@RequestBody Company company){
        return companyService.saveCompany(company);
    }
}
