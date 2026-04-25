package com.campushub.collegeservice.controller;

import com.campushub.collegeservice.dto.ApiResponse;
import com.campushub.collegeservice.dto.RegisterCollegeRequest;
import com.campushub.collegeservice.dto.VerifyOtpRequest;
import com.campushub.collegeservice.service.CollegeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/college")
public class CollegeController {

    private final CollegeService service;

    public CollegeController(CollegeService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ApiResponse<String> register(@Valid @RequestBody RegisterCollegeRequest request) {
        return service.registerCollege(request);
    }

    @PostMapping("/verify")
    public ApiResponse<String> verify(@RequestBody VerifyOtpRequest request) {
        return service.verifyOtp(request);
    }
}