
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;


public static void main(String[] args) throws Exception {
//    //Blank Document
//    XWPFDocument document = new XWPFDocument();
//
//    //Write the Document in file system
//    FileOutputStream out = new FileOutputStream("test.docx");
//
//    //String s = Files.readString(Path.of("src/main/resources/Novels/AcademysSecondSeat/Chapter_1__Prologue.txt"));
//    BufferedReader reader;
//
//    try {
//        reader = new BufferedReader(new FileReader("src/main/resources/Novels/MaxLevelNewbie/Chapter_1.txt"));
//        String line = reader.readLine();
//
//        while (line != null) {
//            XWPFParagraph paragraph = document.createParagraph();
//            XWPFRun run = paragraph.createRun();
//            run.setText(line);
//            line = reader.readLine();
//
//            run.addBreak(BreakType.PAGE);
//        }
//
//        reader.close();
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//    //System.out.print(s);
//
//    document.write(out);
//    out.close();
//    System.out.println("test.docx written successfully");
//

    File novelTitle = new File("src/main/resources/Novels/AcademysSecondSeat/Chapters");
    File [] files = novelTitle.listFiles();
    Arrays.sort(files);
    for(File file : files)
        System.out.println(file);



}
