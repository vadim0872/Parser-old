package parser;

import data.DAO;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Вадим on 08.04.2016.
 */
public class Parser {

    public static ArrayList<DAO> getdata(FileInputStream fis)throws IOException{
        Workbook wb = new XSSFWorkbook(fis);
        ArrayList<DAO> list = new ArrayList();

        String Name;
        String Mail;
        String VkId;
        String Number;

        for (Row row: wb.getSheetAt(0)) {

            Name = (getCellText(row.getCell(1)));
            Mail = (getCellText(row.getCell(3)));
            VkId = (getCellText(row.getCell(4)));
            Number = (getCellText(row.getCell(2)));

            list.add(new DAO(Name,Mail,Number,VkId));
        }
        list.remove(0);
        list.trimToSize();
        fis.close();
        //System.out.println(converter(8.9175364142E9)+ "/n");
        return list;
    }



    public static String getCellText(Cell cell){
        String Result = "";
       long Res;
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                Result = cell.getRichStringCellValue().getString();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    Result = cell.getDateCellValue().toString();
                } else {
                    Res =(converter(cell.getNumericCellValue()));// Double.toString(cell.getNumericCellValue());
                    //System.out.println(Res);
                    Result = String.valueOf(converter(cell.getNumericCellValue()));
                   // Guava CharMatcher
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                Result = Boolean.toString(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA:
                Result = (cell.getCellFormula());
                break;
            default:
                break;
        }
        return Result;
    }

    static long converter(double d){
        long lon;
        while(true){

            if (d%10 !=0) {
                lon = (long) d;
                break;
            } else
                d*=10;
            }return lon;
      }
}


