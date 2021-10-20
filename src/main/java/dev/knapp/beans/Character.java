package dev.knapp.beans;

import javax.persistence.*;

@Entity
@Table(name="characters")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String characterName;
    private Integer health;


    public Character(){}

    public Character(Integer id, String characterName, Integer health) {
        this.id = id;
        this.characterName = characterName;
        this.health = health;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", characterName='" + characterName + '\'' +
                ", health=" + health +
                '}';
    }
}
