
package com.in28minutes.mvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    
    @Autowired
    private LoginService service;
    
    @RequestMapping(value ="/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model) {
        model.addAttribute("errorMessage", ""); // Clear any previous error messages
        return "login";
    }
    
    @RequestMapping(value ="/login", method = RequestMethod.POST)
    public String handleLoginRequest(@RequestParam String name, @RequestParam String password, ModelMap model) {
        if (name.isEmpty() || password.isEmpty()) {
            model.addAttribute("errorMessage", "Username or password cannot be empty");
            return "login";
        }
        
        boolean isValidUser = service.validateUser(name, password);
        if (!isValidUser) {
            if (!service.userExists(name)) {
                model.addAttribute("errorMessage", "Invalid username");
            } else {
                model.addAttribute("errorMessage", "Invalid password");
            }
            return "login";
        }
        
        // Clear error message on successful login
        model.addAttribute("errorMessage", "");
        
        model.addAttribute("name", name);
        model.addAttribute("password", password);
        return "welcome";
    }
}