
import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;


public static void main(String[] args) throws Exception {
    //Blank Document
    XWPFDocument document = new XWPFDocument();

    //Write the Document in file system
    FileOutputStream out = new FileOutputStream("createparagraph.docx");

    //create Paragraph
    XWPFParagraph paragraph = document.createParagraph();
    XWPFRun run = paragraph.createRun();
    run.setText("At tutorialspoint.com, we strive hard to " +
            "provide quality tutorials for self-learning " +
            "purpose in the domains of Academics, Information " +
            "Technology, Management and Computer Programming Languages.");
    run.addBreak(BreakType.PAGE);

    run.setText("At tutorialspoint.com, we strive hard to " +
            "provide quality tutorials for self-learning " +
            "purpose in the domains of Academics, Information " +
            "Technology, Management and Computer Programming Languages.");

    document.write(out);
    out.close();
    System.out.println("createparagraph.docx written successfully");
}
