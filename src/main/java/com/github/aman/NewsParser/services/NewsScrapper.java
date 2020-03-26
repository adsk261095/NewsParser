package com.github.aman.NewsParser.services;

import com.github.aman.NewsParser.model.NewsContent;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewsScrapper {

    @Value("${URL}")
    private String URL;
    private String lastupdated;
    List<NewsContent> news = new ArrayList<>();

    public String getLastupdated() {
        return lastupdated;
    }

    public void setLastupdated(String lastupdated) {
        this.lastupdated = lastupdated;
    }

    public List<NewsContent> getNews() {
        return news;
    }

    @PostConstruct
    @Scheduled(cron = "0 * * * * *")
    private void fetchNews() throws IOException {
        Document doc = Jsoup.connect(URL).get();
        List<NewsContent> latestNews = new ArrayList<>();
        setLastupdated(doc.select(".lastUpdated .flt").text());

        Elements newsList = doc.select(".data li");
        for (Element e:newsList
             ) {
            latestNews.add(new NewsContent(e.select("a").text(), e.select("span").text(), e.select("p").text(),"https://economictimes.indiatimes.com" + e.select("a").attr("href")));
        }
        news = new ArrayList<>(latestNews);
        latestNews.clear();


        System.out.println(getLastupdated());
        System.out.println(news);
        System.out.println(news.size());
    }
}
