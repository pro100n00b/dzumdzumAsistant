package com.example.dzumdzumAsistant.service;



import com.example.dzumdzumAsistant.model.Hero;
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
    public void saveHero(Hero hero) {
        heroRepository.save(hero);
    }

   public List<Hero> topHero() {
        return heroRepository.topHero();
   }
}
