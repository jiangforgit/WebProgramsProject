package com.db.entitys;

import javax.persistence.*;

@Entity
@Table(name = "province_tb", schema = "user_center", catalog = "")
public class ProvinceTbEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ProvinceId")
    private int provinceId;
    @Basic
    @Column(name = "ProvinceName")
    private String provinceName;
    @Basic
    @Column(name = "ProvinceCountryId")
    private int provinceCountryId;

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getProvinceCountryId() {
        return provinceCountryId;
    }

    public void setProvinceCountryId(int provinceCountryId) {
        this.provinceCountryId = provinceCountryId;
    }
}
