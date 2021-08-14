package com.love.myapplication.util;

import cn.hutool.core.date.*;
import cn.hutool.http.HttpUtil;
import com.love.myapplication.entity.CommemorationDay;
import com.love.myapplication.entity.Info;
import org.jsoup.Jsoup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class InfoUtil {


    // 城市
    private static final String CITY = "天津";

    // 初识纪念日
    public static final Date LOVE_DAY = DateUtil.parse("2016-05-20");

    // 纪念日列表
    private static final List<CommemorationDay> DAY_LIST = Arrays.asList(
            new CommemorationDay("在一起纪念日", 5, 20, CommemorationDay.SolarCalendar),
            new CommemorationDay("东方情人节", 7, 7, CommemorationDay.LunarCalendar),
            new CommemorationDay("西方情人节", 2, 14, CommemorationDay.SolarCalendar),
            new CommemorationDay("520", 5, 20, CommemorationDay.SolarCalendar),
            new CommemorationDay("儿童节", 6, 1, CommemorationDay.SolarCalendar),
            new CommemorationDay("圣诞节", 12, 25, CommemorationDay.SolarCalendar),
            new CommemorationDay("女生节", 3, 7, CommemorationDay.SolarCalendar)
    );

    public static Info getInfo() {
        Info info = new Info();
        Date date = DateUtil.date();
        // 今天
        info.setToDay(DateUtil.format(date, DatePattern.CHINESE_DATE_PATTERN));
        // 星期转化
        info.setWeek(Week.of(DateUtil.dayOfWeek(date)).toChinese());
        // 农历
        info.setLunarCalendar(new ChineseDate(date).toString());
        // 天数
        info.setDays(Long.toString(DateUtil.between(LOVE_DAY, date, DateUnit.DAY)));
        // 颜色随机
        List<String> colorList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            colorList.add(info.getColor());
        }
        info.setColorList(colorList);
        // 下一个纪念日
        info.setCommemorationDayList(CommemorationDayUtil.getCommemorationDayList(date, DAY_LIST));
        // 填充天气内容
        info.setCity(CITY);
        info.setWeatherList(WeatherUtil.getWeatherData(CITY));
        // 填充一言内容
        info.setInAWordContent(Jsoup.parse(HttpUtil.get("https://wufazhuce.com")).select(".fp-one-cita").first().text());
        // 填充慧语简报
        info.setNews(NewsUtil.getNewsData());
        return info;
    }
}
