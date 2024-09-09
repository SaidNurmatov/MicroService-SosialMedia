package com.devsaid.service;


import com.devsaid.dto.request.AuthRequest;
import com.devsaid.dto.request.CreateUserProfileRequest;
import com.devsaid.dto.response.LoginResponse;
import com.devsaid.entity.Auth;
import com.devsaid.manager.UserProfileManager;
import com.devsaid.repository.AuthRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;

    private final UserProfileManager userProfileManager;

    @Transactional
    public Auth register(AuthRequest authRequest) {
        try {
            // Auth nesnesini kaydediyoruz
            Auth auth = authRepository.save(
                    Auth.builder()
                            .userName(authRequest.getUserName())
                            .password(authRequest.getPassword())
                            .email(authRequest.getEmail())
                            .build()
            );

            // Kullanıcı profili oluşturuyoruz (Feign Client ile çağrı)
            userProfileManager.createUserProfile(
                    CreateUserProfileRequest.builder()
                            .authId(auth.getId())
                            .email(auth.getEmail())
                            .username(auth.getUserName())
                            .build()
            );

            return auth;

        } catch (Exception e) {
            System.err.println("Error during registration: " + e.getMessage());

            throw new RuntimeException("Registration failed. Please try again later.");
        }
    }

    public Boolean login(LoginResponse response){
        return authRepository.existsByUserNameAndPassword (response.getUserName (),response.getPassword ());
    }
}
