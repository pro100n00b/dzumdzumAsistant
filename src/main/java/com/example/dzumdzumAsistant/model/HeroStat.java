package com.example.dzumdzumAsistant.model;


import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name = "metaDOTA")
@Data
public class HeroStat {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private  int hero_id;

    @Column
    private int hero_enemy_id;

    @Column
    private int wins;

    @Column
    private int games_played;


    @Column
    private Date value_date;


    public HeroStat(int hero_id, int hero_enemy_id, int wins, int games_played, Date value_date) {
        this.hero_id = hero_id;
        this.hero_enemy_id = hero_enemy_id;
        this.wins = wins;
        this.games_played = games_played;
        this.value_date = value_date;
    }

    public HeroStat() {

    }

    public HeroStat (int hero_id, int wins, int games_played, int hero_enemy_id) {
        this.hero_id = hero_id;
        this.wins = wins;
        this.games_played = games_played;
        this.hero_enemy_id = hero_enemy_id;
    }

    @Override
    public String toString(){
        return hero_id + " " + wins + " " + games_played;
    }


}
