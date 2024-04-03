package com.assessment.assessment.service;
import com.assessment.assessment.model.User;
import com.assessment.assessment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {

        userRepository.save(user);
    }

    public User getUserById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

    public boolean existsById(long id) {
        return userRepository.existsById(id);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }
    public boolean existsByName(String name) {
        return userRepository.existsByName(name);
    }
}