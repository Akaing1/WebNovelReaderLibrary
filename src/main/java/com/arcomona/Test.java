import com.arcomona.WebNovelReader.Data.DataParser;
import com.arcomona.WebNovelReader.Data.WebsiteDataRetrieval;
import com.arcomona.WebNovelReader.Generators.Novels.ChapterGenerator;
import com.arcomona.WebNovelReader.Generators.ResourceGenerator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Safelist;
import org.jsoup.select.Elements;


import javax.xml.crypto.Data;
import java.io.*;

import java.net.*;
import java.util.*;


public static void main(String [] args) throws IOException {

    String url = "https://www.webnovelpub.pro/novel/the-novels-extra-5/chapter-0-30041322";

    Document data = Jsoup.connect(url).get();

    String subString = data.toString().substring(data.toString().indexOf("class=\"booktitle\""), data.toString().indexOf("class=\"chapternav skiptranslate\""));


//    String novelName = dataParser.getNovelName(); // .replaceAll("[^a-zA-Z0-9]", "");;
//    String novelChapter = dataParser.getNovelChapter(); // .replaceAll("[^a-zA-Z0-9]", "");
//    String chapterContent = dataParser.getNovelChapterContent();


//    Document.OutputSettings outputSettings = new Document.OutputSettings();
//    outputSettings.prettyPrint(false);

//    System.out.println(Jsoup.clean(novelName, "", Safelist.none(), outputSettings));
//    System.out.println(Jsoup.clean(novelChapter, "", Safelist.none(), outputSettings));
//    System.out.println(Jsoup.clean(chapterContent, "", Safelist.none(), outputSettings));

    DataParser dataParser = new DataParser(url);
    ResourceGenerator resourceGenerator = new ResourceGenerator();

    dataParser.populateFilteredData();
    HashMap<String, String> map = dataParser.getFilteredData();
    System.out.println(map);

    resourceGenerator.generateAll(map.get("title"), map.get("chaptertitle"), map.get("body"));


}