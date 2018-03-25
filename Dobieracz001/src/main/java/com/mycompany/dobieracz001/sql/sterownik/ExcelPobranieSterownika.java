package com.mycompany.dobieracz001.sql.sterownik;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 *
 * @since 2017-09-07, 14:16:25
 * @author Grzegorz Brodowski
 */
public class ExcelPobranieSterownika {
    
public ArrayList<Sterownik> pobieranieRozdzielnic() {
        ArrayList<Sterownik> listaSzaf = new ArrayList<>();
        try {

            InputStream inp = new FileInputStream("db.xls");
            Workbook wb = WorkbookFactory.create(inp);
            DataFormatter formatter = new DataFormatter();
            Sheet sheet = wb.getSheetAt(0);
            for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
                Sterownik czujnik;
                Row row = sheet.getRow(i);
                czujnik = new Sterownik((int) row.getCell(0).getNumericCellValue(), //id
                                               row.getCell(1).getStringCellValue(), //symbol
                                               row.getCell(2).getStringCellValue(), //opis
                                               row.getCell(3).getStringCellValue(), //opis_EN
                                               row.getCell(4).getStringCellValue(), //producent
                                               row.getCell(5).getStringCellValue(), //dostawca
                                               row.getCell(6).getStringCellValue(), //system
                                               row.getCell(7).getStringCellValue(), //typElementu
                                               row.getCell(8).getNumericCellValue(), //cena
                                               row.getCell(9).getStringCellValue(), //waluta
                                               row.getCell(10).getStringCellValue(), //podsystem
                                               row.getCell(11).getStringCellValue(), //podtyp
                                               row.getCell(12).getNumericCellValue(), //l_UI
                                               row.getCell(13).getNumericCellValue(), //l_AI
                                               row.getCell(14).getNumericCellValue(), //l_DI
                                               row.getCell(15).getNumericCellValue(), //l_AO
                                               row.getCell(16).getNumericCellValue(), //l_DO
                                               row.getCell(17).getNumericCellValue(), //l_DIDO
                                               row.getCell(18).getNumericCellValue(), //HAO
                                               row.getCell(19).getNumericCellValue(), //RTD
                                               row.getCell(20).getNumericCellValue(), //Modbus
                                               row.getCell(21).getNumericCellValue()); //MBUS
                System.out.println("dodano "+ czujnik.getSymbol());
                                               
                listaSzaf.add(czujnik);

//                JOptionPane.showMessageDialog(null, czujnik.getNazwa() + " \n");
            }

            FileOutputStream fileOut = new FileOutputStream("bazaDanych.xls");
            wb.write(fileOut);
            fileOut.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "nie udalo sie pobrac");
        }
        return listaSzaf;
    }

}