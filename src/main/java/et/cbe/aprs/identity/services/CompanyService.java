package et.cbe.aprs.identity.services;

import et.cbe.aprs.identity.models.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    public Company saveCompany(Company company);

    public List<Company> findCompany();

    public Optional<Company> findCompanyById(Long id);
}
