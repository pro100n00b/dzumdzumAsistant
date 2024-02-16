package com.example.dzumdzumAsistant.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "metaDOTA")
@Data
public class Hero {


    @Id
    private Long hero_id;

    @Column
    private double procentWin;

    @Column
    private String localized_name;


    public Hero(Long hero_id, double procentWin) {
        this.hero_id = hero_id;
        this.procentWin = procentWin;
    }

    public Hero() {

    }

    public Hero( String localized_name, Long hero_id) {
        this.localized_name = localized_name;
        this.hero_id = hero_id;
    }

    @Override
    public String toString() {
        return hero_id + " " + procentWin + "\n";
    }
}
