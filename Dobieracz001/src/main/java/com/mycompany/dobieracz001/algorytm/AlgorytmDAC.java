package com.mycompany.dobieracz001.algorytm;

import com.mycompany.dobieracz001.wyniki.DACwynik;
import com.mycompany.dobieracz001.sql.sterownik.SqlSterownik;
import com.mycompany.dobieracz001.sql.sterownik.Sterownik;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 *
 *
 * @since 2017-09-18, 11:53:15
 * @author Grzegorz Brodowski
 */
public class AlgorytmDAC {
    double liczbaUI = 0;
    double liczbaWolnychUI = 0;
    SqlSterownik sql = new SqlSterownik();
    String statSterowniki = "SELECT * FROM sterowniki WHERE podsystem='DAC' AND podtyp='Sterownik'  ";
    String statModuly = "SELECT * FROM sterowniki WHERE podsystem='DFM' AND podtyp='Modol' ";
    HashMap<String, Sterownik> sterowniki = new HashMap<String, Sterownik>();
    HashMap<String, Sterownik> moduly = new HashMap<String, Sterownik>();
    ArrayList<DACwynik> wynik = new ArrayList<DACwynik>();

    public AlgorytmDAC() throws ClassNotFoundException, SQLException {
        sterowniki = sql.pobieranie(statSterowniki);
        for (Sterownik s : sterowniki.values())
            s.wypisanie();

        moduly = sql.pobieranie(statModuly);
        for (Sterownik s : moduly.values())
            s.wypisanie();
        wyliczanieMozliowosci();
        wyliczanieMozliowosci2();

        //usuwanie duplikatow
        wynik = new ArrayList<>(new LinkedHashSet<DACwynik>(wynik));
        
        

        
       

        //Algorytm sortowania
//        Collections.sort(wynik, new Comparator<DACwynik>() {
//                     public int compare(DACwynik o1, DACwynik o2) {
//                         if (o1.getCena() == o2.getCena())
//                             return 0;
//                         return o1.getCena() < o2.getCena() ? -1 : 1;
//                     }
//                 });

        //wpisywanie do bazy danych
        Connection conn = null;
        Statement stmt = null;

        //STEP 2: Register JDBC driver
        Class.forName("org.postgresql.Driver");

        //STEP 3: Open a connection
        System.out.println("Connecting to database...");
        Class.forName("org.postgresql.Driver");
        conn = DriverManager
                .getConnection("jdbc:postgresql://10.0.0.40/gb",
                               "gb", "gb");
        for (DACwynik d : wynik) {
            //STEP 4: Execute a query
//            System.out.println("Creating statement...");

            stmt = conn.createStatement();

//            System.out.println(d.dacSQL());
            stmt.executeUpdate(d.dacSQL());

        }
        stmt.close();
        conn.close();
        //koniec wpisywania do bazy danych

    }
    DACwynik pomocniczy;
    double wolneUI;

    public void wyliczanieMozliowosci2() {

        for (Sterownik s : sterowniki.values()) {
            pomocniczy = new DACwynik(s);
            wynik.add(pomocniczy); //wyliczone dacSterownik

            for (Sterownik m1 : moduly.values()) {
                wynik.add(new DACwynik(s, m1));// modul 1
                for (int k = 0; k < s.getL_UI(); k++) {
                    pomocniczy = new DACwynik(s, m1);

                    wynik.add(pomocniczy);// modul1+cyk
                    for (Sterownik m2 : moduly.values())
                        wynik.add(new DACwynik(s, m1, m2));
                }
            }
        }
        

    }

    public ArrayList<DACwynik> wyliczanieMozliowosci() {
        for (Sterownik s : sterowniki.values()) {
            pomocniczy = new DACwynik(s);
            wynik.add(pomocniczy); //wyliczone dacSterownik
            for (int i = 0; i < s.getL_UI(); i++) {
                pomocniczy = new DACwynik(s);
                pomocniczy.addKAC(i);
                wynik.add(pomocniczy); //dacSterownik + KAC
                wolneUI = s.getL_UI() - i + 1;
                for (int j = 0; j < wolneUI + 1; j++) {
                    pomocniczy = new DACwynik(s);
                    pomocniczy.addKAC(i);
                    pomocniczy.addCYK(j);
                    wynik.add(pomocniczy);//wyliczone sterowniki
                }
            }
        }

        for (Sterownik s : sterowniki.values()) {
            pomocniczy = new DACwynik(s);
            wynik.add(pomocniczy); //wyliczone dacSterownik
            for (int i = 0; i < s.getL_UI(); i++) {
                pomocniczy = new DACwynik(s);
                pomocniczy.addKAC(i);
                wynik.add(pomocniczy); //dacSterownik + KAC
                wolneUI = s.getL_UI() - i + 1;
                for (int j = 0; j < wolneUI; j++) {
                    pomocniczy = new DACwynik(s);
                    pomocniczy.addKAC(i);
                    pomocniczy.addCYK(j);
                    wynik.add(pomocniczy);//wyliczone sterowniki
                    moduly.values().stream().map((m1) -> {
                        wynik.add(new DACwynik(s, m1));// modul 1
                        return m1;
                    }).forEachOrdered((m1) -> {
                        for (int k = 0; k < s.getL_UI(); k++) {
                            pomocniczy = new DACwynik(s, m1);
                            pomocniczy.addKAC(k);
                            wynik.add(pomocniczy); //modul1 + kac
                            wolneUI = m1.getL_UI() - k + 1;
                            for (int l = 0; l < wolneUI; l++) {
                                pomocniczy = new DACwynik(s, m1);
                                pomocniczy.addKAC(k);
                                pomocniczy.addCYK(l);
                                wynik.add(pomocniczy);// modul1+cyk
                            }
                        }
                    });
                }
            }
        }

        for (Sterownik s : sterowniki.values()) {
            pomocniczy = new DACwynik(s);
            wynik.add(pomocniczy);
            for (Sterownik m1 : moduly.values()) {
                wynik.add(new DACwynik(s, m1));
                for (Sterownik m2 : moduly.values())
                    wynik.add(new DACwynik(s, m1, m2));
            }
        }

        for (Sterownik s : sterowniki.values()) {
            pomocniczy = new DACwynik(s);
            wynik.add(pomocniczy); //wyliczone dacSterownik
            for (int i = 0; i < s.getL_UI(); i++) {
                pomocniczy = new DACwynik(s);
                pomocniczy.addKAC(i);
                wynik.add(pomocniczy); //dacSterownik + KAC
                wolneUI = s.getL_UI() - i + 1;
                for (int j = 0; j < wolneUI; j++) {
                    pomocniczy = new DACwynik(s);
                    pomocniczy.addKAC(i);
                    pomocniczy.addCYK(j);
                    wynik.add(pomocniczy);//wyliczone sterowniki

                    for (Sterownik m1 : moduly.values()) {
                        wynik.add(new DACwynik(s, m1));// modul 1
                        for (int k = 0; k < s.getL_UI(); k++) {
                            pomocniczy = new DACwynik(s, m1);
                            pomocniczy.addKAC(k);
                            wynik.add(pomocniczy); //modul1 + kac
                            wolneUI = m1.getL_UI() - k + 1;
                            for (int l = 0; l < wolneUI; l++) {
                                pomocniczy = new DACwynik(s, m1);
                                pomocniczy.addKAC(k);
                                pomocniczy.addCYK(l);
                                wynik.add(pomocniczy);// modul1+cyk
                                for (Sterownik m2 : moduly.values()) {
                                    wynik.add(new DACwynik(s, m1, m2));
                                    for (int m = 0; m < s.getL_UI(); m++) {
                                        pomocniczy = new DACwynik(s, m1, m2);
                                        pomocniczy.addKAC(m);
                                        wynik.add(pomocniczy);
                                        wolneUI = m2.getL_UI() - m + 1;
                                        for (int n = 0; n < wolneUI; n++) {
                                            pomocniczy = new DACwynik(s, m1, m2);
                                            pomocniczy.addKAC(m);
                                            pomocniczy.addCYK(n);
                                            wynik.add(pomocniczy);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        

        return wynik;
    }

    public void wylicznieBezCYKKAC() {

    }

}
