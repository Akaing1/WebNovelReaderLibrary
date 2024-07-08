package com.arcomona.WebNovelReader.Generators;

import com.arcomona.WebNovelReader.Generators.Novels.ChapterGenerator;

import java.io.*;

public class ResourceGenerator {

    private final String PATH = "src/main/resources/generated/";

    public boolean generateAll(String novel, String chapterHeader, String chapterContent) {

        File f = new File("src/main/resources/");
        f.mkdir();

        f = new File(PATH);
        f.mkdir();

        ChapterGenerator chaptGen = new ChapterGenerator();
        return chaptGen.generateChapter(novel, chapterHeader, chapterContent);
    }
}
