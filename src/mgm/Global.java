
package mgm;

import java.io.File;
import java.util.ArrayList;


public class Global {

    public static String projectTitle = "Attendance Reports Management";
    public static ArrayList<Data> records = new ArrayList<Data>();
    public static double cutOffPercent = 75;
    public static String sourceFileResources = ".";
    public static String notification;

    public static String template = "templates/LETTER.docx";
    public static String outputRep = "reports";

    public static void purgeDirectory(File dir) {
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                purgeDirectory(file);
            }
            if(file.isFile()){
                file.delete();
            }            
        }
    }
}
