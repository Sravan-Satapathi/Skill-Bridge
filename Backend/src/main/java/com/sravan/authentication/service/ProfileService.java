package com.sravan.authentication.service;


import com.sravan.authentication.io.ProfileRequest;
import com.sravan.authentication.io.ProfileResponse;

public interface ProfileService {

    ProfileResponse createProfile(ProfileRequest request);
    ProfileResponse getProfile(String email);
    void sendResetOtp(String email);
    void resetPassword(String email, String otp, String newPassword);
}
