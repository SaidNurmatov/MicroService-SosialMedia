package com.devsaid.service;

import com.devsaid.document.UserProfile;
import com.devsaid.dto.request.CreateUserProfileRequest;
import com.devsaid.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileService {
    private final UserProfileRepository userProfileRepository;

    public void createUserProfile(@RequestBody CreateUserProfileRequest request){
        userProfileRepository.save (UserProfile.builder ()
                        .authId (request.getAuthId ())
                        .userName (request.getUsername ())
                        .email (request.getEmail ())

                .build ());
    }

    public List< UserProfile> getAll(){
        return userProfileRepository.findAll ();
    }
}
