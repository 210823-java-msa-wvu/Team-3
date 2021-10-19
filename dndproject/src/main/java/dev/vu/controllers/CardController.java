package dev.vu.controllers;

import dev.vu.beans.Card;
import dev.vu.beans.User;
import dev.vu.repositories.CardHibernate;
import dev.vu.repositories.UsersHibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {


    private CardHibernate cardHibernate;

    @Autowired
    public CardController(CardHibernate cardHibernate) {
        this.cardHibernate = cardHibernate;
    }

    //    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @GetMapping
    public List<Card> getAllCards() {
        return cardHibernate.getAll();
    }

    /*@GetMapping(path = "/{cardname}")
    public User getByUsername(@PathVariable("username") String username){
        System.out.println(username);
        return cardHibernate.getByUsername(username);
    }*/

    @GetMapping(path="/{id}") // this is the syntax to use PathVariables -> :8080/SpringMVCDemo/users/10
    public Card getById(@PathVariable("id") int id) {
        return cardHibernate.getById(id);
    }

    //    @RequestMapping(method=RequestMethod.PUT, path="/users")
    @PostMapping(consumes = "application/json", produces = "application/json")
    public Card addCard(@RequestBody Card card) { // @RequestBody -> instead of om.readValue(request.getReader(), User.class)
        return cardHibernate.add(card);
    }

    @PutMapping(path="/{id}") // http://localhost:8080/SpringMVCDemo/users/1
    public void updateCard(@PathVariable("id") int id, @RequestBody Card card) {
        if (id == card.getId()) {
            cardHibernate.update(card);
        }
    }

    @DeleteMapping(path="/{id}")
    public void deleteCard(@PathVariable("id") int id) {
        cardHibernate.delete(id);
    }
}
