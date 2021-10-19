package dev.vu.beans;

import javax.persistence.*;


@Entity
@Table(name="books")
public class Card {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String cardInfo;

    public Card() {}

    public Card(String cardInfo) {
        this.cardInfo = cardInfo;
    }

    public Card(Integer id, String cardInfo) {
        this.id = id;
        this.cardInfo = cardInfo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(String cardInfo) {
        this.cardInfo = cardInfo;
    }
}
