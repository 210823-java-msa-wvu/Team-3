package dev.knapp.repositories;

import dev.knapp.beans.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepo extends JpaRepository<Character, Integer> {


}
