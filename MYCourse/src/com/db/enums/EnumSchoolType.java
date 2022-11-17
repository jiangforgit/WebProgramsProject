package com.db.enums;

public enum EnumSchoolType {
    training_agency(0,"培训机构"),

    nursery_education(1,"幼儿园"),

    prisecondary_education(2,"中小学"),

    highschool_education(3,"高中"),

    university_education(4,"大学");

    private int type = 0;
    private String typeDes = "";

    private EnumSchoolType(int mType,String mTypeDes){
        this.type = mType;
        this.typeDes = mTypeDes;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTypeDes() {
        return typeDes;
    }

    public void setTypeDes(String typeDes) {
        this.typeDes = typeDes;
    }
}
