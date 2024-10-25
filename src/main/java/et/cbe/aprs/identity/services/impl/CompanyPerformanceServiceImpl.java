package et.cbe.aprs.identity.services.impl;

import et.cbe.aprs.identity.models.CompanyPerformance;
import et.cbe.aprs.identity.services.CompanyPerformanceService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class CompanyPerformanceServiceImpl implements CompanyPerformanceService {
    private final Map<Long, CompanyPerformance> store = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();

    public CompanyPerformanceServiceImpl() {
        saveCompanyPerformance(new CompanyPerformance(
                null,
                1L,
                LocalDate.of(2023, 9, 1),
                120000.0, 30000.0, 90000.0)
        );
        saveCompanyPerformance(new CompanyPerformance(
                null,
                1L,
                LocalDate.of(2023, 9, 15),
                130000.0,
                35000.0,
                95000.0)
        );
        saveCompanyPerformance(new CompanyPerformance(
                null,
                2L,
                LocalDate.of(2023, 9, 1),
                200000.0,
                50000.0,
                150000.0)
        );
    }

    @Override
    public CompanyPerformance saveCompanyPerformance(CompanyPerformance companyPerformance) {
        Long id = counter.incrementAndGet();
        companyPerformance.setId(id);
        store.put(id, companyPerformance);
        return companyPerformance;
    }

    @Override
    public List<CompanyPerformance> findCompanyPerformances() {
        return new ArrayList<>(store.values());
    }

    @Override
    public List<CompanyPerformance> findByCompanyIdAndDateRange(Long companyId, LocalDate startDate, LocalDate endDate) {
        return store.values().stream()
                .filter(performance -> performance.getCompanyId().equals(companyId) &&
                        !performance.getDate().isBefore(startDate) && !performance.getDate().isAfter(endDate))
                .collect(Collectors.toList());
    }
}
