
package mgm;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class CreateParagraph {

    public static void main(String file, ArrayList<String> body) throws Exception {
        File output = new File(Global.outputRep);
        
      
        XWPFDocument document = new XWPFDocument();

       
        FileOutputStream out = new FileOutputStream(new File(output,file));
        
        
        XWPFParagraph paragraph = document.createParagraph();
        for(int i=0;i<body.size();i++){
            XWPFRun run = paragraph.createRun();
            run.setText(body.get(i));
            run.addBreak();
        }
        document.write(out);
        out.close();
        System.out.println(file + " created successfully");
    }
}
