package com.arcomona.WebNovelReader.Generators;

import com.arcomona.WebNovelReader.Generators.Novels.ChapterGenerator;
import com.arcomona.WebNovelReader.Generators.Novels.NovelGenerator;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;

public class ResourceGenerator {

    private final String PATH = "src/main/resources/Novels/";

    public boolean generateChapters(String novel, String chapterHeader, String chapterContent) {

        File f = new File("src/main/resources/");
        f.mkdir();

        f = new File(PATH);
        f.mkdir();

        ChapterGenerator chaptGen = new ChapterGenerator();

        return chaptGen.generateChapter(novel, chapterHeader, chapterContent);
    }

    public boolean generateNovel(String novel, XWPFDocument novelContent) throws FileNotFoundException {

        File f = new File("src/main/resources/");
        f.mkdir();

        f = new File(PATH);
        f.mkdir();

        NovelGenerator novelGen = new NovelGenerator();

        return novelGen.generateNovel(novel, novelContent);
    }
}
