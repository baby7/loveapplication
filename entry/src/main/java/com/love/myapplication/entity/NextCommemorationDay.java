package com.love.myapplication.entity;

/**
 * 即将到来的纪念日
 */
public class NextCommemorationDay {

    /**
     * 纪念日名称
     */
    private String name;

    /**
     * 纪念日倒计时
     */
    private Long countdown;

    /**
     * 是否为今天
     */
    private Boolean today;

    /**
     * 是否不为今天
     */
    private Boolean otherday;

    public NextCommemorationDay() {
    }

    public NextCommemorationDay(String name, Long countdown) {
        this.name = name;
        this.countdown = countdown;
        this.today = true;
        this.otherday = false;
        if (countdown != 0) {
            this.today = false;
            this.otherday = true;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCountdown() {
        return countdown;
    }

    public void setCountdown(Long countdown) {
        this.countdown = countdown;
    }

    public Boolean getToday() {
        return today;
    }

    public void setToday(Boolean today) {
        this.today = today;
    }

    public Boolean getOtherday() {
        return otherday;
    }

    public void setOtherday(Boolean otherday) {
        this.otherday = otherday;
    }
}
