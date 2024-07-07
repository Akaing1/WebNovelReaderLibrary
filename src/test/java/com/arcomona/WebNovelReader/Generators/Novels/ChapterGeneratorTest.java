package com.arcomona.WebNovelReader.Generators.Novels;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ChapterGeneratorTest {

    private String novelName, chapterHeader, chapterContent;

    private ChapterGenerator chapterGenerator;

    @BeforeEach
    void setUp() {
        novelName = "exampleName";
        chapterHeader = "exampleHeader";
        chapterContent = "exampleContent";

        chapterGenerator = new ChapterGenerator();
    }

    @Test
    void testGenerateChapter(){
        assertTrue(chapterGenerator.generateChapter(novelName, chapterHeader, chapterContent));
    }

}