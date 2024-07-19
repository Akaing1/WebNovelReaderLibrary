
import java.io.*;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;

import org.apache.logging.log4j.util.PropertySource;
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


    Arrays.sort(files, Comparator.comparing(File::getName, new FilenameComparator()));

    for(File file : files)
        System.out.println(file);


}

public static class FilenameComparator implements Comparator<String> {
    private static final Pattern NUMBERS =
            Pattern.compile("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
    @Override public final int compare(String o1, String o2) {
        // Optional "NULLS LAST" semantics:
        if (o1 == null || o2 == null)
            return o1 == null ? o2 == null ? 0 : -1 : 1;

        // Splitting both input strings by the above patterns
        String[] split1 = NUMBERS.split(o1);
        String[] split2 = NUMBERS.split(o2);
        for (int i = 0; i < Math.min(split1.length, split2.length); i++) {
            char c1 = split1[i].charAt(0);
            char c2 = split2[i].charAt(0);
            int cmp = 0;

            // If both segments start with a digit, sort them numerically using
            // BigInteger to stay safe
            if (c1 >= '0' && c1 <= '9' && c2 >= 0 && c2 <= '9')
                cmp = new BigInteger(split1[i]).compareTo(new BigInteger(split2[i]));

            // If we haven't sorted numerically before, or if numeric sorting yielded
            // equality (e.g 007 and 7) then sort lexicographically
            if (cmp == 0)
                cmp = split1[i].compareTo(split2[i]);

            // Abort once some prefix has unequal ordering
            if (cmp != 0)
                return cmp;
        }

        // If we reach this, then both strings have equally ordered prefixes, but
        // maybe one string is longer than the other (i.e. has more segments)
        return split1.length - split2.length;
    }
}

