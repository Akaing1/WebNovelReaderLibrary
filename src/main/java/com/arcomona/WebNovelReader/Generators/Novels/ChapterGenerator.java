package com.arcomona.WebNovelReader.Generators.Novels;

import java.io.*;

public class ChapterGenerator {

    private final String chaptersFolder = "src/main/resources/generated/";

    public boolean generateChapter(String novel, String chapterHeader, String chapterContent) {

        File novelDir = new File(STR."\{chaptersFolder}/\{novel}/");
        novelDir.mkdir();

        File chapter = new File(STR."\{chaptersFolder}/\{novel}/\{chapterHeader}.txt");

        try {
            if (chapter.createNewFile()) {
                FileWriter writeContent = new FileWriter(STR."\{chaptersFolder}/\{novel}/\{chapterHeader}.txt");
                writeContent.write(chapterContent);
                writeContent.close();
                return true;
            }

            System.out.println("File already exists.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return false;
    }
}
