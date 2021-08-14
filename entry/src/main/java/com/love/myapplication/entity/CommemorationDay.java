package com.love.myapplication.entity;


/**
 * 纪念日实体类
 */
public class CommemorationDay {

    /**
     * 纪念日名字
     */
    private String name;

    /**
     * 纪念日 - 月
     */
    private Integer month;

    /**
     * 纪念日 - 日
     */
    private Integer day;

    /**
     * 纪念日日期类型[0:阳历，1:阴历]
     */
    private Integer type;

    /**
     * 阳历
     */
    public final static Integer SolarCalendar = 0;

    /**
     * 阴历
     */
    public final static Integer LunarCalendar = 1;

    public CommemorationDay() {
    }

    public CommemorationDay(String name, Integer month, Integer day, Integer type) {
        this.name = name;
        this.month = month;
        this.day = day;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public static Integer getSolarCalendar() {
        return SolarCalendar;
    }

    public static Integer getLunarCalendar() {
        return LunarCalendar;
    }
}
