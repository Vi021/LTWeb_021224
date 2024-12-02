package vn.iostar.ltweb_161224.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import vn.iostar.ltweb_161224.model.user;
import vn.iostar.ltweb_161224.service.UserService;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @QueryMapping
    public List<user> findAllUsers() {
        return userService.findAllUsers();
    }

    @MutationMapping
    public user createUser(@Argument user input) {
        return userService.saveUser(input);
    }

    @MutationMapping
    public user updateUser(@Argument user input) {
        return userService.updateUser(input);
    }

    @MutationMapping
    public Boolean deleteUser(@Argument Long id) {
        userService.deleteUser(id);
        return true;
    }
}
