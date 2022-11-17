package com.db.enums;

public enum EnumWeekCourseType {

    every_week(0,"每周"),

    every_week_workday(1,"每周工作日"),

    every_week_weekend(2,"每周末"),

    every_week_firstday(3,"每周第一天（周日）"),

    every_week_lastday(4,"每周最后一天（周六）"),

    every_day(5,"每天"),

    every_day_morning(6,"每天早上"),

    every_day_afternoon(7,"每天下午"),

    every_month(8,"每个月的某一天"),

    every_month_firstday(9,"每个月的第一天"),

    every_month_lastday(10,"每个月的最后一天"),

    one_day(11,"指定具体日期时间");

    private int type = 0;
    private String typeDes = "";

    private EnumWeekCourseType(int tp,String ds){
        this.type = tp;
        this.typeDes = ds;
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
