package com.in28minutes.mvc;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class LoginService {
    private List<String> users = Arrays.asList("in28Minutes", "johnDoe", "janeSmith");
    
    public boolean validateUser(String user, String password) {
        return (user.equalsIgnoreCase("in28Minutes") && password.equals("dummy")) ||
               (user.equalsIgnoreCase("johnDoe") && password.equals("password123")) ||
               (user.equalsIgnoreCase("janeSmith") && password.equals("letmein"));
    }
    
    public boolean userExists(String user) {
        return users.contains(user);
    }
}