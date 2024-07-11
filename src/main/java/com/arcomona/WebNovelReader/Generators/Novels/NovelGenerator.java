package com.arcomona.WebNovelReader.Generators.Novels;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.io.*;


public class NovelGenerator {

    private final String PATH = "src/main/resources/Novels/";

    public boolean generateNovel(String novelTitle, XWPFDocument novelContent) throws FileNotFoundException {

        File novelDir = new File(STR."\{PATH}/\{novelTitle}/");
        novelDir.mkdir();

        File novel = new File(STR."\{novelDir}/\{novelTitle}");

        try {
            if (novel.createNewFile()) {
                FileOutputStream out = new FileOutputStream(novel, false);

                novelContent.write(out);
                out.close();
                System.out.println(STR."\{novelTitle}.docx written successfully");
                return true;
            }

            System.out.println("Novel already exists.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return false;
    }
}
