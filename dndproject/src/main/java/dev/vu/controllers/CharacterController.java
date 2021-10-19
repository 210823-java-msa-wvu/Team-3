package dev.vu.controllers;

import dev.vu.beans.Character;
import dev.vu.beans.User;
import dev.vu.repositories.CharacterHibernate;
import dev.vu.repositories.UsersHibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/characters")
public class CharacterController {


    private CharacterHibernate charHibernate;

    @Autowired
    public CharacterController(CharacterHibernate charHibernate) {
        this.charHibernate = charHibernate;
    }

    //    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @GetMapping
    public List<Character> getAllCharacters() {
        return charHibernate.getAll();
    }

    /*@GetMapping(path = "/{username}")
    public User getByUsername(@PathVariable("username") String username){
        System.out.println(username);
        return charHibernate.getByUsername(username);
    }*/

    @GetMapping(path="/{id}") // this is the syntax to use PathVariables -> :8080/SpringMVCDemo/users/10
    public Character getById(@PathVariable("id") int id) {
        return charHibernate.getById(id);
    }

    //    @RequestMapping(method=RequestMethod.PUT, path="/users")
    @PostMapping(consumes = "application/json", produces = "application/json")
    public Character addCharacter(@RequestBody Character character) { // @RequestBody -> instead of om.readValue(request.getReader(), User.class)
        return charHibernate.add(character);
    }

    @PutMapping(path="/{id}") // http://localhost:8080/SpringMVCDemo/users/1
    public void updateCharacter(@PathVariable("id") int id, @RequestBody Character character) {
        if (id == character.getId()) {
            charHibernate.update(character);
        }
    }

    @DeleteMapping(path="/{id}")
    public void deleteCharacter(@PathVariable("id") int id) {
        charHibernate.delete(id);
    }
}
