package com.arcomona.WebNovelReader.Generators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ChapterGeneratorTest {

    private String novelName, chapterHeader, chapterContent;


    @BeforeEach
    void setUp() {
        novelName = "exampleName";
        chapterHeader = "exampleHeader";
        chapterContent = "exampleContent";
    }

    @Test
    void testGenerateChapter(){

        ChapterGenerator chapterGenerator = new ChapterGenerator();
        assertTrue(chapterGenerator.generateChapter(novelName, chapterHeader, chapterContent));
    }

}