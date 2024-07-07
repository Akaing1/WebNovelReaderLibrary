import com.arcomona.WebNovelReader.Generators.Novels.ChapterGenerator;
import com.arcomona.WebNovelReader.Generators.ResourceGenerator;

import java.io.File;

public static void main(String [] args) {

//    ChapterGenerator chapterGenerator = new ChapterGenerator();
//    chapterGenerator.generateChapter("novel", "header", "content");

    ResourceGenerator resourceGenerator = new ResourceGenerator();
    resourceGenerator.generateAll("novel", "header", "content");

}