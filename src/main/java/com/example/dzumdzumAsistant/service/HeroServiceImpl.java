package com.example.dzumdzumAsistant.service;



import com.example.dzumdzumAsistant.model.HeroStat;
import com.example.dzumdzumAsistant.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class HeroServiceImpl implements HeroService {


    private HeroRepository heroRepository;

    @Autowired
    public HeroServiceImpl(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    @Override
    public void saveHero(HeroStat hero) {
        heroRepository.save(hero);
    }

   public List<HeroStat> topHero() {
        return heroRepository.topHero();
   }
}
