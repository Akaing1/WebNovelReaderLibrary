package com.arcomona.WebNovelReader.Generators.Novels;

import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.*;

import static org.apache.commons.lang3.StringUtils.trim;

public class NovelGeneratorV2 {

    private final XWPFDocument document = new XWPFDocument();

    public boolean generateNovel(String novel, File[] files) throws IOException {

        String PATH = "src/main/resources/Novels/";
        FileOutputStream out = new FileOutputStream(STR."\{PATH}/\{novel}/\{novel}.docx");

        for(File file : files){
            addChapters(file);
            System.out.println(STR."Successfully added \{file}".substring(STR."Successfully added \{file}".indexOf("Chapters")));
        }

        document.write(out);
        System.out.println(STR."\{novel}.docx written successfully");
        out.close();

        return false;
    }

    private void addChapters(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();

            XWPFParagraph paragraph;
            XWPFRun run;

            paragraph = document.createParagraph();
            run = paragraph.createRun();
            run.setText(file.getName().substring(0 ,file.getName().indexOf(".txt")));

            while (line != null) {
                paragraph = document.createParagraph();
                run = paragraph.createRun();
                run.setText(trim(line));
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
