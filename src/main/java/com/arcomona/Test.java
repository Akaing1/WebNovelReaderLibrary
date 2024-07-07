import com.arcomona.WebNovelReader.Data.DataParser;
import com.arcomona.WebNovelReader.Data.WebsiteDataRetrieval;
import com.arcomona.WebNovelReader.Generators.Novels.ChapterGenerator;
import com.arcomona.WebNovelReader.Generators.ResourceGenerator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import javax.xml.crypto.Data;
import java.io.*;

import java.net.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public static void main(String [] args) throws IOException {

//    ChapterGenerator chapterGenerator = new ChapterGenerator();
//    chapterGenerator.generateChapter("novel", "header", "content");

    String url = "https://www.webnovelpub.pro/novel/how-to-survive-at-the-academy-1428/chapter-1-30041322";

    WebsiteDataRetrieval webdata = new WebsiteDataRetrieval();
    //System.out.println(webdata.dataRetrieval(url));



    Document data = Jsoup.connect(url).get();

    System.out.println(data.toString().indexOf("class=\"booktitle\""));
    System.out.println(data.toString().indexOf("class=\"chapternav skiptranslate\""));

    String subString = data.toString().substring(data.toString().indexOf("class=\"booktitle\""), data.toString().indexOf("class=\"chapternav skiptranslate\""));

    DataParser dataParser = new DataParser(url);

    System.out.println(dataParser.getNovelName());
    System.out.println(dataParser.getNovelChapter());









//    File file = new File("src/main/resources/generated/data.txt");
//    file.createNewFile();
//    FileWriter writeContent = new FileWriter("src/main/resources/generated/data.txt");
//    writeContent.write(data.toString());
//    writeContent.close();

//    Elements as = data.select("p");
//    String currentTitle = null;
//    Map<String, List<String>> mas = new LinkedHashMap<>();
//    for (Element a : as){
//        if ("h3".equals(a.previousElementSibling().tagName())){
//            currentTitle = a.previousElementSibling().text();
//            mas.put(currentTitle, new ArrayList<String>());
//        }
//        mas.get(currentTitle).add(a.text());
//    }
//
//    System.out.println(""+mas);

}