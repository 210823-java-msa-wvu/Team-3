package dev.knapp.repositories;

import dev.knapp.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
    User findByUsername(String username);
}

/*public interface UserRepo<U> extends CrudRepository<User> {

    User add(User user);

    User getById(Integer id);

    User getByUsername(String username);

    List<User> getAll();

    void update(User user);

    void delete(Integer id);
}*/
