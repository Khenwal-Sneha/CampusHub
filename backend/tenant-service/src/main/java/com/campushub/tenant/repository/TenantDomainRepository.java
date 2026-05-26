package com.campushub.tenant.repository;

import com.campushub.tenant.entity.TenantDomain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TenantDomainRepository extends JpaRepository<TenantDomain, UUID> {

    Optional<TenantDomain> findByDomain(String domain);

    boolean existsByDomain(String domain);

    List<TenantDomain> findByTenantId(
        UUID tenantId
);
}