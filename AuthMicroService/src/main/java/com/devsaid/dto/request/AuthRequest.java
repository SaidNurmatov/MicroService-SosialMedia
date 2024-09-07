package com.devsaid.dto.request;

import com.devsaid.entity.Auth;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {

     String userName;
     String password;
     String repassword;
     String email;

}
