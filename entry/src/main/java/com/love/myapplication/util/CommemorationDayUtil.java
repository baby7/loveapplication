package com.love.myapplication.util;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.love.myapplication.entity.CommemorationDay;
import com.love.myapplication.entity.NextCommemorationDay;
import org.hothub.calendarist.Calendarist;
import org.hothub.calendarist.pojo.SolarDate;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 纪念日工具类
 */
public class CommemorationDayUtil {

    /**
     * 获取需要显示的纪念日列表
     * @param date 日期
     * @param dayList 纪念日列表
     */
    public static List<NextCommemorationDay> getCommemorationDayList(Date date, List<CommemorationDay> dayList) {
        List<NextCommemorationDay> list = new ArrayList<>(); // 需要显示的列表
        int year = DateUtil.year(DateUtil.date());
        for (CommemorationDay commemorationDay : dayList) {
            StringBuffer day = new StringBuffer(year + "-");
            if (CommemorationDay.SolarCalendar.equals(commemorationDay.getType())) { // 如果是阳历
                day.append(commemorationDay.getMonth()).append("-").append(commemorationDay.getDay());
            } else if (CommemorationDay.LunarCalendar.equals(commemorationDay.getType())) { // 如果是阴历
                SolarDate solarDate = Calendarist.fromLunar(year, commemorationDay.getMonth(), commemorationDay.getDay()).toSolar();
                day.append(solarDate.getMonth()).append("-").append(solarDate.getDay());
            }
            day.append(" 23:59:59");
            //如果今年还没过
            long l = DateUtil.between(date, DateUtil.parse(day), DateUnit.DAY, false);
            if (l >= 0 && l <= 30) {
                list.add(new NextCommemorationDay(commemorationDay.getName(), l));
            }
        }
        // 排序
        list = list.stream()
                .sorted(Comparator.comparing(NextCommemorationDay::getCountdown))
                .collect(Collectors.toList());
        return list;
    }
}
