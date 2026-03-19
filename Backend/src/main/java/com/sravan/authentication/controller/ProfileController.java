package com.sravan.authentication.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.*;

import com.sravan.authentication.exception.BusinessException;
import com.sravan.authentication.io.ProfileRequest;
import com.sravan.authentication.io.ProfileResponse;
import com.sravan.authentication.service.EmailService;
import com.sravan.authentication.service.ProfileService;

@RestController
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;
    private final EmailService emailService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ProfileResponse register(@Valid @RequestBody ProfileRequest request){
        ProfileResponse response=profileService.createProfile(request);
        try{
            emailService.sendWelcomeEmail(response.getEmail(),response.getName());
        }
        catch(Exception ex){
            throw new BusinessException("Unable to send email",HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @GetMapping("/profile")
    public ProfileResponse getProfile(@CurrentSecurityContext(expression = "authentication?.name") String email) {
        return profileService.getProfile(email);
    }
}
