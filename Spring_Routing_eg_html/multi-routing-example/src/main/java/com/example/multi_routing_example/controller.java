package com.example.multiroutingexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MultiRoutingController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/signup")
    public String handleSignup(@RequestParam String username, @RequestParam String password, Model model) {
        // Handle signup logic here
        model.addAttribute("message", "User " + username + " signed up successfully!");
        return "home";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username, @RequestParam String password, Model model) {
        // Handle login logic here
        model.addAttribute("message", "User " + username + " logged in successfully!");
        return "home";
    }

    @GetMapping("/profile/{username}")
    public String profile(@PathVariable String username, Model model) {
        model.addAttribute("username", username);
        return "profile";
    }

    @PutMapping("/update-profile")
    public String updateProfile(@RequestParam String username, @RequestParam String email, Model model) {
        // Handle profile update logic here
        model.addAttribute("message", "Profile of " + username + " updated with email " + email);
        return "home";
    }

    @DeleteMapping("/delete-account")
    public String deleteAccount(@RequestParam String username, Model model) {
        // Handle account deletion logic here
        model.addAttribute("message", "Account of " + username + " deleted successfully!");
        return "home";
    }
}
