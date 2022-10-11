package com.example.registrationlogin.contrller;


import com.example.registrationlogin.AdminRepository;
import com.example.registrationlogin.UserRepository;
import com.example.registrationlogin.model.Admin;
import com.example.registrationlogin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private UserRepository repository;
    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }
//    Student section
    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user",new User());
        return "signup_form";
    }
    @PostMapping("process_register")
    public String processRegistration(User user){
        BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
        String encodedPassword=encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        repository.save(user);
        return "register_success";
    }

    @GetMapping("/list_users")
    public String  viewUsers(Model model){
        List<User> userList=repository.findAll();
        model.addAttribute("listUsers",userList);
        return "users";
    }
//    Admin section
    private AdminRepository adminRepository;
@GetMapping("/register_admin")
public String register_admin(Model model){
    model.addAttribute("admin",new Admin());
    return "signup_form_admin";
}
    @PostMapping("process_register_admin")
    public String processRegistration_admin(Admin admin){
        BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
        String encodedPassword=encoder.encode(admin.getPassword());
        admin.setPassword(encodedPassword);
        adminRepository.save(admin);
        return "register_success";
    }
//    Teacher section

}
