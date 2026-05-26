package com.campushub.tenant.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tenants")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tenant {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String collegeName;

    @Column(nullable = false, unique = true)
    private String slug;

    private String officialEmail;

    private String officialPhone;

    private String website;

    private String address;

    @Enumerated(EnumType.STRING)
    private TenantStatus status;

    private Boolean verified;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}