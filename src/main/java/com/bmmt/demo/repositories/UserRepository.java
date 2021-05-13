package com.bmmt.demo.repositories;

import com.bmmt.demo.entities.UserProfile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserProfile, Long> {
    //@Query("Select u from UserProfile u where u.userName = ?1")
    UserProfile findUserByUserName(String userName);
}
