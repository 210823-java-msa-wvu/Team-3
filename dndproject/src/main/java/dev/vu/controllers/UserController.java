package dev.vu.controllers;

import dev.vu.beans.Users;

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
    public List<Users> getAllUsers() {
        return usersHibernate.getAll();
    }

    @GetMapping(path = "/{username}")
    public Users getByUsername(@PathVariable("username") String username){
        System.out.println(username);
        return usersHibernate.getByUsername(username);
    }

}
