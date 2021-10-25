package dev.vu.repositories;

import dev.vu.beans.Card;
import dev.vu.beans.Character;

import java.util.List;

public interface CharacterRepo extends CrudRepository<Character> {

    // Read
    Character getById(Integer id);
    //Card getByFirstName(String firstName);
    List<Character> getAll();

    // Create
    Character add(Character a);

    // Update - this will eventually become a PUT Http Request
    void update(Character a);

    // Delete
    void delete(Integer id);
}
