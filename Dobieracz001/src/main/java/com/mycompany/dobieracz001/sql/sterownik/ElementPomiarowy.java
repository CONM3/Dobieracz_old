package com.mycompany.dobieracz001.sql.sterownik;

/**
 * 
 *
 * @since 2017-08-31, 11:21:21
 * @author Grzegorz Brodowski
 */
public class ElementPomiarowy {
    private int id;
   private String nazwa,opis,opis_EN,producent,dostawca,system,typElementu,sygnal;
   private double dlugosc,l_AI,l_DI,l_AO,l_DO;
   private String sposobPomiaru,zakres,pasywny,czynnik;
   private String waluta;
   private double cena;

    public ElementPomiarowy(int id,String nazwa, String opis, String opis_EN, String producent, String dostawca, String system, String typElementu,double cena,String waluta, double dlugosc,String sygnal, double l_AI, double l_DI, double l_AO, double l_DO, String sposobPomiaru, String zakres, String pasywny, String czynnik) {
        this.nazwa = nazwa;
        this.opis = opis;
        this.opis_EN = opis_EN;
        this.producent = producent;
        this.dostawca = dostawca;
        this.system = system;
        this.typElementu = typElementu;
        this.dlugosc = dlugosc;
        this.l_AI = l_AI;
        this.l_DI = l_DI;
        this.l_AO = l_AO;
        this.l_DO = l_DO;
        this.sposobPomiaru = sposobPomiaru;
        this.zakres = zakres;
        this.pasywny = pasywny;
        this.czynnik = czynnik;
        this.cena = cena;
        this.waluta = waluta;
        this.sygnal = sygnal;
        this.id = id;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSygnal() {
        return sygnal;
    }

    public void setSygnal(String sygnal) {
        this.sygnal = sygnal;
    }

    public String getWaluta() {
        return waluta;
    }

    public void setWaluta(String waluta) {
        this.waluta = waluta;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }
   

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getOpis_EN() {
        return opis_EN;
    }

    public void setOpis_EN(String opis_EN) {
        this.opis_EN = opis_EN;
    }

    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    public String getDostawca() {
        return dostawca;
    }

    public void setDostawca(String dostawca) {
        this.dostawca = dostawca;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getTypElementu() {
        return typElementu;
    }

    public void setTypElementu(String typElementu) {
        this.typElementu = typElementu;
    }

    public double getDlugosc() {
        return dlugosc;
    }

    public void setDlugosc(int dlugosc) {
        this.dlugosc = dlugosc;
    }

    public double getL_AI() {
        return l_AI;
    }

    public void setL_AI(int l_AI) {
        this.l_AI = l_AI;
    }

    public double getL_DI() {
        return l_DI;
    }

    public void setL_DI(int l_DI) {
        this.l_DI = l_DI;
    }

    public double getL_AO() {
        return l_AO;
    }

    public void setL_AO(int l_AO) {
        this.l_AO = l_AO;
    }

    public double getL_DO() {
        return l_DO;
    }

    public void setL_DO(int l_DO) {
        this.l_DO = l_DO;
    }

    public String getSposobPomiaru() {
        return sposobPomiaru;
    }

    public void setSposobPomiaru(String sposobPomiaru) {
        this.sposobPomiaru = sposobPomiaru;
    }

    public String getZakres() {
        return zakres;
    }

    public void setZakres(String zakres) {
        this.zakres = zakres;
    }

    public String getPasywny() {
        return pasywny;
    }

    public void setPasywny(String pasywny) {
        this.pasywny = pasywny;
    }

    public String getCzynnik() {
        return czynnik;
    }

    public void setCzynnik(String czynnik) {
        this.czynnik = czynnik;
    }
   
   

}