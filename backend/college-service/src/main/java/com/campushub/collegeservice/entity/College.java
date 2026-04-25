package com.campushub.collegeservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "colleges")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String domain;

    @Column(nullable = false)
    private boolean verified;

    @Column
    private String otp;
}