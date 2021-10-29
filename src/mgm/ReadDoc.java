
package mgm;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;


public class ReadDoc {

    public static void main(String... a) throws Exception {
        File file = new File("LETTER.docx");
        FileInputStream fis = new FileInputStream(file.getAbsolutePath());

        XWPFDocument document = new XWPFDocument(fis);
        List<XWPFParagraph> paragraphs = document.getParagraphs();

        for (XWPFParagraph paragraph : paragraphs) {
            System.out.println("Text in this paragraph: " + paragraph.getText());
        }
        System.out.println("Total no of paragraph in Docx : " + paragraphs.size());
    }

}
