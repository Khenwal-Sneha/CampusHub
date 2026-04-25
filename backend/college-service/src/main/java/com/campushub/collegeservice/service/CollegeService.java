package com.campushub.collegeservice.service;

import com.campushub.collegeservice.dto.ApiResponse;
import com.campushub.collegeservice.dto.RegisterCollegeRequest;
import com.campushub.collegeservice.dto.VerifyOtpRequest;
import com.campushub.collegeservice.entity.College;
import com.campushub.collegeservice.exception.BadRequestException;
import com.campushub.collegeservice.exception.ResourceNotFoundException;
import com.campushub.collegeservice.repository.CollegeRepository;
import com.campushub.collegeservice.util.OtpUtil;
import org.springframework.stereotype.Service;

@Service
public class CollegeService {

    private final CollegeRepository repository;

    public CollegeService(CollegeRepository repository) {
        this.repository = repository;
    }

    public ApiResponse<String> registerCollege(RegisterCollegeRequest request) {

        repository.findByEmail(request.getEmail()).ifPresent(c -> {
            throw new BadRequestException("College already registered with this email");
        });

        // domain validation
        if (!request.getEmail().endsWith("@" + request.getDomain())) {
            throw new BadRequestException("Email must match domain");
        }

        String otp = OtpUtil.generateOtp();

        College college = College.builder()
                .name(request.getName())
                .email(request.getEmail())
                .domain(request.getDomain())
                .verified(false)
                .otp(otp)
                .build();

        repository.save(college);

        return ApiResponse.<String>builder()
                .success(true)
                .message("OTP sent successfully")
                .data(otp) // temporary (for testing)
                .build();
    }

    public ApiResponse<String> verifyOtp(VerifyOtpRequest request) {

        College college = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("College not found"));

        if (!college.getOtp().equals(request.getOtp())) {
            throw new BadRequestException("Invalid OTP");
        }

        college.setVerified(true);
        college.setOtp(null);
        repository.save(college);

        return ApiResponse.<String>builder()
                .success(true)
                .message("College verified successfully")
                .data(null)
                .build();
    }
}