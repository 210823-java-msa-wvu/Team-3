package dev.vu.repositories;

import dev.vu.beans.Card;
import dev.vu.beans.Message;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message>{
    // Read
    Message getById(Integer id);
    //Card getByFirstName(String firstName);
    List<Message> getAll();

    // Create
    Message add(Message a);

    // Update - this will eventually become a PUT Http Request
    void update(Message a);

    // Delete
    void delete(Integer id);
}
