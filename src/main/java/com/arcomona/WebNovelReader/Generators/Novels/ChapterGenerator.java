package com.arcomona.WebNovelReader.Generators.Novels;

import java.io.*;

public class ChapterGenerator {

    private final String PATH = "src/main/resources/Novels/";

    public boolean generateChapter(String novel, String chapterHeader, String chapterContent) {

        File novelDir = new File(STR."\{PATH}/\{novel}");
        novelDir.mkdir();

        novelDir = new File(STR."\{PATH}/\{novel}/Chapters/");
        novelDir.mkdir();

        File chapter = new File(STR."\{PATH}/\{novel}/Chapters/\{chapterHeader}.txt");

        try {
            if (chapter.createNewFile()) {
                FileWriter writeContent = new FileWriter(STR."\{PATH}/\{novel}/Chapters/\{chapterHeader}.txt");
                writeContent.write(chapterContent);
                writeContent.close();
                return true;
            }

            System.out.println("Chapter already exists.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return false;
    }
}
