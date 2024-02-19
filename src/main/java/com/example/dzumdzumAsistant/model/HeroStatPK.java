package com.example.dzumdzumAsistant.model;


import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Embeddable
@Data
public class HeroStatPK implements Serializable {

    private int hero_id;

    private int hero_enemy_id;

    private Date value_date;

    public HeroStatPK(int hero_id, int hero_enemy_id, Date value_date) {
        this.hero_id = hero_id;
        this.hero_enemy_id = hero_enemy_id;
        this.value_date = value_date;

    }


    public HeroStatPK() {

    }
}
