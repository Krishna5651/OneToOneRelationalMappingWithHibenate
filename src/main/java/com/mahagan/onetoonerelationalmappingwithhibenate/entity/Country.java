/**
 * Created By Krishna Shinde
 * Date : 24-06-2023
 * Time : 21:51
 * Project: OneToOneRelationalMappingWithHibenate
 **/

package com.mahagan.onetoonerelationalmappingwithhibenate.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Country {
    @Id
    @GeneratedValue(generator = "gen")
    @GenericGenerator(name = "gen",strategy = "foreign",parameters = {@org.hibernate.annotations.Parameter(name = "property",value = "capital")})
    private int country_id;
    private String country_Name;
    private String country_Continent;
    private String country_Population;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Capital capital;

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public String getCountry_Name() {
        return country_Name;
    }

    public void setCountry_Name(String country_Name) {
        this.country_Name = country_Name;
    }

    public String getCountry_Continent() {
        return country_Continent;
    }

    public void setCountry_Continent(String country_Continent) {
        this.country_Continent = country_Continent;
    }

    public String getCountry_Population() {
        return country_Population;
    }

    public void setCountry_Population(String country_Population) {
        this.country_Population = country_Population;
    }

    public Capital getCapital() {
        return capital;
    }

    public void setCapital(Capital capital) {
        this.capital = capital;
    }
}


