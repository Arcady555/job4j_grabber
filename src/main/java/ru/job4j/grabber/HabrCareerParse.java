package ru.job4j.grabber;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.grabber.utils.DateTimeParser;
import ru.job4j.grabber.utils.Parse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HabrCareerParse implements Parse {

    private static final String SOURCE_LINK = "https://career.habr.com";

    private static final String PAGE_LINK = String.format("%s/vacancies/java_developer?page=", SOURCE_LINK);

    private final DateTimeParser dateTimeParser;

    public HabrCareerParse(DateTimeParser dateTimeParser) {
        this.dateTimeParser = dateTimeParser;
    }

    private String retrieveDescription(String link) throws IOException {
        Connection connection = Jsoup.connect(link);
        Document document = connection.get();
        Element descriptionElement = document.selectFirst(".style-ugc");
        return descriptionElement.text();
    }

    @Override
    public List<Post> list(String link) {
        List<Post> vacancies = new ArrayList<>();
        for (int num = 1; num <= 5; num++) {
            Connection connection = Jsoup.connect(PAGE_LINK + num);
            Document document = null;
            try {
                document = connection.get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Elements rows = document.select(".vacancy-card__inner");
            rows.forEach(row -> {
                Element titleElement = row.select(".vacancy-card__title").first();
                Element linkElement = titleElement.child(0);
                Element dateElement =  row.select(".vacancy-card__date").first();
                Element timeElement = dateElement.child(0);
                Post post = parsePost(titleElement, linkElement, dateElement, timeElement);
                vacancies.add(post);
            });
        }
        return vacancies;
    }

    private Post parsePost(Element titleElement, Element linkElement, Element dateElement, Element timeElement) {
        String vacancyName = titleElement.text();
        String vacancyLink = String.format("%s%s", SOURCE_LINK, linkElement.attr("href"));
        String time = timeElement.attr("datetime");
        String description = null;
        try {
            description = retrieveDescription(vacancyLink);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LocalDateTime created = dateTimeParser.parse(time);
        return new Post(vacancyName, vacancyLink, description, created);
    }
}