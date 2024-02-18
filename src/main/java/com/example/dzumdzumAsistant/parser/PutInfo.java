package com.example.dzumdzumAsistant.parser;

import com.example.dzumdzumAsistant.model.HeroStat;
import com.example.dzumdzumAsistant.model.HeroDto;
import com.example.dzumdzumAsistant.service.HeroService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Component
public class PutInfo {
    private final Gson gson = new Gson();

    RestTemplate restTemplate = new RestTemplate();

    private final HeroService heroService;

    @Autowired
    public PutInfo(HeroService heroService) {
        this.heroService = heroService;
    }

    public void getHeroes() {


        for (int id = 1; id < 123; id++) {

            List s = restTemplate.getForObject(String.format("https://api.opendota.com/api/heroes/%s/matchups", id), List.class);

            Date date = new java.util.Date();


            for (Object x :
                    s) {

                HeroDto heroDto = gson.fromJson(String.valueOf(x), HeroDto.class);

                HeroStat hero = new HeroStat(id, heroDto.getHero_id(), heroDto.getWins(), heroDto.getGames_played(), date);

                heroService.saveHero(hero);

            }
        }

    }
}
