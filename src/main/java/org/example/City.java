package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class City {
    @JsonProperty("city")
    private String name;

    @JsonProperty("population")
    private int population;

    @JsonProperty("admin_name")
    private String wojewodztwo;

    public City() {
    }

    public City(String name, int population, String wojewodztwo) {
        this.name = name;
        this.population = population;
        this.wojewodztwo = wojewodztwo;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return this.population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getWojewodztwo() {
        return this.wojewodztwo;
    }

    public void setWojewodztwo(String wojewodztwo) {
        this.wojewodztwo = wojewodztwo;
    }

    @Override
    public String toString() {
        return "Miasto: " + name + ", populacja: " + population + ", województwo: " + wojewodztwo;
    }
}
