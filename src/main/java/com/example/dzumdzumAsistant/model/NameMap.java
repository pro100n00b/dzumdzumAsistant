package com.example.dzumdzumAsistant.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class NameMap {


    int id;
    String localized_name;


}
