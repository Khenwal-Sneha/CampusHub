package com.campushub.tenant.impl;

import com.campushub.tenant.dto.CreateTenantRequest;
import com.campushub.tenant.dto.TenantResponse;
import com.campushub.tenant.entity.Tenant;
import com.campushub.tenant.entity.TenantDomain;
import com.campushub.tenant.entity.TenantStatus;
import com.campushub.tenant.exception.DomainAlreadyExistsException;
import com.campushub.tenant.exception.TenantNotFoundException;
import com.campushub.tenant.repository.TenantDomainRepository;
import com.campushub.tenant.repository.TenantRepository;
import com.campushub.tenant.service.TenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TenantServiceImpl implements TenantService {

    private final TenantRepository tenantRepository;
    private final TenantDomainRepository tenantDomainRepository;

    @Override
    @Transactional
    public TenantResponse registerTenant(
            CreateTenantRequest request
    ) {

        for (String domain : request.getDomains()) {

            if (tenantDomainRepository.existsByDomain(domain)) {
                throw new DomainAlreadyExistsException(
                        "Domain already registered: " + domain
                );
            }
        }

        String slug = generateSlug(
                request.getCollegeName()
        );

        Tenant tenant = Tenant.builder()
                .id(UUID.randomUUID())
                .collegeName(request.getCollegeName())
                .slug(slug)
                .officialEmail(request.getOfficialEmail())
                .officialPhone(request.getOfficialPhone())
                .website(request.getWebsite())
                .address(request.getAddress())
                .status(TenantStatus.PENDING)
                .verified(false)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        tenantRepository.save(tenant);

        List<String> domains = request.getDomains();

        for (int i = 0; i < domains.size(); i++) {

            TenantDomain tenantDomain =
                    TenantDomain.builder()
                            .id(UUID.randomUUID())
                            .tenant(tenant)
                            .domain(domains.get(i))
                            .verified(false)
                            .primaryDomain(i == 0)
                            .createdAt(LocalDateTime.now())
                            .build();

            tenantDomainRepository.save(
                    tenantDomain
            );
        }

        return TenantResponse.builder()
                .id(tenant.getId())
                .collegeName(tenant.getCollegeName())
                .slug(tenant.getSlug())
                .officialEmail(tenant.getOfficialEmail())
                .status(tenant.getStatus().name())
                .verified(tenant.getVerified())
                .domains(domains)
                .build();
    }

    private String generateSlug(String input) {

        return input.toLowerCase()
                .replaceAll("[^a-z0-9 ]", "")
                .replaceAll("\\s+", "-");
    }

    @Override
@Transactional(readOnly = true)
public TenantResponse getTenantByDomain(
        String domain
) {

    TenantDomain tenantDomain =
            tenantDomainRepository
                    .findByDomain(domain)
                    .orElseThrow(() ->
                            new TenantNotFoundException(
                                    "Tenant not found for domain: "
                                            + domain
                            )
                    );

    Tenant tenant = tenantDomain.getTenant();

    List<String> domains =
            tenantDomainRepository.findAll()
                    .stream()
                    .filter(td ->
                            td.getTenant()
                                    .getId()
                                    .equals(tenant.getId())
                    )
                    .map(TenantDomain::getDomain)
                    .toList();

    return TenantResponse.builder()
            .id(tenant.getId())
            .collegeName(tenant.getCollegeName())
            .slug(tenant.getSlug())
            .officialEmail(
                    tenant.getOfficialEmail()
            )
            .status(
                    tenant.getStatus().name()
            )
            .verified(
                    tenant.getVerified()
            )
            .domains(domains)
            .build();
}
}