package com.mycompany.dobieracz001.sql.sterownik;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 *
 * @since 2017-10-12, 10:55:34
 * @author Grzegorz Brodowski
 */
public class testZdalnie {
    
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
        sql = "CREATE TABLE testZdalnie1(id integer,symbol character varying,\n" //0,1
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

}