package com.mycompany.dobieracz001.sql.sterownik;

import com.mycompany.dobieracz001.wyniki.DACwynik;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 *
 * @since 2017-09-07, 12:04:23
 * @author Grzegorz Brodowski
 */
public class SqlSterownik {

    public void tworzenie() throws ClassNotFoundException, SQLException {
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

        //STEP 4: Execute a query
        System.out.println("Creating statement...");
        String sql, sql_1;
        stmt = conn.createStatement();
        sql = "CREATE TABLE sterowniki(id integer,symbol character varying,\n" //0,1
              + "  opis character varying, \n" //2
              + "  opis_EN character varying, \n" //3
              + "  producent character varying, \n" //4
              + "  dostawca character varying, \n" //5 
              + "  system character varying, \n" //6
              + "  typ_Elementu character varying, \n" //7
              + "  cena double precision, \n" //8
              + "  waluta character varying, \n" //9
              + "  podsystem character varying, \n" //10
              + "  podTyp character varying, \n" //11
              + "  l_UI double precision, \n" //12
              + "  l_AI double precision, \n" //13
              + "  l_DI double precision, \n" //14
              + "  l_AO double precision, \n" //15
              + "  l_DO double precision, \n" //16
              + "  l_DIDO double precision, \n" //17
              + "  HAO double precision, \n" //18
              + "  RTD double precision, \n" //19
              + "  MODbus double precision, \n" //20
              + "  Mbus double precision) \n";//21
        stmt.executeUpdate(sql);
        System.out.println("baza poprawnie utworzona");

        stmt.close();
        conn.close();

    }

    public void uzupelnianieBazy(ArrayList<Sterownik> listaCzujnikow) throws ClassNotFoundException, SQLException {
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

        //STEP 4: Execute a query
        System.out.println("Creating statement...");
        String sql;

        stmt = conn.createStatement();
        boolean a = true;

        if (a)
            for (Sterownik czujnik : listaCzujnikow) {
                sql = "Insert into sterowniki(id,symbol,opis,opis_EN,producent,dostawca,system, \n"
                      + "typ_elementu,cena,waluta,podsystem,podTyp,l_UI,l_AI,\n"
                      + "l_DI,l_AO,l_DO,l_DIDO,HAO,RTD,MODbus,Mbus) \n"
                      + " values \n"
                      + "(" + czujnik.getId() + ",\n" //0
                      + "'" + czujnik.getSymbol() + "'" + ",\n" //1
                      + "'" + czujnik.getOpis() + "'" + ",\n" //2
                      + "'" + czujnik.getOpis_EN() + "'" + ",\n" //3
                      + "'" + czujnik.getProducent() + "'" + ",\n" //4
                      + "'" + czujnik.getDostawca() + "'" + ",\n" //5
                      + "'" + czujnik.getSystem() + "'" + ",\n" //6
                      + "'" + czujnik.getTyp_Elementu() + "'" + ",\n" //7
                      + czujnik.getCena() + ",\n" //8
                      + "'" + czujnik.getWaluta() + "'" + ",\n" //9
                      + "'" + czujnik.getPodsystem() + "'" + ",\n" //10
                      + "'" + czujnik.getPodTyp() + "'" + ",\n" //11
                      + "'" + czujnik.getL_UI() + "'" + ",\n" //12
                      + "'" + czujnik.getL_AI() + "'" + ",\n" //13
                      + "'" + czujnik.getL_DI() + "'" + ",\n" //14
                      + "'" + czujnik.getL_AO() + "'" + ",\n" //15
                      + "'" + czujnik.getL_DO() + "'" + ",\n" //16
                      + "'" + czujnik.getL_DIDO() + "'" + ",\n" //17
                      + "'" + czujnik.getHAO() + "'" + ",\n" //18
                      + "'" + czujnik.getRTD() + "'" + ",\n" //19
                      + "'" + czujnik.getMODbus() + "'" + ",\n" //20
                      + "'" + czujnik.getMbus() + "'" + ")"; //21

                System.out.println(sql);

                stmt.executeUpdate(sql);
            }

        stmt.close();
        conn.close();
    }

    public HashMap<String, Sterownik> pobieranie() throws ClassNotFoundException, SQLException {
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

        //STEP 4: Execute a query
        System.out.println("Creating statement...");

        stmt = conn.createStatement();
        String sql;
        sql = "SELECT * FROM sterowniki";
        ResultSet rs = stmt.executeQuery(sql);
        HashMap<String, Sterownik> baza = new HashMap<>();
        Sterownik czujnik = null;
        while (rs.next()) {
            czujnik = new Sterownik(rs.getInt("id"), //id
                                    rs.getString("symbol"), //nazwa
                                    rs.getString("opis"), //opis
                                    rs.getString("opis_EN"), //opis_EN
                                    rs.getString("producent"), //producent
                                    rs.getString("dostawca"), //dostawca
                                    rs.getString("system"), //system
                                    rs.getString("typ_elementu"), //typElementu
                                    rs.getDouble("cena"), //cena
                                    rs.getString("waluta"), //waluta
                                    rs.getString("podsystem"), //waluta
                                    rs.getString("podTyp"), //waluta
                                    rs.getDouble("l_UI"), //cena
                                    rs.getDouble("l_AI"), //cena
                                    rs.getDouble("l_DI"), //cena
                                    rs.getDouble("l_AO"), //cena
                                    rs.getDouble("l_DO"), //cena
                                    rs.getDouble("l_DIDO"), //cena
                                    rs.getDouble("HAO"), //cena
                                    rs.getDouble("RTD"), //cena
                                    rs.getDouble("MODbus"), //cena
                                    rs.getDouble("Mbus")); //czynnik
            baza.put(rs.getString("symbol"), czujnik);

        }
        System.out.println("udalo sie dodac element");

        rs.close();
        stmt.close();
        conn.close();

        return baza;
    }

    public HashMap<String, Sterownik> pobieranie(String statement) throws ClassNotFoundException, SQLException {
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

        //STEP 4: Execute a query
        System.out.println("Creating statement...");

        stmt = conn.createStatement();
        String sql;
        sql = statement;
        ResultSet rs = stmt.executeQuery(sql);
        HashMap<String, Sterownik> baza = new HashMap<>();
        Sterownik czujnik = null;
        while (rs.next()) {
            czujnik = new Sterownik(rs.getInt("id"), //id
                                    rs.getString("symbol"), //nazwa
                                    rs.getString("opis"), //opis
                                    rs.getString("opis_EN"), //opis_EN
                                    rs.getString("producent"), //producent
                                    rs.getString("dostawca"), //dostawca
                                    rs.getString("system"), //system
                                    rs.getString("typ_elementu"), //typElementu
                                    rs.getDouble("cena"), //cena
                                    rs.getString("waluta"), //waluta
                                    rs.getString("podsystem"), //waluta
                                    rs.getString("podTyp"), //waluta
                                    rs.getDouble("l_UI"), //cena
                                    rs.getDouble("l_AI"), //cena
                                    rs.getDouble("l_DI"), //cena
                                    rs.getDouble("l_AO"), //cena
                                    rs.getDouble("l_DO"), //cena
                                    rs.getDouble("l_DIDO"), //cena
                                    rs.getDouble("HAO"), //cena
                                    rs.getDouble("RTD"), //cena
                                    rs.getDouble("MODbus"), //cena
                                    rs.getDouble("Mbus")); //czynnik
            baza.put(rs.getString("symbol"), czujnik);

        }
        System.out.println("udalo sie dodac element");

        rs.close();
        stmt.close();
        conn.close();

        return baza;
    }

    public void tworzenie(String sql) throws ClassNotFoundException, SQLException {
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

        //STEP 4: Execute a query
        System.out.println("Creating statement...");

        stmt = conn.createStatement();

        stmt.executeUpdate(sql);
        System.out.println("baza poprawnie utworzona");

        stmt.close();
        conn.close();

    }

    public void uzupelnianieBazy(String sql) throws ClassNotFoundException, SQLException {
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

        //STEP 4: Execute a query
        System.out.println("Creating statement...");

        stmt = conn.createStatement();

        System.out.println(sql);
        stmt.executeUpdate(sql);

        stmt.close();
        conn.close();
    }

    public ArrayList<DACwynik> pobieranieDAC(String sql) throws ClassNotFoundException, SQLException {
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

        //STEP 4: Execute a query
        System.out.println("Creating statement...");

        stmt = conn.createStatement();
        
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<DACwynik> baza = new ArrayList<>();
        DACwynik czujnik = null;
        while (rs.next()){
            czujnik = new DACwynik( //id
                    rs.getString("sterownik"), //nazwa
                    rs.getString("modul1"), //opis
                    rs.getString("modul2"), //opis_EN
                    rs.getDouble("blc"), //producent
                    rs.getDouble("kac"), //dostawca
                    rs.getDouble("cyk"), //system
                    rs.getDouble("ethernet"), //typElementu

                    rs.getDouble("l_UI"), //cena
                    rs.getDouble("l_AI"), //cena
                    rs.getDouble("l_DI"), //cena
                    rs.getDouble("l_AO"), //cena
                    rs.getDouble("l_DO"), //cena
                    rs.getDouble("l_DIDO"), //cena
                    rs.getDouble("cena")); //cena
                    baza.add(czujnik);
        }
        System.out.println("udalo sie dodac element");

        rs.close();
        stmt.close();
        conn.close();

        return baza;
    }

}
