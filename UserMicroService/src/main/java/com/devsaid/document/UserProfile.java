package com.devsaid.document;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {

    @Id
    String id = new ObjectId ().toString();  // ID'yi otomatik oluştur
    Long authId;
    String name;
    String SurName;
    String password;
    String userName;
    String email;
    String phone;
    String address;
    String avatar;
    String instagram;
    String x;
    Boolean isActive;
    Long createdAt;
}
