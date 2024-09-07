package com.devsaid.controller;

import com.devsaid.dto.request.AuthRequest;
import com.devsaid.dto.response.LoginResponse;
import com.devsaid.entity.Auth;
import com.devsaid.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.devsaid.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(AUTHSERVICE)
public class AuthController {
    private final AuthService authService;


    @PostMapping(REGESTER)
    public ResponseEntity< Auth >register(@RequestBody AuthRequest authRequest){
        //psw controller
        if (!authRequest.getPassword ().equals(authRequest.getRepassword ()))
            throw new RuntimeException ("Passwords do not match");

        return ResponseEntity.ok (authService.register(authRequest));
    }

    @PostMapping(LOGIN)
    public ResponseEntity<Boolean>login(@RequestBody LoginResponse response){
        return ResponseEntity.ok (authService.login(response));

    }


}
