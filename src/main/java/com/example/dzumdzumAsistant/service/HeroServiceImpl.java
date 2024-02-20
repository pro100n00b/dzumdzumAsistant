package com.example.dzumdzumAsistant.service;



import com.example.dzumdzumAsistant.model.HeroStat;
import com.example.dzumdzumAsistant.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HeroServiceImpl implements HeroService {


    private final HeroRepository heroRepository;

    @Autowired
    public HeroServiceImpl(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    @Override
    public void saveHero(HeroStat hero) {
        heroRepository.save(hero);
    }

    public List<String> topHero(int id){
        return heroRepository.topHero(id);
    }

}
