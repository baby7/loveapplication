package com.love.myapplication.util;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.love.myapplication.entity.Weather;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 天气工具类
 */
public class WeatherUtil {

    // 天气api键
    private static final String KEY = "13e9fc385f8df0174776011957eb588a";

    // 填充天气内容
    public static List<Weather> getWeatherData(String city) {
        // 天气获取接口
        String url = "https://apis.juhe.cn/simpleWeather/query?city=" + city + "&key=" + KEY;
        JSONObject jsonObject = new JSONObject(HttpUtil.get(url));
        jsonObject = jsonObject.getJSONObject("result");
        JSONArray future = jsonObject.getJSONArray("future");
        return future.stream().map(f -> (JSONObject) f)
                .map(f -> new Weather(f.getStr("date"), f.getStr("weather"), f.getStr("temperature")))
                .collect(Collectors.toList());
    }
}
