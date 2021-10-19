package dev.vu.controllers;

import dev.vu.beans.User;

import dev.vu.repositories.UsersHibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UsersHibernate usersHibernate;

    @Autowired
    public UserController(UsersHibernate usersHibernate) {
        this.usersHibernate = usersHibernate;
    }

//    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @GetMapping
    public List<User> getAllUsers() {
        return usersHibernate.getAll();
    }

    @GetMapping(path = "/{username}")
    public User getByUsername(@PathVariable("username") String username){
        System.out.println(username);
        return usersHibernate.getByUsername(username);
    }

}
