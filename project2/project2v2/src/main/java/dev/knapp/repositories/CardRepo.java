package dev.vu.repositories;

import dev.vu.beans.Card;

import java.util.List;

public interface CardRepo extends CrudRepository<Card>{

    // Read
    Card getById(Integer id);
    //Card getByFirstName(String firstName);
    List<Card> getAll();

    // Create
    Card add(Card a);

    // Update - this will eventually become a PUT Http Request
    void update(Card a);

    // Delete
    void delete(Integer id);
}
