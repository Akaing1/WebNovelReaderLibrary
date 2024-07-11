package com.arcomona.WebNovelReader.Data;

import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Safelist;

import java.io.IOException;
import java.util.HashMap;

public class DataParser {


    private final String data;
    private final HashMap<String, String> filteredData;

    public String getData() { return data; }
    public HashMap<String, String> getFilteredData() { return filteredData; }

    public DataParser(String url) throws IOException {

        WebsiteDataRetrieval webData = new WebsiteDataRetrieval();
        data = webData.dataRetrieval(url);

        filteredData = new HashMap<>();
    }

    public void populateFilteredData() {

        Document.OutputSettings outputSettings = new Document.OutputSettings();
        outputSettings.prettyPrint(false);

        String title = getNovelName();
        String chapterTitle = getNovelChapter();
        String chapterContent = getNovelChapterContent();

        filteredData.put(title.substring(0, title.indexOf("=")).replaceAll("[^a-zA-Z0-9]", ""),
                title.substring(title.indexOf("=")+1).replaceAll("[^a-zA-Z0-9]", ""));

        filteredData.put(chapterTitle.substring(0, chapterTitle.indexOf(">")).replaceAll("[^a-zA-Z0-9]", ""),
                chapterTitle.substring(chapterTitle.indexOf(">")+1).replaceAll("[^a-zA-Z0-9]", "_"));

        filteredData.put("body", Jsoup.clean(chapterContent, "", Safelist.none(), outputSettings));


    }


    @NotNull
    private String getContentSubString() {

        return data.substring(data.indexOf("class=\"booktitle\""),
                data.indexOf("\"chapternav skiptranslate\""));
    }

    @NotNull
    private String getNovelName() {

        String content = getContentSubString();
        String title = content.substring(content.indexOf("title=\""), content.indexOf(" rel=\"up\""));

        return title;
    }

    @NotNull
    private String getNovelChapter() {

        String content = getContentSubString();
        String chapterTitle = content.substring(content.indexOf("\"chapter-title\">"), content.indexOf("</span></h1>"));

        return chapterTitle;
    }

    @NotNull
    private String getNovelChapterContent() {

        String content = getContentSubString();
        String chapterContent = content.substring(content.indexOf("<p>"), content.indexOf("</div>\n" +
                "     <div class"));

        return chapterContent;
    }
}
