package com.example.dzumdzumAsistant.handlers;

import com.example.dzumdzumAsistant.model.HeroStat;
import com.example.dzumdzumAsistant.service.HeroServiceImpl;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Handlers {
    private final HeroServiceImpl heroService;

    private final RestTemplate restTemplate = new RestTemplate();

    private final Gson gson = new Gson();

    @Autowired
    public Handlers(HeroServiceImpl heroService) {
        this.heroService = heroService;
    }

    public String getTop() {
        StringBuilder stringBuilder = new StringBuilder();

        for (HeroStat x :
                heroService.topHero()) {
            stringBuilder.append(x)
                    .append("\n");


        }

        return stringBuilder.toString();


    }


//    public Map<Integer, String> getName() {
//        Map<Integer, String> names = new HashMap<>();
//
//        List s = restTemplate.getForObject("https://api.opendota.com/api/heroes", List.class);
//
//        for (Object x :
//                s) {
//
//            System.out.println(x);
//
//        }
//        return names;
//    }
}
