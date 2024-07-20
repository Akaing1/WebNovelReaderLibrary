package com.arcomona.WebNovelReader;

import com.arcomona.WebNovelReader.Data.DataParser;
import com.arcomona.WebNovelReader.Input.UserInput;
import com.arcomona.WebNovelReader.Run.BuildNovel;
import com.arcomona.WebNovelReader.Run.BuildNovelV2;
import com.arcomona.WebNovelReader.Run.QueryChapters;
import java.io.IOException;

public class RunJob {

    public static void main() throws IOException {

        String url;

        UserInput userInput = new UserInput();
        url = userInput.getUserInput();

        while(url != null){

            DataParser dataParser = new DataParser(STR."\{url}/chapter-1");
            dataParser.populateFilteredData();

            QueryChapters queryChapters = new QueryChapters(url);
            queryChapters.runChapterQuery();

            BuildNovelV2 buildNovelV2 = new BuildNovelV2();
            buildNovelV2.sendChapterData(dataParser.getFilteredData().get("title"));

            url = userInput.getUserInput();
        }
    }
}
