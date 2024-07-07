package com.arcomona.WebNovelReader.Data;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class WebsiteDataRetrieval {

    public String dataRetrieval(String url) throws IOException {

        String page = url;
        //Connecting to the web page
        Connection conn = Jsoup.connect(page);
        //executing the get request
        Document doc = conn.get();
        //Retrieving the contents (body) of the web page
        String result = doc.body().text();
        return result;

    }
}
