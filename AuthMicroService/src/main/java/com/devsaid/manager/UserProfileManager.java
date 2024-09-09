package com.devsaid.manager;

import com.devsaid.dto.request.CreateUserProfileRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.devsaid.config.RestApis.CREATE_USER;

@FeignClient(url = "http://service-loadbalancer-user:8081/dev/v1/user-profile",name = "userProfileManager")
public interface UserProfileManager {

    @PostMapping(CREATE_USER)
    ResponseEntity<Boolean> createUserProfile(@RequestBody CreateUserProfileRequest request);

}
