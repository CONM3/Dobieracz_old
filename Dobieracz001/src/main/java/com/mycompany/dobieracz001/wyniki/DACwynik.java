package com.mycompany.dobieracz001.wyniki;

import static com.mycompany.dobieracz001.main.main.CAD;
import static com.mycompany.dobieracz001.main.main.EURO;
import static com.mycompany.dobieracz001.main.main.UPUST;
import com.mycompany.dobieracz001.sql.sterownik.Sterownik;
import java.text.DecimalFormat;
import java.util.Objects;

/**
 *
 *
 * @since 2017-09-18, 15:47:46
 * @author Grzegorz Brodowski
 */
public class DACwynik implements Wynik {
    private Sterownik sterownik = null;
    private Sterownik modul1 = null;
    private Sterownik modul2 = null;
    private Sterownik sBLC = null;
    private double blc = 0;
    private double kac = 0;
    private double cyk = 0;
    private double ethernet = 0;
    private double UI = 0;
    private double AI = 0;
    private double DI = 0;
    private double AO = 0;
    private double DO = 0;
    private double DIDO = 0;
    private double cena = 0;
    private String nazwa1, nazwa2, nazwa3, nazwa4 = "brak";
    private String porownanie;

    private double nUI = 0;
    private double nAI = 0;
    private double nDI = 0;
    private double nAO = 0;
    private double nDO = 0;
    private double nDIDO = 0;

    private double pUI = 0;
    private double pAI = 0;
    private double pDI = 0;
    private double pAO = 0;
    private double pDO = 0;

    private double rezerwa = 0;

    Object[][] data;

    public DACwynik(String sterownik, String modul1, String modul2, double blc, double kac, double cyk, double ethernet, double UI, double AI, double DI, double AO, double DO, double DIDO, double cena) {

        this.nazwa1 = sterownik;
        this.nazwa2 = modul1;
        this.nazwa3 = modul2;
        this.blc = blc;
        this.kac = kac;
        this.cyk = cyk;
        this.ethernet = ethernet;
        this.UI = UI;
        this.AI = AI;
        this.DI = DI;
        this.AO = AO;
        this.DO = DO;
        this.DIDO = DIDO;
        this.cena = cena;

    }

    public DACwynik() {
    }

    public String dacSQL() {
        return "Insert into tabelaDAC(sterownik,modul1,modul2,blc,kac,cyk,ethernet, \n"
               + "l_UI,l_AI,l_DI,l_AO,l_DO,l_DIDO,cena)\n"
               + " values \n"
               + "('" + this.sterownik.getSymbol() + "',\n" //0
               + "'" + this.nazwa1 + "'" + ",\n" //1
               + "'" + this.nazwa2 + "'" + ",\n" //2
               + "'" + this.blc + "'" + ",\n" //3
               + "'" + this.kac + "'" + ",\n" //4
               + "'" + this.cyk + "'" + ",\n" //5
               + "'" + this.ethernet + "'" + ",\n" //6
               + "'" + this.UI + "'" + ",\n" //7
               + this.AI + ",\n" //8
               + "'" + this.DI + "'" + ",\n" //9
               + "'" + this.AO + "'" + ",\n" //10
               + "'" + this.DO + "'" + ",\n" //11
               + "'" + this.DIDO + "'" + ",\n" //12
               + "'" + this.cena + "'" + ")"; //21
    }

//        tabelaDAC
//        CREATE TABLE tabelaDAC(sterownik character varying,modul1 character varying,modul2 character varying,
//               blc double precision,kac double precision,cyk double precision,ethernet double precision,l_UI double precision,
//l_AI double precision,l_DI double precision,
//                l_AO double precision,l_DO double precision,l_DIDO double precision,cena double precision)
    public DACwynik(Sterownik sterownik) {
        this.sterownik = sterownik;
        this.UI = sterownik.getL_UI();
        this.DI = sterownik.getL_DI();
        this.AO = sterownik.getL_AO();
        this.DO = sterownik.getL_DO();
        cena = sterownik.getCena() * UPUST * CAD;
    }

    public DACwynik(Sterownik sterownik, Sterownik modul1) {
        this.sterownik = sterownik;
        this.modul1 = modul1;
        this.UI = sterownik.getL_UI() + modul1.getL_UI();
        this.DI = sterownik.getL_DI() + modul1.getL_DI();
        this.AO = sterownik.getL_AO() + modul1.getL_AO();
        this.DO = sterownik.getL_DO() + modul1.getL_DO();
        cena = (sterownik.getCena() + modul1.getCena()) * UPUST * CAD;
        nazwa1 = modul1.getSymbol();
    }

    public DACwynik(Sterownik sterownik, Sterownik modul1, Sterownik modul2) {
        this.sterownik = sterownik;
        this.modul1 = modul1;
        this.modul2 = modul2;
        this.UI = sterownik.getL_UI() + modul1.getL_UI() + modul2.getL_UI();
        this.DI = sterownik.getL_DI() + modul1.getL_DI() + modul2.getL_DI();
        this.AO = sterownik.getL_AO() + modul1.getL_AO() + modul2.getL_AO();
        this.DO = sterownik.getL_DO() + modul1.getL_DO() + modul2.getL_DO();
        cena = (sterownik.getCena() + modul1.getCena() + modul2.getCena()) * UPUST * CAD;
        nazwa1 = modul1.getSymbol();
        nazwa2 = modul2.getSymbol();
    }

    public String wypisz2() {
        DecimalFormat df = new DecimalFormat("#.00");
        String tekst = "<html> ";
        tekst = tekst + nazwa1 + "<br> ";
        tekst = tekst + nazwa2 + "<br> ";
        tekst = tekst + nazwa3 + "<br> ";
        tekst = tekst + (int) blc + "<br> ";

        tekst = tekst + (int) kac + "<br> ";
        tekst = tekst + (int) cyk + "<br> ";
        tekst = tekst + (int) UI + "<br> ";
        tekst = tekst + (int) DI + "<br> ";
        tekst = tekst + (int) AO + "<br> ";
        tekst = tekst + (int) DO + "<br> ";
        tekst = tekst + (int) DIDO + "<br> ";
        tekst = tekst + df.format(cena) + "<br> ";
        tekst = tekst + "--------------------------" + "<br> ";
        tekst = tekst + "nieużywane Sygnaly" + "<br> ";
        tekst = tekst + "--------------------------" + "<br> ";
        tekst = tekst + "nUI: " + nUI + "<br> ";
        tekst = tekst + "nAO: " + nAO + "<br> ";
        tekst = tekst + "nBO: " + nDO + "<br> ";
        tekst = tekst + "nBI: " + nDI + "<br> ";
        tekst = tekst + "nBIBO: " + nDIDO + "<br> ";
        tekst = tekst + "--------------------------" + "<br> ";
        tekst = tekst + "Rezerwa" + "<br> ";
        tekst = tekst + "--------------------------" + "<br> ";
        tekst = tekst + "rezerwa: " + df.format(rezerwa) + " %" + "<br> ";

        tekst = tekst + "</html> ";
        return tekst;
    }

    public String wypiszJLabel() {
        String tekst = "<html> ";
        tekst = tekst + "sterownik: " + "<br> ";
        tekst = tekst + "modul: " + "<br> ";
        tekst = tekst + "modul: " + "<br> ";
        tekst = tekst + "blc: " + "<br> ";
        tekst = tekst + "KAC: " + "<br> ";
        tekst = tekst + "CYK: " + "<br> ";
        tekst = tekst + "UI: " + "<br> ";
        tekst = tekst + "DI: " + "<br> ";
        tekst = tekst + "AO: " + "<br> ";
        tekst = tekst + "DO: " + "<br> ";
        tekst = tekst + "DODI: " + "<br> ";
        tekst = tekst + "cena: " + "<br> ";
        tekst = tekst + "</html> ";
        return tekst;
    }

    public double getCena() {
        return cena;
    }

    public void addBLC(Sterownik sblc, double zAI, double zBI, double zAO, double zBO) {
        this.sBLC = sblc;
        double BIBO = zBI + zBO - this.UI + zAI;
        if (BIBO < 0)
            BIBO = 0;

        this.blc = Math.ceil(BIBO / 24);
        this.DIDO = blc * 24;
        this.cena = this.cena + this.blc * this.sBLC.getCena() * EURO;
    }

    @Override
    public String wypisz() {
        throw new UnsupportedOperationException("Not supported yet."); //TODO[3]:
    }

    @Override
    public void wyliczCene() {
        throw new UnsupportedOperationException("Not supported yet."); //TODO[3]:
    }

    public void wyliczNieuzywaneSygnaly(double zUI, double zBI, double zAO, double zBO) {
        this.nUI = this.UI - zUI;
        this.nDI = this.DI - zBI;
        this.nDIDO = this.DIDO;
        if (this.nDI < 0) {
            this.nDIDO = this.nDIDO + this.nDI;
            this.nDI = 0;
        }
        if (nDI < 0)
            this.nUI = this.UI - zUI;
        this.nAO = this.AO - zAO;
        this.nDO = this.DO - zBO;
        if (this.nDO < 0) {
            this.nDIDO = this.nDIDO + this.nDO;
            this.nDO = 0;
        }
        if (this.nDIDO < 0) {
            this.nUI = this.nUI + this.nDIDO;
            this.nDIDO = 0;
        }
        this.pUI = zUI;
        this.pDI = zBI;
        this.pAO = zAO;
        this.pDO = zBO;

        rezerwa = (1 - (pUI + pDI + pAO + pDO) / (UI + DI + DO + AO + DIDO)) * 100;

    }

    @Override
    public void wyliczSygnaly() {
        throw new UnsupportedOperationException("Not supported yet."); //TODO[3]:
    }

    
    public Object[][] wypiszTabele2() {
        Object[][] data2 = {{nazwa1, "1"},
        {nazwa2, "1"},
        {nazwa3, "1"},
        {"KAC-4", String.valueOf((int) kac)},
        {"CYK-1", String.valueOf((int) cyk)},
        {"BLC-24", String.valueOf((int) blc)}
        };
        
        return data2;
    }

    public Object[][] getData() {
        return data;
    }

    public double getUI() {
        return UI;
    }

    @Override
    public void wyliczNieuzywaneSygnaly() {
        throw new UnsupportedOperationException("Not supported yet."); //TODO[3]:
    }

    public void addKAC(int i) {
        if (UI >= i) {
            kac = kac + i;
            UI = UI - i;
            DI = DI + i * 4;
            cena = cena + 15 * EURO * i;
        }
    }

    public void removeKAC(int i) {
        if (kac >= i) {
            kac = kac - i;
            UI = UI + i;
            DI = DI - i * 4;
            cena = cena - 15 * EURO * i;
        }
    }

    public void addCYK(int i) {
        if (UI >= i) {
            cyk = cyk + i;
            UI = UI - i;
            DO = DO + i;
            cena = cena + 12 * EURO * i;
        }
    }

    public void removeCYK(int i) {
        if (cyk >= i) {
            cyk = cyk - i;
            UI = UI + i;
            DO = DO - i;
            cena = cena - 12 * EURO * i;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.sterownik);
        hash = 37 * hash + Objects.hashCode(this.modul1);
        hash = 37 * hash + Objects.hashCode(this.modul2);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.blc) ^ (Double.doubleToLongBits(this.blc) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.kac) ^ (Double.doubleToLongBits(this.kac) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.cyk) ^ (Double.doubleToLongBits(this.cyk) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.ethernet) ^ (Double.doubleToLongBits(this.ethernet) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.UI) ^ (Double.doubleToLongBits(this.UI) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.AI) ^ (Double.doubleToLongBits(this.AI) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.DI) ^ (Double.doubleToLongBits(this.DI) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.AO) ^ (Double.doubleToLongBits(this.AO) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.DO) ^ (Double.doubleToLongBits(this.DO) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.DIDO) ^ (Double.doubleToLongBits(this.DIDO) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.cena) ^ (Double.doubleToLongBits(this.cena) >>> 32));
        hash = 37 * hash + Objects.hashCode(this.nazwa1);
        hash = 37 * hash + Objects.hashCode(this.nazwa2);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final DACwynik other = (DACwynik) obj;
        if (Double.doubleToLongBits(this.blc) != Double.doubleToLongBits(other.blc))
            return false;
        if (Double.doubleToLongBits(this.kac) != Double.doubleToLongBits(other.kac))
            return false;
        if (Double.doubleToLongBits(this.cyk) != Double.doubleToLongBits(other.cyk))
            return false;
        if (Double.doubleToLongBits(this.ethernet) != Double.doubleToLongBits(other.ethernet))
            return false;
        if (Double.doubleToLongBits(this.UI) != Double.doubleToLongBits(other.UI))
            return false;
        if (Double.doubleToLongBits(this.AI) != Double.doubleToLongBits(other.AI))
            return false;
        if (Double.doubleToLongBits(this.DI) != Double.doubleToLongBits(other.DI))
            return false;
        if (Double.doubleToLongBits(this.AO) != Double.doubleToLongBits(other.AO))
            return false;
        if (Double.doubleToLongBits(this.DO) != Double.doubleToLongBits(other.DO))
            return false;
        if (Double.doubleToLongBits(this.DIDO) != Double.doubleToLongBits(other.DIDO))
            return false;
        if (Double.doubleToLongBits(this.cena) != Double.doubleToLongBits(other.cena))
            return false;
        if (!Objects.equals(this.nazwa1, other.nazwa1))
            return false;
        if (!Objects.equals(this.nazwa2, other.nazwa2))
            return false;
        if (!Objects.equals(this.sterownik, other.sterownik))
            return false;
        if (!Objects.equals(this.modul1, other.modul1))
            return false;
        if (!Objects.equals(this.modul2, other.modul2))
            return false;
        return true;
    }

    @Override
    public void wypiszTabele() {
        throw new UnsupportedOperationException("Not supported yet."); //TODO[3]:
    }

}
