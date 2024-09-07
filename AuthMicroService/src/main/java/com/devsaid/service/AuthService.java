package com.devsaid.service;


import com.devsaid.dto.request.AuthRequest;
import com.devsaid.dto.response.LoginResponse;
import com.devsaid.entity.Auth;
import com.devsaid.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;

    public Auth register(AuthRequest authRequest){
       return authRepository.save (
                Auth.builder ()
                        .userName (authRequest.getUserName ())
                        .password (authRequest.getPassword ())
                        .email (authRequest.getEmail ())
                        .build ()
        );

    }

    public Boolean login(LoginResponse response){
        return authRepository.existsByUserNameAndPassword (response.getUserName (),response.getPassword ());
    }
}
