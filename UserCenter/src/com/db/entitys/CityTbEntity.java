package com.db.entitys;

import javax.persistence.*;

@Entity
@Table(name = "city_tb", schema = "user_center", catalog = "")
public class CityTbEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CityId")
    private int cityId;
    @Basic
    @Column(name = "CityName")
    private String cityName;
    @Basic
    @Column(name = "CityProvinceId")
    private int cityProvinceId;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCityProvinceId() {
        return cityProvinceId;
    }

    public void setCityProvinceId(int cityProvinceId) {
        this.cityProvinceId = cityProvinceId;
    }
}
