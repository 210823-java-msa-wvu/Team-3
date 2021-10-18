package dev.vu.repositories;

import dev.vu.beans.Users;

import java.util.List;

public interface UserRepo<U> extends CrudRepository<Users> {

    Users add(Users users);

    Users getById(Integer id);

    Users getByUsername(String username);

    List<Users> getAll();

    void update(Users users);

    void delete(Integer id);
}
