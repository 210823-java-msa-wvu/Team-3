package dev.knapp.repositories;

import dev.knapp.beans.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface CardRepo extends JpaRepository<Card,Integer> {

}
