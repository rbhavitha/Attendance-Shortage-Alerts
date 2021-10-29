package mgm;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class ExcelReader {

    public static String SAMPLE_XLSX_FILE_PATH = "Book1.xlsx";

    public static void init(String[] args) throws IOException, InvalidFormatException {

     
        Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));

        
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

        
     
        Sheet sheet = workbook.getSheetAt(0);

       
        DataFormatter dataFormatter = new DataFormatter();

        Global.records.clear();
        System.out.println("\n\nIterating over Rows and Columns using for-each loop\n");
        int r = 0;
        for (Row row : sheet) {
            if (r != 0) {
                Data record = new Data();
                int c = 0;
                for (Cell cell : row) {
                    String cellValue = dataFormatter.formatCellValue(cell);
                    System.out.print(cellValue + "\t");
                    if (c == 0) {
                        record.setInd(cellValue);
                    }
                    if (c == 1) {
                        record.setStudentRollNumber(cellValue);
                    }
                    if (c == 2) {
                        record.setStudentName(cellValue);
                    }
                    if (c == 3) {
                        record.setDepartment(cellValue);
                    }
                    if (c == 4) {
                        record.setAddress(cellValue);
                    }
                    if (c == 5) {
                        record.setPhone(cellValue);
                    }
                    if (c == 6) {
                        record.setAttendancePercentage(cellValue);
                    }
                    if(c == 7){
                        record.setYear(cellValue);
                    }
                    c++;
                }
                Global.records.add(record);
            }
            System.out.println();
            r++;
        }
        System.out.println("Total Records : " + Global.records.size());
       
        workbook.close();

        //checking attendance violators
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        for (int i = 0; i < Global.records.size(); i++) {
            String attendance = Global.records.get(i).getAttendancePercentage();
            attendance = attendance.replace("%", "");
            double per = Double.parseDouble(attendance);
            if (per < Global.cutOffPercent) {
                indexes.add(i);
            }
        }
        
        PrepareFormat.main(indexes);
    }

    private static void printCellValue(Cell cell) {
        switch (cell.getCellTypeEnum()) {
            case BOOLEAN:
                System.out.print(cell.getBooleanCellValue());
                break;
            case STRING:
                System.out.print(cell.getRichStringCellValue().getString());
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    System.out.print(cell.getDateCellValue());
                } else {
                    System.out.print(cell.getNumericCellValue());
                }
                break;
            case FORMULA:
                System.out.print(cell.getCellFormula());
                break;
            case BLANK:
                System.out.print("");
                break;
            default:
                System.out.print("");
        }

        System.out.print("\t");
    }
}
