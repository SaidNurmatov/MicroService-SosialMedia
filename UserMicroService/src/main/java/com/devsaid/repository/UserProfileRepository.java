package com.devsaid.repository;


import com.devsaid.document.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserProfileRepository extends MongoRepository< UserProfile, String> {
}
