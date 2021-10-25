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

    @GetMapping(path="/{id}") // this is the syntax to use PathVariables -> :8080/SpringMVCDemo/users/10
    public User getById(@PathVariable("id") int id) {
        return usersHibernate.getById(id);
    }

    //    @RequestMapping(method=RequestMethod.PUT, path="/users")
    @PostMapping(consumes = "application/json", produces = "application/json")
    public User addUser(@RequestBody User user) { // @RequestBody -> instead of om.readValue(request.getReader(), User.class)
        return usersHibernate.add(user);
    }

    @PutMapping(path="/{id}") // http://localhost:8080/SpringMVCDemo/users/1
    public void updateUser(@PathVariable("id") int id, @RequestBody User user) {
        if (id == user.getId()) {
            usersHibernate.update(user);
        }
    }

    @DeleteMapping(path="/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        usersHibernate.delete(id);
    }

}
