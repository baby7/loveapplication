package com.love.myapplication.entity;

/**
 * 天气对象
 */
public class Weather {
    /**
     * 日期
     */
    private String date;
    /**
     * 天气
     */
    private String weather;
    /**
     * 温度
     */
    private String temperature;

    public Weather() {}

    public Weather(String date, String weather, String temperature) {
        this.date = date;
        this.weather = weather;
        this.temperature = temperature;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
