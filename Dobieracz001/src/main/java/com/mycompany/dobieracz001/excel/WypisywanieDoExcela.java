//package com.mycompany.dobieracz001.excel;
//
//import com.mycompany.dobieracz001.obiekty.Wejscie;
//
//import com.mycompany.dobieracz001.sql.sterownik.Sterownik;
//import java.io.FileOutputStream;
//import java.util.ArrayList;
//import javax.swing.JOptionPane;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//
///**
// *
// *
// * @since 2017-09-11, 23:12:15
// * @author Grzegorz Brodowski
// */
//public class WypisywanieDoExcela {
//    public void wypisywanie(ArrayList<Wejscie> rozdz, ArrayList<String> ster, ArrayList<ArrayList<Wynik>> lista) {
//        try {
//            ArrayList<Wynik> Rozdzielnica;
//            Wynik Sterownik;
//
//            //tworzenie nowego workbooka
//            Workbook wb = new HSSFWorkbook();
//            //tworzenie nowego arkusza o nazwie 
//            Sheet sheet = wb.createSheet("alfa");
//
//            //Stworzenie arkusza o odpowiednich wymiarach
//            for (int i = 0; i < ster.size() + 1; i++) {
//                sheet.createRow(i);
//                for (int j = 0; j < rozdz.size() + 1; j++)
//                    sheet.getRow(i).createCell(j);
//            }
//
//            //wypisanie nazw rozdzielnic
//            for (int i = 0; i < rozdz.size(); i++)
//                //wypisywanie w wierszu 1 i po i-tych rzędach(A,B,C...)
//                sheet.getRow(0).getCell(i + 1).setCellValue(rozdz.get(i).getRozdzielnica());
//            //wypisanie nazw sterownikow
//            for (int i = 0; i < ster.size(); i++)
//                //wypisywanie i i-tych wierszach(1,2,3,..) i w rzędzie 
//                sheet.getRow(i + 1).getCell(0).setCellValue(ster.get(i));
//
//            //wypisywanie liczby urzadzen
//            for (int j = 0; j < lista.size(); j++) {//lista sterowników dla
//                Rozdzielnica=lista.get(j);
//                if (Rozdzielnica == null)
//                    continue;
//                for (int k = 0; k < lista.get(j).size(); k++) {
//                    Sterownik=Rozdzielnica.get(k);
//                    if (Sterownik == null)
//                        continue;
//
//                    for (int i = 0; i < sheet.getLastRowNum(); i++) {
//                        Row row = sheet.getRow(i + 1);
//                        Cell cell = row.getCell(j + 1);
//                        String d1 = sheet.getRow(i + 1).getCell(0).getStringCellValue();
//                        if (lista.get(j) == null)
//                            continue;
//                        String d2 = lista.get(j).get(k).getNazwa();
//                        if (Sterownik.getNazwa().equals(d1)) {
//                            double d3 = Sterownik.getLiczba();
//                            sheet.getRow(i + 1).getCell(j + 1).setCellValue(lista.get(j).get(k).getLiczba());
//                        }
//                    }
//
//                }
//            }
//
//            //tworzenie strumienia wyjścia
//            FileOutputStream fileOut = new FileOutputStream("wyjscie.xls");
//            wb.write(fileOut);
//            fileOut.close();
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "zepsute tworzenie");
//            new RuntimeException("cos poszlo nie tak", e);
//        }
//    }
//
//}
