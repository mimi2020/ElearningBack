package org.example.pfeamal.Services;

import org.example.pfeamal.Entities.User;
import org.example.pfeamal.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService  {

    @Autowired
    private UserRepository userRepository;
    public User createUser(User user) {
        return  userRepository.save(user);
    }
    public User updateUser(User user) {
        return  userRepository.save(user);
    }
    public List<User> allUsers() {
        return userRepository.findAll();
    }
    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
