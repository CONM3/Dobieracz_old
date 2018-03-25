package com.mycompany.dobieracz001.wyniki;

import static com.mycompany.dobieracz001.main.main.CAD;
import static com.mycompany.dobieracz001.main.main.EURO;
import static com.mycompany.dobieracz001.main.main.UPUST;
import com.mycompany.dobieracz001.sql.sterownik.Sterownik;
import java.text.DecimalFormat;
import java.util.HashMap;

/**
 *
 *
 * @since 2017-09-25, 13:29:27
 * @author Grzegorz Brodowski
 */
public class BLCwynik implements Wynik {
    private HashMap<String, Sterownik> ster;
    private double cena = 0;
    private double BLC = 0;
    private double DFM400 = 0;
    private double AI;
    private double DIDO;
    private double nAI;
    private double nDIDO;
    private double pBI;
    private double pBO;
    private double pAI;

    public BLCwynik(HashMap<String, Sterownik> ster, double BI, double BO, double AI) {
        this.ster = ster;
        this.pAI=AI;
        this.pBI=BI;
        this.pBO=BO;

        if (AI > 0)
            DFM400 = 1;
        BLC = Math.ceil((BI + BO) / 24);
        wyliczCene();
    }

    @Override
    public String wypisz() {
        String tekst = "<html> ";
        DecimalFormat df = new DecimalFormat("#.00");
        if (BLC > 0)
            tekst = tekst + "BLC-24A: " + (int) BLC + "<br> ";
        if (DFM400 > 0)
            tekst = tekst + "DFM-400: " + (int) DFM400 + "<br> ";

        if (BLC > 0) {
            tekst = tekst + "DI/DO: " + (int) BLC * 24 + "<br> ";
            tekst = tekst + "UI: " + (int) DFM400 * 4 + "<br> ";
            tekst = tekst + "nDI/DO: " + (int) (BLC * 24 - (pBI + pBO)) + "<br> ";
            tekst = tekst + "nUI: " + (int) (DFM400 * 4 -pAI) + "<br> ";

        }
        if (cena > 0)
            tekst = tekst + "--------------------------" + "<br> ";
            tekst = tekst + "cena: " + df.format(cena) + "<br> ";
        return tekst;
    }
    
    public Object[][] wypiszTabele2() {
        Object[][] data2 = 
        {{"BLC-24A", String.valueOf((int)BLC)},
        {"DFM400", String.valueOf((int)DFM400)}
        };
        
        return data2;
    }

    @Override
    public void wyliczCene() {
        cena = BLC * ster.get("BLC-24A").getCena() * EURO
               + DFM400 * ster.get("DFM-400").getCena() * CAD * UPUST;
    }

    @Override
    public void wyliczNieuzywaneSygnaly() {
        throw new UnsupportedOperationException("Not supported yet."); //TODO[3]:
    }

    @Override
    public void wyliczSygnaly() {
        throw new UnsupportedOperationException("Not supported yet."); //TODO[3]:
    }

    @Override
    public void wypiszTabele() {
        throw new UnsupportedOperationException("Not supported yet."); //TODO[3]:
    }

}
