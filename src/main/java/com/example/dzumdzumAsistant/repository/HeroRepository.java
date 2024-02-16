package com.example.dzumdzumAsistant.repository;

import com.example.dzumdzumAsistant.model.Hero;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Integer> {

    @Query("SELECT new Hero(hero_id, procentWin) from Hero ORDER BY procentWin DESC LIMIT 5")
    public List<Hero> topHero();


}