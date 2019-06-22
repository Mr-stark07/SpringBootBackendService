package com.gfg.divy.SpringBootBackendService.Controller;

import com.gfg.divy.SpringBootBackendService.Model.User;
import com.gfg.divy.SpringBootBackendService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getAll(){
        return userService.findAllUsers();
    }

    @GetMapping("/user/{id}")
    public User getById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @PostMapping("/user")
    public String create(@RequestBody User user){
        User user1 = userService.createUser(user);
        if(user1 != null)
            return "User created successfully.";
        return "Something went wrong";
    }

    @PutMapping("/user")
    public String update(@RequestBody User user){
        User user1 = userService.updateUser(user);
        if(user1 != null)
            return "User updated successfully.";
        return "Something went wrong";
    }

    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable Long id){
        User user1 = userService.deleteUser(id);
        if(user1 != null)
            return "User deleted successfully.";
        return "Something went wrong";
    }
}
