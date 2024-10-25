package et.cbe.aprs.identity.services.impl;

import et.cbe.aprs.identity.models.Company;
import et.cbe.aprs.identity.services.CompanyService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final Map<Long, Company> store = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();

    public CompanyServiceImpl() {
        saveCompany(new Company(null, "Blay AB Motors", "Machinery", "Addis Ababa", LocalDate.of(2000, 1, 1)));
        saveCompany(new Company(null, "Abyssinia Computers", "Hardware & Software", "Addis Ababa", LocalDate.of(2001, 1, 1)));
        saveCompany(new Company(null, "ALT Computers", "Software", "Addis Ababa", LocalDate.of(2001, 1, 1)));
    }

    @Override
    public Company saveCompany(Company company) {
        Long id = counter.incrementAndGet();
        company.setId(id);
        store.put(id, company);
        return company;
    }

    @Override
    public List<Company> findCompany() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Company> findCompanyById(Long id) {
        return Optional.ofNullable(store.get(id));
    }
}
