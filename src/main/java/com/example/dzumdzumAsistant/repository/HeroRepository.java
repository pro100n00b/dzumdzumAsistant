package com.example.dzumdzumAsistant.repository;

import com.example.dzumdzumAsistant.model.HeroStat;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface HeroRepository extends JpaRepository<HeroStat, Integer> {

    @Query("SELECT pk.hero_id , pk.hero_enemy_id, CAST(SUM(wins) AS float) / CAST(SUM(games_played) AS float) * 100 AS procent\n" +
            "FROM HeroStat \n" +
            "GROUP BY pk.hero_enemy_id, pk.hero_id\n" +
            "HAVING pk.hero_id = :id\n" +
            "ORDER BY 3 DESC\n" +
            "LIMIT 10")
    List<String> topHero(@Param("id") int id);


}