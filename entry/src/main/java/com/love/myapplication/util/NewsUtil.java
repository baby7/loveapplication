package com.love.myapplication.util;

import cn.hutool.http.HttpUtil;
import com.love.myapplication.entity.News;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * 慧语简报工具类
 */
public class NewsUtil {

    // 获取慧语简报
    public static News getNewsData() {
        // 慧语简报获取接口
        String s = HttpUtil.get("https://news.topurl.cn");
        Document parse = Jsoup.parse(s);
        News news = new News();
        // 慧语简报
        news.setNewsWrap(parse.select(".news-wrap").first().html());
        // 历史上的今天
        news.setHistoryWrap(parse.select(".history-wrap").first().html());
        // 天天成语
        news.setPhraseWrap(parse.select(".phrase-wrap").first().html());
        // 慧语香风
        news.setWisdomWord(parse.select(".sentence-wrap .line span").first().html());
        // 进度条图
        news.setProgressBar(parse.select(".progress-bar").first().html());
        // 进度条文字
        news.setProgressBarValue(parse.select(".progress-bar + .line").first().html());
        return news;
    }
}
