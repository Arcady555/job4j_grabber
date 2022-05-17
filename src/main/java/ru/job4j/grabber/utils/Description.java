package ru.job4j.grabber.utils;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Description {
    private String retrieveDescription(String link) throws IOException {
        Connection connection = Jsoup.connect(link);
        Document document = connection.get();
        Element descriptionElement = document.select(".job_show_description").first();
        return descriptionElement.text();
    }

    public static void main(String[] args) throws IOException {
        Description description = new Description();
        System.out.println(description.retrieveDescription("https://career.habr.com/vacancies/1000096513"));
    }
}
