/**
 * Created By Krishna Shinde
 * Date : 24-06-2023
 * Time : 21:51
 * Project: OneToOneRelationalMappingWithHibenate
 **/

package com.mahagan.onetoonerelationalmappingwithhibenate.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Capital {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int capital_Id;
    private String capital_Name;
    private String capital_Population;
    private String capital_area;
    @OneToOne(mappedBy = "capital")
    @Cascade(value = CascadeType.ALL)
    private Country country;

    public int getCapital_Id() {
        return capital_Id;
    }

    public void setCapital_Id(int capital_Id) {
        this.capital_Id = capital_Id;
    }

    public String getCapital_Name() {
        return capital_Name;
    }

    public void setCapital_Name(String capital_Name) {
        this.capital_Name = capital_Name;
    }

    public String getCapital_Population() {
        return capital_Population;
    }

    public void setCapital_Population(String capital_Population) {
        this.capital_Population = capital_Population;
    }

    public String getCapital_area() {
        return capital_area;
    }

    public void setCapital_area(String capital_area) {
        this.capital_area = capital_area;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}


