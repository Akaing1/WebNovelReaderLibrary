package com.arcomona.WebNovelReader.Data;

import org.jetbrains.annotations.NotNull;
import java.io.IOException;

public class DataParser {

    private WebsiteDataRetrieval webData;
    private String data;

    public DataParser(String url) throws IOException {

        webData = new WebsiteDataRetrieval();
        data = webData.dataRetrieval(url);
    }

    @NotNull
    private String getContentSubString() {

        return data.toString().substring(data.toString().indexOf("class=\"booktitle\""),
                data.indexOf("class=\"chapternav skiptranslate\""));
    }

    public String getNovelName() {

        String content = getContentSubString();
        String title = content.substring(content.indexOf("title=\""), content.indexOf(" rel=\"up\""));

        return title;
    }

    public String getNovelChapter() {

        String content = getContentSubString();
        String chapterTitle = content.substring(content.indexOf("\"chapter-title\">"), content.indexOf("</span></h1>"));
        return chapterTitle;
    }

    public String getNovelChapterContent() {
        return "";
    }
}
