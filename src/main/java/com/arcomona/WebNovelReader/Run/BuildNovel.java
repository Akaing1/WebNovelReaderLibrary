package com.arcomona.WebNovelReader.Run;

import com.arcomona.WebNovelReader.Data.DataParser;
import com.arcomona.WebNovelReader.Generators.ResourceGenerator;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class BuildNovel {

    private XWPFDocument novel = new XWPFDocument();

    private final ResourceGenerator resourceGenerator = new ResourceGenerator();
    private final String baseUrl;

    public BuildNovel(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void generateNovel() throws IOException {

        int chapterNumber = 1;
        String url = STR."\{baseUrl}/chapter-\{chapterNumber}";

        DataParser dataParser = new DataParser(url);
        dataParser.populateFilteredData();
        HashMap<String, String> map = dataParser.getFilteredData();

        HttpURLConnection connection = (HttpURLConnection) (new URL(url)).openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();

        while (responseCode == HttpURLConnection.HTTP_OK) {

            addChapter(url);

            chapterNumber++;
            url = STR."\{baseUrl}/chapter-\{chapterNumber}";

            connection = (HttpURLConnection) (new URL(url)).openConnection();
            responseCode = connection.getResponseCode();

        }

        resourceGenerator.generateNovel(map.get("title"), novel);
    }

    private void addChapter(String url) throws IOException {

        DataParser dataParser = new DataParser(url);

        dataParser.populateFilteredData();
        HashMap<String, String> map = dataParser.getFilteredData();

        XWPFParagraph paragraph = novel.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText(map.get("body"));

        paragraph.setPageBreak(true);

        System.out.println((STR."Successfully added chapter: \{map.get("chaptertitle")}").replaceAll("_", " "));
    }
}
