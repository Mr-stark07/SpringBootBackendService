package com.gfg.divy.SpringBootBackendService.Service;

import com.gfg.divy.SpringBootBackendService.Model.User;
import com.gfg.divy.SpringBootBackendService.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User createUser(User user){
        userRepository.save(user);
        return user;
    }

    public User getUserById(Long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }

        return null;
    }

    public User updateUser(User user){
        userRepository.save(user);
        return user;
    }

    public User deleteUser(Long id){
        User user = getUserById(id);
        userRepository.deleteById(id);
        return user;
    }
}
