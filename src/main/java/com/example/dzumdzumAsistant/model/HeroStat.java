package com.example.dzumdzumAsistant.model;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;



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

    public HeroStat(int hero_id , int hero_enemy_id, LocalDate value_date , int wins, int games_played) {
        this.wins = wins;
        this.games_played = games_played;
        this.pk = new HeroStatPK(hero_id, hero_enemy_id, value_date);
    }

    @Override
    public String toString() {

        return pk.getHero_id() + " " + pk.getHero_enemy_id() + " " + String.format( "%.2f",((double)wins / (double) games_played)* 100) + "%";

    }

}
