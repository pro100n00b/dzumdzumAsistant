package com.example.dzumdzumAsistant.parser;

import com.example.dzumdzumAsistant.model.HeroStat;
import com.example.dzumdzumAsistant.model.HeroDto;
import com.example.dzumdzumAsistant.model.HeroStatPK;
import com.example.dzumdzumAsistant.service.HeroService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDate;
import java.util.List;


@Component
public class PutInfo {
    private final Gson gson = new Gson();

    private final RestTemplate restTemplate = new RestTemplate();


    private final HeroService heroService;


    @Autowired
    public PutInfo(HeroService heroService) {
        this.heroService = heroService;
    }


    @Scheduled(fixedRate = 21600000 )
    private void getHeroesStatFirstStep() {

        for (int id = 1; id < 41; id++) {
            for (Object x :
                    getJson(id)) {

                HeroDto heroDto = gson.fromJson(String.valueOf(x), HeroDto.class);

                heroService.saveHero(new HeroStat(heroDto.getWins(), heroDto.getGames_played(),
                        new HeroStatPK(id, heroDto.getHero_id(), getDate())));
            }
        }
    }

    @Scheduled(fixedRate = 21720000 , initialDelay = 120000)
    public void getHeroesStatSecondStep() {


        for (int id = 41; id < 82; id++) {
            for (Object x :
                    getJson(id)) {

                HeroDto heroDto = gson.fromJson(String.valueOf(x), HeroDto.class);

                heroService.saveHero(new HeroStat(heroDto.getWins(), heroDto.getGames_played(),
                        new HeroStatPK(id, heroDto.getHero_id(), getDate())));


            }
        }


    }

    @Scheduled(fixedRate = 21840000,  initialDelay = 240000)
    public void getHeroesStatThirdsStep() {


        for (int id = 82; id < 124; id++) {
            for (Object x :
                    getJson(id)) {

                HeroDto heroDto = gson.fromJson(String.valueOf(x), HeroDto.class);

                heroService.saveHero(new HeroStat(heroDto.getWins(), heroDto.getGames_played(),
                        new HeroStatPK(id, heroDto.getHero_id(), getDate())));
            }
        }
    }

    public List getJson(int id) {
        return restTemplate.getForObject(String.format("https://api.opendota.com/api/heroes/%s/matchups", id), List.class);
    }

    public LocalDate getDate() {
        return LocalDate.now();

    }
}
