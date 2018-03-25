package com.mycompany.dobieracz001.main;

import com.mycompany.dobieracz001.algorytm.AlgorytmDAC;
import com.mycompany.dobieracz001.algorytm.AlgorytmEBM;
import com.mycompany.dobieracz001.excel.ExcelObsluga;
import com.mycompany.dobieracz001.frame.MainFrame;
import com.mycompany.dobieracz001.wyniki.DACwynik;
import com.mycompany.dobieracz001.sql.sterownik.ExcelPobranieSterownika;
import com.mycompany.dobieracz001.sql.sterownik.SqlSterownik;
import com.mycompany.dobieracz001.sql.sterownik.testZdalnie;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *
 * @since 2017-09-06, 12:20:43
 * @author Grzegorz Brodowski
 */
public class main {
    public static double EURO=4.27;
    public static double CAD=2.9;
    public static double UPUST=0.45;
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        
        
        ExcelObsluga ex = new ExcelObsluga();
        ExcelPobranieSterownika exp = new ExcelPobranieSterownika();
        SqlSterownik sqlSterownik = new SqlSterownik();
       
        
        
//        testZdalnie tz = new testZdalnie();
//        tz.tworzenie();
        
//
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new MainFrame().setVisible(true);
//                } catch (ClassNotFoundException ex1) {
//                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex1);
//                } catch (SQLException ex1) {
//                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex1);
//                }
//            }
//        });
//        sqlSterownik.tworzenie();
//        sqlSterownik.uzupelnianieBazy(exp.pobieranieRozdzielnic());
//        ex.tworzenie("dboSilowniki.xls");
//        AlgorytmDAC dac = new AlgorytmDAC();


    }

}
