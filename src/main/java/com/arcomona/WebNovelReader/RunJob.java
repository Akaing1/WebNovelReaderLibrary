package com.arcomona.WebNovelReader;

import com.arcomona.WebNovelReader.Run.QueryChapters;
import java.io.IOException;

public class RunJob {

    public static void main(String[] args) throws IOException {

        QueryChapters queryChapters = new QueryChapters();
        queryChapters.runChapterQuery();
    }
}
