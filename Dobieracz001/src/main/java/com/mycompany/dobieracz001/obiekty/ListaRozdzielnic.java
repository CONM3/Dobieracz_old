//package com.mycompany.dobieracz001.obiekty;
//
//import com.mycompany.dobieracz001.algorytm.AlgorytmEBM;
//import com.mycompany.dobieracz001.excel.PobieranieSygnałow;
//import com.mycompany.dobieracz001.sql.sterownik.SqlSterownik;
//import com.mycompany.dobieracz001.sql.sterownik.Sterownik;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.HashMap;
//
///**
// *
// *
// * @since 2017-09-11, 23:49:25
// * @author Grzegorz Brodowski
// */
//public class ListaRozdzielnic {
//    private ArrayList<Wejscie> wejscie;
//    private HashMap<String,Wynik> wynik = new HashMap<String,Wynik>();
//    ArrayList<HashMap<String,Wynik>> listaRozdzielnic;
//
//    private AlgorytmEBM eBM;
//    private HashMap<String, Sterownik> dbSterowniki;
//    private HashMap<String, Sterownik> wykorzystaneSterowniki;
//    private SqlSterownik sql;
//    private PobieranieSygnałow dlWejscie;
//
//    public void pobranieDanych() throws ClassNotFoundException, SQLException {
//        dbSterowniki = sql.pobieranie();//pobranie do zmiennej wszystkich sterowników z bazy danych
//        wejscie = dlWejscie.pobieranieRozdzielnic();//pobranie wszystkich wejść z pliku
//    }
//
//    public ArrayList<HashMap<String,Wynik>> wyliczenieEBM() throws ClassNotFoundException, SQLException {
//        listaRozdzielnic = new ArrayList<>();
//        for (Wejscie w : wejscie) {
//            eBM = new AlgorytmEBM(w.AI, w.DI, w.AO, w.DO, dbSterowniki);
//            wynik = eBM.CountEnteliIOs();
//            wynik = new HashMap<String,Wynik>(wynik);
//            listaRozdzielnic.add(wynik);
//        }
//
//        return listaRozdzielnic;
//    }
//    
//    public ArrayList<String> wykorzystane(){
//        ArrayList<String> nazwySterownikow=new ArrayList<>();
//        for(HashMap<String,Wynik> w:listaRozdzielnic){
//            for(Wynik ww:wynik){
//                wykorzystaneSterowniki.put(ww.getNazwa(), ww.getSterownik());
//            }
//        }
//        for(String s:wykorzystaneSterowniki.keySet()){
//            nazwySterownikow.add(s);
//        }
//        
//        return nazwySterownikow;
//    }
//
//}
