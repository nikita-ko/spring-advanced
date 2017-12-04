package beans.controllers;

import beans.models.User;
import beans.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/user")
    public User register(User user) {
        return userService.register(user);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/user")
    public ResponseEntity remove(User user) {
        userService.remove(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(path = "/user/{id}")
    public User getById(@PathVariable("id") long id) {
        return userService.getById(id);
    }

    @RequestMapping(path = "/user/{email}")
    public User getUserByEmail(@PathVariable("email") String email) {
        return userService.getUserByEmail(email);
    }

    @RequestMapping(path = "/users/{name}")
    public List<User> getUsersByName(@PathVariable("name") String name) {
        return userService.getUsersByName(name);
    }
}
