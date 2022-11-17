package com.db.entitys;

import javax.persistence.*;

@Entity
@Table(name = "continent_tb", schema = "user_center", catalog = "")
public class ContinentTbEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ContinentId")
    private int continentId;
    @Basic
    @Column(name = "ContinentName")
    private String continentName;

    public int getContinentId() {
        return continentId;
    }

    public void setContinentId(int continentId) {
        this.continentId = continentId;
    }

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }
}
