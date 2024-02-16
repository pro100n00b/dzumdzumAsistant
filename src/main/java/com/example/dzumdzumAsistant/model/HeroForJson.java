package com.example.dzumdzumAsistant.model;




import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties
public class HeroForJson {


    private Long hero_id;


    private double wins;


    private double games_played;



}
