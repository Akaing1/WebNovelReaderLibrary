package com.arcomona.WebNovelReader.Generators;

import com.arcomona.WebNovelReader.Generators.Novels.ChapterGenerator;
import com.arcomona.WebNovelReader.Generators.Novels.NovelGenerator;
import com.arcomona.WebNovelReader.Generators.Novels.NovelGeneratorV2;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;

public class ResourceGenerator {

    private final String PATH = "src/main/resources/Novels/";

    public boolean generateChapters(String novel, String chapterHeader, String chapterContent) {

        makeDirectory();

        ChapterGenerator chaptGen = new ChapterGenerator();

        return chaptGen.generateChapter(novel, chapterHeader, chapterContent);
    }

    public boolean generateNovel(String novel, XWPFDocument novelContent) throws FileNotFoundException {

        makeDirectory();

        NovelGenerator novelGen = new NovelGenerator();

        return novelGen.generateNovel(novel, novelContent);
    }

    public boolean generateNovelV2(String novel, File[] files) throws IOException {

        makeDirectory();

        NovelGeneratorV2 novelGen = new NovelGeneratorV2();

        return novelGen.generateNovel(novel, files);
    }

    private boolean makeDirectory() {
        File f = new File("src/main/resources/");
        f.mkdir();

        f = new File(PATH);
        return f.mkdir();
    }
}
