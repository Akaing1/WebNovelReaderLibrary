package com.arcomona.WebNovelReader.Run;

import com.arcomona.WebNovelReader.Data.DataParser;
import com.arcomona.WebNovelReader.Generators.ResourceGenerator;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class QueryChapters {

    public void runChapterQuery() throws IOException {

        int chapterNumber = 0;
        String url = STR."https://www.webnovelpub.pro/novel/the-novels-extra-5/chapter-\{chapterNumber}";

        HttpURLConnection connection = (HttpURLConnection) (new URL(url)).openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();

        System.out.println(responseCode);
        while (responseCode == HttpURLConnection.HTTP_OK) {

            DataParser dataParser = new DataParser(url);
            ResourceGenerator resourceGenerator = new ResourceGenerator();

            dataParser.populateFilteredData();
            HashMap<String, String> map = dataParser.getFilteredData();

            resourceGenerator.generateAll(map.get("title"), map.get("chaptertitle"), map.get("body"));

            chapterNumber++;
            url = STR."https://www.webnovelpub.pro/novel/the-novels-extra-5/chapter-\{chapterNumber}";

            connection = (HttpURLConnection) (new URL(url)).openConnection();
            responseCode = connection.getResponseCode();
        }
    }
}
