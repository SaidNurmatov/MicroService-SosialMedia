package com.devsaid.controller;

import com.devsaid.document.UserProfile;
import com.devsaid.dto.request.CreateUserProfileRequest;
import com.devsaid.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.devsaid.config.RestApis.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(USERPROFILE)
public class UserProfileController {
    private final UserProfileService userProfileService;


    //ToDo
    // donen degerleri DTO ile yap


    @PostMapping(CREATE_USER)
   public ResponseEntity<Boolean> createUserProfile(@RequestBody CreateUserProfileRequest request) {
        userProfileService.createUserProfile(request);
        return ResponseEntity.ok (true);
    }



    @GetMapping(GET_ALL)
    public ResponseEntity< List< UserProfile > >getAllUserProfiles() {
        return ResponseEntity.ok (userProfileService.getAll());
    }

}
