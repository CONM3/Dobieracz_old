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
 * @since 2017-09-22, 10:32:56
 * @author Grzegorz Brodowski
 */
public class EBMwynik implements Wynik {
    private HashMap<String, Sterownik> ster;
    private double eBCON = 0;
    private double eBMGR = 0;
    private double eBX08 = 0;
    private double eBX04 = 0;
    private double eBM800 = 0;
    private double eBMD800 = 0;
    private double eBM440 = 0;
    private double eBM404 = 0;
    private double blc = 0;
    private double KAC4 = 0;
    private double CYK1 = 0;
    private double cena = 0;

    private double UI = 0;
    private double AO = 0;
    private double BI = 0;
    private double BO = 0;
    private double BIBO = 0;

    private double nUI = 0;
    private double nAO = 0;
    private double nBI = 0;
    private double nBO = 0;
    private double nBIBO = 0;

    private double rezerwa = 0;
    
    private Object[][] tabelaData;
    private String[] tabelaColumnName;

    public void setSygnaly(double UI, double AO, double BI, double BO,
                           double nUI, double nAO, double nBI, double nBO) {
        this.UI = UI;
        this.AO = AO;
        this.BI = BI;
        this.BO = BO;

        this.nUI = nUI;
        this.nAO = nAO;
        this.nBI = nBI;
        this.nBO = nBO;

        if ((UI + AO + BI + BO) != 0)
            this.rezerwa = ((nUI + nAO + nBI + nBO) / (UI + AO + BI + BO)) * 100;

    }

    public EBMwynik(HashMap<String, Sterownik> ster,
                    double eBCON,
                    double eBMGR,
                    double eBX08,
                    double eBX04,
                    double eBM800,
                    double eBMD800,
                    double eBM440,
                    double eBM404,
                    double KAC4,
                    double CYK1) {
        this.ster = ster;
        this.eBCON = eBCON;
        this.eBMGR = eBMGR;
        this.eBX08 = eBX08;
        this.eBX04 = eBX04;
        this.eBM800 = eBM800;
        this.eBMD800 = eBMD800;
        this.eBM440 = eBM440;
        this.eBM404 = eBM404;
        this.KAC4 = KAC4;
        this.CYK1 = CYK1;
        wyliczCene();
    }

    public void wyliczCene() {
        cena = (eBCON * ster.get("eBCON").getCena()
                + eBMGR * ster.get("eBMGR").getCena()
                + eBX08 * ster.get("eBX-08").getCena()
                + eBX04 * ster.get("eBX-04").getCena()
                + eBM800 * ster.get("eBM-800").getCena()
                + eBMD800 * ster.get("eBM-D800").getCena()
                + eBM440 * ster.get("eBM-440").getCena()
                + eBM404 * ster.get("eBM-404").getCena()) * CAD * UPUST
               + KAC4 * ster.get("KAC-4").getCena() * EURO
               + CYK1 * ster.get("CYK-1").getCena() * EURO;
        cena = cena;
    }
    
    public Object[][] wypiszTabele2() {
        Object[][] data2 = 
        {{"eBCON", String.valueOf((int)eBCON)},
        {"eBMGR", String.valueOf((int)eBMGR)},
        {"eBX-08", String.valueOf((int)eBX08)},
        {"eBX-04", String.valueOf((int)eBX04)},
        {"eBM-800", String.valueOf((int)eBM800)},
        {"eBM-D800", String.valueOf((int)eBMD800)},
        {"eBM-440", String.valueOf((int)eBM440)},
        {"eBM-404", String.valueOf((int)eBM404)},
        {"KAC-4", String.valueOf((int)KAC4)},
        {"CYK-1", String.valueOf((int)CYK1)},
        {"BLC-24A", String.valueOf((int)blc)},
        };
        
        return data2;
    }

    public String wypisz() {
        DecimalFormat df = new DecimalFormat("#.00");
        String tekst = "<html> ";
        if (eBCON > 0)
            tekst = tekst + "eBCON:  " + (int) eBCON + "<br> ";
        if (eBMGR > 0)
            tekst = tekst + "eBMGR: " + (int) eBMGR + "<br> ";
        if (eBX08 > 0)
            tekst = tekst + "eBX-08: " + (int) eBX08 + "<br> ";
        if (eBX04 > 0)
            tekst = tekst + "eBX-04: " + (int) eBX04 + "<br> ";
        if (eBM800 > 0)
            tekst = tekst + "eBM-800: " + (int) eBM800 + "<br> ";
        if (eBMD800 > 0)
            tekst = tekst + "eBM-D800: " + (int) eBMD800 + "<br> ";
        if (eBM440 > 0)
            tekst = tekst + "eBM-440: " + (int) eBM440 + "<br> ";
        if (eBM404 > 0)
            tekst = tekst + "eBM-404: " + (int) eBM404 + "<br> ";
        if (KAC4 > 0)
            tekst = tekst + "KAC-4: " + (int) KAC4 + "<br> ";
        if (CYK1 > 0)
            tekst = tekst + "CYK-1: " + (int) CYK1 + "<br> ";
        if (blc > 0)
            tekst = tekst + "BLC-24A: " + (int) blc + "<br> ";
        if (cena > 0) {
            tekst = tekst + "--------------------------" + "<br> ";
            tekst = tekst + "cena: " + df.format(cena) + "<br> ";
        }
        tekst = tekst + "--------------------------" + "<br> ";
        tekst = tekst + "Sygnaly" + "<br> ";
        tekst = tekst + "--------------------------" + "<br> ";
        tekst = tekst + "UI: " + UI + "<br> ";
        tekst = tekst + "AO: " + AO + "<br> ";
        tekst = tekst + "BO: " + BO + "<br> ";
        tekst = tekst + "BI: " + BI + "<br> ";
        if (blc > 0)
            tekst = tekst + "BIBO: " + (int) BIBO + "<br> ";
        tekst = tekst + "--------------------------" + "<br> ";
        tekst = tekst + "nieużywane Sygnaly" + "<br> ";
        tekst = tekst + "--------------------------" + "<br> ";
        tekst = tekst + "nUI: " + nUI + "<br> ";
        tekst = tekst + "nAO: " + nAO + "<br> ";
        tekst = tekst + "nBO: " + nBO + "<br> ";
        tekst = tekst + "nBI: " + nBI + "<br> ";
        if (blc > 0)
            tekst = tekst + "nBIBO: " + (int) nBIBO + "<br> ";
        tekst = tekst + "--------------------------" + "<br> ";
        tekst = tekst + "Rezerwa" + "<br> ";
        tekst = tekst + "--------------------------" + "<br> ";
        tekst = tekst + "rezerwa: " + df.format(rezerwa) + " %" + "<br> ";

        return tekst;
    }
    
    public void daneTabeli(){
        String tekst = "<html> ";
        if (eBCON > 0)
            tekst = tekst + "eBCON:  " + (int) eBCON + "<br> ";
        if (eBMGR > 0)
            tekst = tekst + "eBMGR: " + (int) eBMGR + "<br> ";
        if (eBX08 > 0)
            tekst = tekst + "eBX-08: " + (int) eBX08 + "<br> ";
        if (eBX04 > 0)
            tekst = tekst + "eBX-04: " + (int) eBX04 + "<br> ";
        if (eBM800 > 0)
            tekst = tekst + "eBM-800: " + (int) eBM800 + "<br> ";
        if (eBMD800 > 0)
            tekst = tekst + "eBM-D800: " + (int) eBMD800 + "<br> ";
        if (eBM440 > 0)
            tekst = tekst + "eBM-440: " + (int) eBM440 + "<br> ";
        if (eBM404 > 0)
            tekst = tekst + "eBM-404: " + (int) eBM404 + "<br> ";
        if (KAC4 > 0)
            tekst = tekst + "KAC-4: " + (int) KAC4 + "<br> ";
        if (CYK1 > 0)
            tekst = tekst + "CYK-1: " + (int) CYK1 + "<br> ";
        if (blc > 0)
            tekst = tekst + "BLC-24A: " + (int) blc + "<br> ";
    }

    public void addBLC(double BI, double BO) {
        
        if (this.nUI < (BI + BO)) {
            this.BIBO = BI + BO;
            this.blc = Math.ceil(this.BIBO / 24);
            this.nBIBO = blc * 24 - this.BIBO;
            if(BI+BO-nUI<(blc-1)*24)
            {
                blc=blc-1;
                nBIBO=0;
                nUI=blc*24-(BI+BO-nUI);
            }
            this.BIBO=blc*24;
            if ((UI + AO +BIBO) != 0)
                this.rezerwa = ((nUI + nAO + nBIBO) / (UI + AO + BIBO)) * 100;
            this.cena = this.cena + ster.get("BLC-24A").getCena() * EURO * blc;
        } else
            this.nUI = this.nUI - (BI + BO);

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
