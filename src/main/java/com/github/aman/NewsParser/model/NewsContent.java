package com.github.aman.NewsParser.model;

public class NewsContent {
    String headline;
    String date;
    String content;
    String url;

    public NewsContent(String headline, String date, String content, String url) {
        this.headline = headline;
        this.date = date;
        this.content = content;
        this.url = url;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "NewsContent{" +
                "headline='" + headline + '\'' +
                ", date='" + date + '\'' +
                ", content='" + content + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
