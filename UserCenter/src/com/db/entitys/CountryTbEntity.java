package com.db.entitys;

import javax.persistence.*;

@Entity
@Table(name = "country_tb", schema = "user_center", catalog = "")
public class CountryTbEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CountryId")
    private int countryId;
    @Basic
    @Column(name = "CountryName")
    private String countryName;
    @Basic
    @Column(name = "CountryContinentId")
    private int countryContinentId;

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getCountryContinentId() {
        return countryContinentId;
    }

    public void setCountryContinentId(int countryContinentId) {
        this.countryContinentId = countryContinentId;
    }
}
