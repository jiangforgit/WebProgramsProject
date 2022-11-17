package com.db.enums;

public enum EnumScheduleTaskType {

    one_day(0,"一次"),

    every_week(1,"每周"),

    every_week_workday(2,"每周工作日"),

    every_week_weekend(3,"每周末"),

    every_week_firstday(4,"每周第一天（周日）"),

    every_week_lastday(5,"每周最后一天（周六）"),

    every_day(6,"每天"),

    every_day_morning(7,"每天早上"),

    every_day_afternoon(8,"每天下午"),

    every_month(9,"每个月的某一天"),

    every_month_firstday(10,"每个月的第一天"),

    every_month_lastday(11,"每个月的最后一天");

    private int type = 0;
    private String typeDes = "";

    private EnumScheduleTaskType(int tp,String ds){
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
