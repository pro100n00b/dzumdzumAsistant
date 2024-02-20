package com.example.dzumdzumAsistant.handlers;

import com.example.dzumdzumAsistant.model.HeroStat;
import com.example.dzumdzumAsistant.service.HeroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Handlers {
    private final HeroServiceImpl heroService;


    @Autowired
    public Handlers(HeroServiceImpl heroService) {
        this.heroService = heroService;
    }

    public String getTop(int id) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String x :
                heroService.topHero(id)) {
            stringBuilder.append(x)
                    .append("\n");

        }

        return stringBuilder.toString();
    }
}
