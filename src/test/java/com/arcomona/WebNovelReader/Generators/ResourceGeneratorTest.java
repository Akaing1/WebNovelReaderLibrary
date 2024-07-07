package com.arcomona.WebNovelReader.Generators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResourceGeneratorTest {

    private String novelName, chapterHeader, chapterContent;
    private ResourceGenerator resourceGenerator;

    @BeforeEach
    void setUp() {
        novelName = "exampleName";
        chapterHeader = "exampleHeader";
        chapterContent = "exampleContent";

        resourceGenerator = new ResourceGenerator();
    }

    @Test
    void testGenerateAll(){
        assertTrue(resourceGenerator.generateAll(novelName, chapterHeader, chapterContent));
    }

}