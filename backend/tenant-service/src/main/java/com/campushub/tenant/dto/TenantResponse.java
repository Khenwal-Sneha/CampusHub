package com.campushub.tenant.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
public class TenantResponse {

    private UUID id;

    private String collegeName;

    private String slug;

    private String officialEmail;

    private String status;

    private Boolean verified;

    private List<String> domains;
}