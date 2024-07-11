package com.arcomona.WebNovelReader;

import com.arcomona.WebNovelReader.Input.UserInput;
import com.arcomona.WebNovelReader.Run.BuildNovel;
import com.arcomona.WebNovelReader.Run.QueryChapters;
import java.io.IOException;

public class RunJob {

    public static void main(String[] args) throws IOException {

        String url = "";

        UserInput userInput = new UserInput();
        url = userInput.getUserInput();

        while(url != null){

//            QueryChapters queryChapters = new QueryChapters(url);
//            queryChapters.runChapterQuery();

            BuildNovel buildNovel = new BuildNovel(url);
            buildNovel.generateNovel();

            url = userInput.getUserInput();
        }
    }
}
