package com.arcomona.WebNovelReader.Run;

import com.arcomona.WebNovelReader.Data.DataParser;
import com.arcomona.WebNovelReader.Generators.ResourceGenerator;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class QueryChapters {

    private final ResourceGenerator resourceGenerator = new ResourceGenerator();
    private final String baseUrl;

    public QueryChapters(String url){
        this.baseUrl = url;
    }

    public void runChapterQuery() throws IOException {

        int chapterNumber = 1;
        String url = STR."\{baseUrl}/chapter-\{chapterNumber}";

        HttpURLConnection connection = (HttpURLConnection) (new URL(url)).openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();

        while (responseCode == HttpURLConnection.HTTP_OK) {

            parseDataHelper(url);

            chapterNumber++;
            url = STR."\{baseUrl}/chapter-\{chapterNumber}";

            connection = (HttpURLConnection) (new URL(url)).openConnection();
            responseCode = connection.getResponseCode();
        }
    }

    public void parseDataHelper(String url) throws IOException {

        DataParser dataParser = new DataParser(url);

        dataParser.populateFilteredData();
        HashMap<String, String> map = dataParser.getFilteredData();

        resourceGenerator.generateChapters(map.get("title"), map.get("chaptertitle"), map.get("body"));

        System.out.println((STR."Successfully added chapter: \{map.get("chaptertitle")}").replaceAll("_", " "));
    }
}
