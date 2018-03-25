package com.mycompany.dobieracz001.excel;

import com.mycompany.dobieracz001.obiekty.Wejscie;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 *
 * @since 2017-09-11, 23:13:26
 * @author Grzegorz Brodowski
 */
public class PobieranieSygnałow {
    
    public ArrayList<Wejscie> pobieranieRozdzielnic() {
        ArrayList<Wejscie> listaSzaf = new ArrayList<>();
        try {

            InputStream inp = new FileInputStream("wejscie.xls");
            Workbook wb = WorkbookFactory.create(inp);
            DataFormatter formatter = new DataFormatter();
            Sheet sheet = wb.getSheetAt(0);
            for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
                Wejscie szafa;
                Row row = sheet.getRow(i);
                szafa = new Wejscie(row.getCell(0).getStringCellValue(),
                                          row.getCell(1).getNumericCellValue(),
                                          row.getCell(2).getNumericCellValue(),
                                          row.getCell(3).getNumericCellValue(),
                                          row.getCell(4).getNumericCellValue());
                listaSzaf.add(szafa);
            }

            FileOutputStream fileOut = new FileOutputStream("wejscie.xls");
            wb.write(fileOut);
            fileOut.close();

        } catch (Exception e) {
            System.out.println("nie udało sie pobrać sygnałów");
        }
        return listaSzaf;
    }

}