package loginPage.pageForLogin.controller;

import loginPage.pageForLogin.UserRepository;
import loginPage.pageForLogin.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Controller class for handling application requests.
 */
@Controller
public class AppController {

    @Autowired
    private UserRepository userRepo;

    /**
     * Handles the request for the home page.
     *
     * @return the name of the Thymeleaf template for the home page
     */
    @GetMapping("/")
    public String viewHomePage() {
        return "index";
    }

    /**
     * Handles the request for the login page.
     *
     * @return the name of the Thymeleaf template for the login page
     */
    @GetMapping("/login")
    public String login(){
        return "loginPage";
    }

    /**
     * Handles the request for logging out.
     *
     * @return the name of the Thymeleaf template for the page to be directed when login
     */
    @GetMapping("/logout")
    public String logOut(){
        return "loginPage";
    }

    /**
     * Handles the request for displaying the registration form.
     *
     * @param model the Model object for passing data to the view
     * @return the name of the Thymeleaf template for the registration form
     */
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "SignUpForm";
    }

    /**
     * Handles the request for processing the registration form.
     *
     * @param user the User object containing the registration data
     * @return the name of the Thymeleaf template for the registration success page
     */
    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);

        return "register_success";
    }

    /**
     * Handles the request for displaying the list of users.
     *
     * @param model the Model object for passing data to the view
     * @return the name of the Thymeleaf template for displaying the list of users
     */
    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = userRepo.findAll();
        model.addAttribute("users", listUsers); // Rename the attribute to "users"
        return "userv1"; // Return the name of the Thymeleaf template
    }

    /**
     * Handles the request for saying hello.
     *
     * @return a ResponseEntity with the "hai" message
     */
    @GetMapping("/greeting")
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("hai");
    }

    /**
     * Handles the request for saying goodbye.
     *
     * @return a ResponseEntity with the "bye" message
     */
    @GetMapping("/goodBye")
    public ResponseEntity<String> sayGoodbye(){
        return ResponseEntity.ok("bye");
    }
}

