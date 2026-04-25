package com.campushub.collegeservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterCollegeRequest {

    @NotBlank
    private String name;

    @Email
    private String email;

    @NotBlank
    private String domain;
}