package com.bmmt.demo.services;

import com.bmmt.demo.entities.UserProfile;
import com.bmmt.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) { this.userRepository = userRepository;
    }

    public Iterable<UserProfile> index() {return userRepository.findAll();}

    public UserProfile create(UserProfile userProfile) { return userRepository.save(userProfile);
    }

    public UserProfile show(Long id) { return userRepository.findById(id).get(); }

    public UserProfile findUserName(String userName) {
        return userRepository.findUserByUserName(userName);
    }


    public UserProfile update(Long id, UserProfile newUserProfile) {
        UserProfile original = userRepository.findById(id).get();
        original.setId(newUserProfile.getId());
        original.setUserName(newUserProfile.getUserName());
        original.setAddress(newUserProfile.getAddress());
        original.setOccupation(newUserProfile.getOccupation());
        original.setPassword(newUserProfile.getPassword());
        original.setPhoneNumber(newUserProfile.getPhoneNumber());
        original.setEmail(newUserProfile.getEmail());
        return userRepository.save(original);
    }

    public Boolean delete(Long id) {
        userRepository.deleteById(id);
        return true;
    }
}
