package com.arcomona.WebNovelReader.Generators.Novels;

import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.*;

public class NovelGeneratorV2 {

    private XWPFDocument document = new XWPFDocument();
    private BufferedReader reader;
    private final String PATH = "src/main/resources/Novels/";


    public boolean generateNovel(String novel, File[] files) throws IOException {

        FileOutputStream out = new FileOutputStream(STR."\{PATH}/\{novel}/\{novel}.docx");

        for(File file : files){
            addChapters(file);
            System.out.println(STR."Successfully added \{file}".substring(STR."Successfully added \{file}".indexOf("Chapters")));
        }

        document.write(out);
        out.close();

        return false;
    }

    private void addChapters(File file) {
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();

            XWPFParagraph paragraph;
            XWPFRun run;

            while (line != null) {
                paragraph = document.createParagraph();
                run = paragraph.createRun();
                run.setText(line);
                line = reader.readLine();
            }
            paragraph = document.createParagraph();
            run = paragraph.createRun();

            run.addBreak(BreakType.PAGE);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
