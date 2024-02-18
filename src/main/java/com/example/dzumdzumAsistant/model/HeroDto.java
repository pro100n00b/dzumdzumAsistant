package com.example.dzumdzumAsistant.model;




import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties
public class HeroDto {


    private int hero_id;


    private int wins;


    private int games_played;



}
