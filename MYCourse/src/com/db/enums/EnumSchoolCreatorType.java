package com.db.enums;

public enum EnumSchoolCreatorType {
    family_creator("家庭创建"),

    teacherManager_creator("学校或机构管理者创建"),

    superManager_creator("超级管理员创建");

    private String creatorTypeDes = "";
    private EnumSchoolCreatorType(String des){
        this.creatorTypeDes = des;
    }

    public String getCreatorTypeDes() {
        return creatorTypeDes;
    }
}
