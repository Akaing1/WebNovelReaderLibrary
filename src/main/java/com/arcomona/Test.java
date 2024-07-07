import com.arcomona.WebNovelReader.Generators.ChapterGenerator;

import java.io.File;

public static void main(String [] args) {

    ChapterGenerator chapterGenerator = new ChapterGenerator();
    chapterGenerator.generateChapter("novel", "header", "content");
}