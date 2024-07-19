package com.arcomona.WebNovelReader.Run;

import com.arcomona.WebNovelReader.Generators.ResourceGenerator;

import java.io.File;
import java.io.IOException;

// uses already downloaded data to generate novel

public class BuildNovelV2 {

    private final ResourceGenerator resourceGenerator = new ResourceGenerator();

    public void sendChapterData(String novel) throws IOException {

        File novelTitle = new File(STR."src/main/resources/Novels/\{novel}/Chapters");
        System.out.println(novelTitle);
        resourceGenerator.generateNovelV2(novel, novelTitle.listFiles());
    }
}
