package com.mycompany.dobieracz001.excel;

import com.mycompany.dobieracz001.obiekty.Wejscie;
import com.mycompany.dobieracz001.sql.sterownik.ElementPomiarowy;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * /**
 *
 *
 * @since 2017-08-31, 11:27:07
 * @author Grzegorz Brodowski
 */
public class ExcelObsluga {

    public ArrayList<ElementPomiarowy> pobieranieRozdzielnic() {
        ArrayList<ElementPomiarowy> listaSzaf = new ArrayList<>();
        try {

            InputStream inp = new FileInputStream("bazaDanych.xls");
            Workbook wb = WorkbookFactory.create(inp);
            DataFormatter formatter = new DataFormatter();
            Sheet sheet = wb.getSheetAt(0);
            for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
                ElementPomiarowy czujnik;
                Row row = sheet.getRow(i);
                czujnik = new ElementPomiarowy((int) row.getCell(0).getNumericCellValue(), //id
                                               row.getCell(1).getStringCellValue(), //nazwa
                                               row.getCell(2).getStringCellValue(), //opis
                                               row.getCell(3).getStringCellValue(), //opis_EN
                                               row.getCell(4).getStringCellValue(), //producent
                                               row.getCell(5).getStringCellValue(), //dostawca
                                               row.getCell(6).getStringCellValue(), //system
                                               row.getCell(7).getStringCellValue(), //typElementu
                                               row.getCell(8).getNumericCellValue(), //cena
                                               row.getCell(9).getStringCellValue(), //waluta
                                               row.getCell(10).getNumericCellValue(), //dlugosc
                                               row.getCell(11).getStringCellValue(), //Sygnał
                                               row.getCell(12).getNumericCellValue(), //l_AI
                                               row.getCell(13).getNumericCellValue(), //l_DI
                                               row.getCell(14).getNumericCellValue(), //l_AO
                                               row.getCell(15).getNumericCellValue(), //l_DO
                                               row.getCell(16).getStringCellValue(), //sposobPomiaru
                                               row.getCell(17).getStringCellValue(), //zakres
                                               row.getCell(18).getStringCellValue(), //pasywny
                                               row.getCell(19).getStringCellValue()); //czynnik
                listaSzaf.add(czujnik);
            }

            FileOutputStream fileOut = new FileOutputStream("bazaDanych.xls");
            wb.write(fileOut);
            fileOut.close();

        } catch (Exception e) {
        }
        return listaSzaf;
    }

    public void tworzenie(String nazwa) {
        try {
            //tworzenie nowego workbooka
            Workbook wb = new HSSFWorkbook();
            Sheet sheet = wb.createSheet("new sheet");

            //tworzenie strumienia wyjścia
            FileOutputStream fileOut = new FileOutputStream(nazwa);
            wb.write(fileOut);
            fileOut.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "zepsute tworzenie");
        }
    }

}
