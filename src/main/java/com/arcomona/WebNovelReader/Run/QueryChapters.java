package com.arcomona.WebNovelReader.Run;

import com.arcomona.WebNovelReader.Data.DataParser;
import com.arcomona.WebNovelReader.Generators.ResourceGenerator;
import com.arcomona.WebNovelReader.Input.UserInput;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class QueryChapters {

    private final ResourceGenerator resourceGenerator = new ResourceGenerator();
    private final UserInput userInput = new UserInput();
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

        resourceGenerator.generateAll(map.get("title"), map.get("chaptertitle"), map.get("body"));
    }
}
