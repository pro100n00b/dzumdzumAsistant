package com.example.dzumdzumAsistant.model;


import jakarta.persistence.*;
import lombok.Data;



@Entity
@Table(name = "metaDOTA")
@Data
public class HeroStat {


    @EmbeddedId
    private HeroStatPK pk;


    @Column
    private int wins;

    @Column
    private int games_played;




    public HeroStat() {

    }

    public HeroStat( int wins, int games_played, HeroStatPK pk) {

        this.wins = wins;
        this.games_played = games_played;
        this.pk = pk;

    }

    @Override
    public String toString() {
        return wins + " " + games_played;
    }


}
