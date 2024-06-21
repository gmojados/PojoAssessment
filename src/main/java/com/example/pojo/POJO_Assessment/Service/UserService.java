package com.example.pojo.POJO_Assessment.Service;

import com.example.pojo.POJO_Assessment.Model.User;
import com.example.pojo.POJO_Assessment.Repos.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    public User createUser(User user) {
        logger.info("User Successfully Created");
        return userRepository.save(user);
    }

    public void getUserById(Long userId) {
        logger.info("Successfully Retrieved Customer: " + userId);
        if (userId == null) {
            throw new IllegalArgumentException("Account Does Not Exist");
        }
       userRepository.findById(userId);
    }

    public Iterable<User> getAllUsers (){
        logger.info("Retrieved All Users");
        Iterable<User> users = userRepository.findAll();
        return users;
    }

    public void deleteUser(Long userId){
        if (userId == null) {
            logger.error("User not found");
        }
        logger.info("User has Successfully been Deleted");
        userRepository.deleteById(userId);
    }
    @Transactional
    public User updateUser (User user, Long userId){
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + userId + " not found"));
        existingUser.setGender(user.getGender());
        existingUser.setName(user.getName());
        return userRepository.save(existingUser);
    }


}
