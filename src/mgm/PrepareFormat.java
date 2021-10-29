
package mgm;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class PrepareFormat {

    public static void main(ArrayList<Integer> indexes) {
        try {
            File file = new File(Global.template);
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());

            XWPFDocument document = new XWPFDocument(fis);

            List<XWPFParagraph> paragraphs = document.getParagraphs();

            DateFormat df = new SimpleDateFormat("dd/MM/yy");
            Date dateobj = new Date();

            System.out.println("Violators : " + indexes.size());
            HashMap<String, ArrayList<String>> content = new HashMap<String, ArrayList<String>>();

            for (int i = 0; i < indexes.size(); i++) {
                String CCCC = df.format(dateobj);
                String AAAA = Global.records.get(indexes.get(i)).getAddress();
                String NNNN = Global.records.get(indexes.get(i)).getStudentName();
                String RRRR = Global.records.get(indexes.get(i)).getStudentRollNumber();
                String DDDD = Global.records.get(indexes.get(i)).getDepartment();
                String PPPP = Global.records.get(indexes.get(i)).getAttendancePercentage();

                String oFile = RRRR + ".docx";
                ArrayList<String> data = new ArrayList<String>();
                for (XWPFParagraph para : paragraphs) {
                    String temp = para.getText();                    
                    if (temp.contains("CCCC")) {
                        temp = temp.replaceAll("CCCC", CCCC);
                    }
                    if (temp.contains("AAAA")) {
                        temp = temp.replace("AAAA", AAAA);
                    }
                    if (temp.contains("NNNN")) {
                        temp = temp.replace("NNNN", NNNN);
                    }
                    if (temp.contains("RRRR")) {
                        temp = temp.replace("RRRR", RRRR);
                    }
                    if (temp.contains("DDDD")) {
                        temp = temp.replace("DDDD", DDDD);
                    }
                    if (temp.contains("PPPP")) {
                        temp = temp.replace("PPPP", PPPP);
                    }                    
                    data.add(temp);
                }
                content.put(oFile, data);
            }

            fis.close();

            File output = new File(Global.outputRep);
            try{
                Global.purgeDirectory(output);
            }catch(Exception e){            
            }            
            
            for (Map.Entry<String, ArrayList<String>> entry : content.entrySet()) {
                String key = entry.getKey();
                ArrayList<String> value = entry.getValue();
                CreateParagraph.main(key, value);
            }
            
            Global.notification = "Finished Generating "+content.size()+" report files in reports directory.";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
