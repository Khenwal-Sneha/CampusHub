package com.campushub.tenant.controller;

import com.campushub.tenant.dto.CreateTenantRequest;
import com.campushub.tenant.dto.TenantResponse;
import com.campushub.tenant.service.TenantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tenants")
@RequiredArgsConstructor
public class TenantController {

    private final TenantService tenantService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TenantResponse registerTenant(
            @Valid @RequestBody
            CreateTenantRequest request
    ) {

        return tenantService.registerTenant(
                request
        );
    }

    @GetMapping("/domain/{domain}")
public TenantResponse getTenantByDomain(
        @PathVariable String domain
) {

    return tenantService.getTenantByDomain(
            domain
    );
}
}