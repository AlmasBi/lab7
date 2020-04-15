package com.example.tt;

public class ExampleItem {
    public int id;
    public String title;
    public String url;


    public ExampleItem(String title,String url){

        this.title=title;
        this.url=url;

    }

    public String getTitle() {
        return title;
    }
    public String getUrl() {
        return url;
    }
}