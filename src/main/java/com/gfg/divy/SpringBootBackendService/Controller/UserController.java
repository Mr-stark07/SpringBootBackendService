package com.gfg.divy.SpringBootBackendService.Controller;

import com.gfg.divy.SpringBootBackendService.Model.User;
import com.gfg.divy.SpringBootBackendService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController implements ErrorController{

    @Autowired
    UserService userService;

    private static final String PATH = "/error";

    @Override
    public String getErrorPath() {
        return PATH;
    }

    @RequestMapping("/error")
    public String error(HttpServletRequest request, Model model){
//        String uri = request.getRequestURI();
//        model.addAttribute("error","Something went wrong");
        return "error";
    }

    @GetMapping("/")
    public String root(Model model){
        model.addAttribute("users",userService.findAllUsers());
        return "welcome";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user",new User());
        return "create";
    }

//    @GetMapping("/users")
//    public List<User> getAll(){
//        return userService.findAllUsers();
//    }
//
//    @GetMapping("/user/{id}")
//    public User getById(@PathVariable("id") Long id){
//        return userService.getUserById(id);
//    }

    @PostMapping("/user")
    public String create(@ModelAttribute User user){
        User user1 = userService.createUser(user);
        if(user1 != null){
            return "redirect:/";
        }
        return "redirect:/create";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model){
        model.addAttribute("user",userService.getUserById(id));
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute User user){
        User user1 = userService.updateUser(user);
        if(user1 != null)
            return "redirect:/";
        return "error";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        User user1 = userService.deleteUser(id);
        if(user1 != null)
            return "redirect:/";
        return "error";
    }
//
//
//    @GetMapping("/userInfo")
//    public String userInfo(){
//        RestTemplate restTemplate = new RestTemplate();
//        return restTemplate.getForObject("http://codeforces.com/api/user.info?handles=DmitriyH;Fefer_Ivan", String.class);
//    }
}
