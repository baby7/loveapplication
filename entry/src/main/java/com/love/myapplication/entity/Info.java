package com.love.myapplication.entity;

import cn.hutool.core.util.RandomUtil;

import java.util.List;

/**
 * 全部信息
 */
public class Info {

    private final String[] colorArr = new String[]{"red", "#fb7b5a", "#ff4500", "green", "blue", "#af52a7"};

    private String toDay;
    private String week;
    private String lunarCalendar;
    private String days;
    private List<NextCommemorationDay> commemorationDayList;
    private List<Weather> weatherList;
    private String inAWordContent;
    private News news;
    private String city;
    private List<String> colorList;

    public String getColor() {
       return RandomUtil.randomEle(colorArr);
    }

    public String[] getColorArr() {
        return colorArr;
    }

    public String getToDay() {
        return toDay;
    }

    public void setToDay(String toDay) {
        this.toDay = toDay;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getLunarCalendar() {
        return lunarCalendar;
    }

    public void setLunarCalendar(String lunarCalendar) {
        this.lunarCalendar = lunarCalendar;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public List<NextCommemorationDay> getCommemorationDayList() {
        return commemorationDayList;
    }

    public void setCommemorationDayList(List<NextCommemorationDay> commemorationDayList) {
        this.commemorationDayList = commemorationDayList;
    }

    public List<Weather> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(List<Weather> weatherList) {
        this.weatherList = weatherList;
    }

    public String getInAWordContent() {
        return inAWordContent;
    }

    public void setInAWordContent(String inAWordContent) {
        this.inAWordContent = inAWordContent;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<String> getColorList() {
        return colorList;
    }

    public void setColorList(List<String> colorList) {
        this.colorList = colorList;
    }
}
