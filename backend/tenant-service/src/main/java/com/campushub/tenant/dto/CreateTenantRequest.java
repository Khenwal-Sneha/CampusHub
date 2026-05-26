package com.campushub.tenant.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateTenantRequest {

    @NotBlank
    private String collegeName;

    @Email
    @NotBlank
    private String officialEmail;

    @NotBlank
    private String officialPhone;

    private String website;

    private String address;

    @NotEmpty
    private List<String> domains;
}