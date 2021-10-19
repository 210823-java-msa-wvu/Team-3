package dev.vu.controllers;

import dev.vu.beans.Message;
import dev.vu.beans.User;
import dev.vu.repositories.MessageHibernate;
import dev.vu.repositories.UsersHibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {


    private MessageHibernate mHibernate;

    @Autowired
    public MessageController(MessageHibernate mHibernate) {
        this.mHibernate = mHibernate;
    }

    //    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @GetMapping
    public List<Message> getAllMessages() {
        return mHibernate.getAll();
    }

    /*@GetMapping(path = "/{username}")
    public User getByUsername(@PathVariable("username") String username){
        System.out.println(username);
        return mHibernate.getByUsername(username);
    }*/

    @GetMapping(path="/{id}") // this is the syntax to use PathVariables -> :8080/SpringMVCDemo/users/10
    public Message getById(@PathVariable("id") int id) {
        return mHibernate.getById(id);
    }

    //    @RequestMapping(method=RequestMethod.PUT, path="/users")
    @PostMapping(consumes = "application/json", produces = "application/json")
    public Message addMessage(@RequestBody Message message) { // @RequestBody -> instead of om.readValue(request.getReader(), User.class)
        return mHibernate.add(message);
    }

    @PutMapping(path="/{id}") // http://localhost:8080/SpringMVCDemo/users/1
    public void updateMessage(@PathVariable("id") int id, @RequestBody Message message) {
        if (id == message.getId()) {
            mHibernate.update(message);
        }
    }

    @DeleteMapping(path="/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        mHibernate.delete(id);
    }
}
