package com.example.dzumdzumAsistant.repository;

import com.example.dzumdzumAsistant.model.HeroStat;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface HeroRepository extends JpaRepository<HeroStat, Integer> {

    @Query("SELECT  new HeroStat (pk.hero_id, pk.hero_enemy_id, pk.value_date, wins, games_played) FROM  HeroStat ORDER BY games_played DESC LIMIT 5")
    List<HeroStat> topHero();

}