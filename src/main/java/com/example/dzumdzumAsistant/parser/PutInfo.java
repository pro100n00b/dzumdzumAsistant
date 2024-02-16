package com.example.dzumdzumAsistant.parser;

import com.example.dzumdzumAsistant.model.Hero;
import com.example.dzumdzumAsistant.model.HeroForJson;
import com.example.dzumdzumAsistant.service.HeroService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

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

    public void getHeroes(int id) {
        List s = restTemplate.getForObject(String.format("https://api.opendota.com/api/heroes/%s/matchups", id), List.class);


        for (Object x :
                s) {

            HeroForJson heroForJson = gson.fromJson(String.valueOf(x), HeroForJson.class);

            Hero hero = new Hero(heroForJson.getHero_id(),
                    heroForJson.getWins() / heroForJson.getGames_played() * 100);

            heroService.saveHero(hero);

        }

    }
}
