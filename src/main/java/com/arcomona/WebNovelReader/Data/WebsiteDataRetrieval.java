package com.arcomona.WebNovelReader.Data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;


public class WebsiteDataRetrieval {

    public String dataRetrieval(String url) throws IOException {

        Document data = Jsoup.connect(url).get();

        return data.toString();
    }
}
