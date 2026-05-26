package com.campushub.tenant.service;

import com.campushub.tenant.dto.CreateTenantRequest;
import com.campushub.tenant.dto.TenantResponse;

public interface TenantService {
    TenantResponse registerTenant(CreateTenantRequest request);
    TenantResponse getTenantByDomain(String domain);
}