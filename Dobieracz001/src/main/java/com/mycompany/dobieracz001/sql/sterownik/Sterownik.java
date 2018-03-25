package com.mycompany.dobieracz001.sql.sterownik;

/**
 *
 *
 * @since 2017-09-06, 16:08:30
 * @author Grzegorz Brodowski
 */
public class Sterownik implements Cloneable{
    private int id;
    private String symbol;
    private String opis;
    private String opis_EN;
    private String producent;
    private String dostawca;
    private String system;
    private String typ_Elementu;
    private double cena;
    private String waluta;
    private String podsystem;
    private String podTyp;
    private double l_UI;
    private double l_AI;
    private double l_DI;
    private double l_AO;
    private double l_DO;
    private double l_DIDO;
    private double HAO;
    private double RTD;
    private double MODbus;
    private double Mbus;

    public Sterownik(int id, String symbol, String opis, String opis_EN, String producent, String dostawca, String system, String typ_Elementu, double cena, String waluta, String podsystem, String podTyp, double l_UI, double l_AI, double l_DI, double l_AO, double l_DO, double l_DIDO, double HAO, double RTD, double MODbus, double Mbus) {
        this.id = id;
        this.symbol = symbol;
        this.opis = opis;
        this.opis_EN = opis_EN;
        this.producent = producent;
        this.dostawca = dostawca;
        this.system = system;
        this.typ_Elementu = typ_Elementu;
        this.cena = cena;
        this.waluta = waluta;
        this.podsystem = podsystem;
        this.podTyp = podTyp;
        this.l_UI = l_UI;
        this.l_AI = l_AI;
        this.l_DI = l_DI;
        this.l_AO = l_AO;
        this.l_DO = l_DO;
        this.l_DIDO = l_DIDO;
        this.HAO = HAO;
        this.RTD = RTD;
        this.MODbus = MODbus;
        this.Mbus = Mbus;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public void wypisanie() {
        System.out.println(id + " "
                           + symbol + " "
                           + opis + " "
                           + opis_EN + " "
                           + producent + " "
                           + dostawca + " "
                           + system + " "
                           + typ_Elementu + " "
                           + cena + " "
                           + waluta + " "
                           + podsystem + " "
        );
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
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

    public String getTyp_Elementu() {
        return typ_Elementu;
    }

    public void setTyp_Elementu(String typ_Elementu) {
        this.typ_Elementu = typ_Elementu;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getWaluta() {
        return waluta;
    }

    public void setWaluta(String waluta) {
        this.waluta = waluta;
    }

    public String getPodsystem() {
        return podsystem;
    }

    public void setPodsystem(String podsystem) {
        this.podsystem = podsystem;
    }

    public String getPodTyp() {
        return podTyp;
    }

    public void setPodTyp(String podTyp) {
        this.podTyp = podTyp;
    }

    public double getL_UI() {
        return l_UI;
    }

    public void setL_UI(double l_UI) {
        this.l_UI = l_UI;
    }

    public double getL_AI() {
        return l_AI;
    }

    public void setL_AI(double l_AI) {
        this.l_AI = l_AI;
    }

    public double getL_DI() {
        return l_DI;
    }

    public void setL_DI(double l_DI) {
        this.l_DI = l_DI;
    }

    public double getL_AO() {
        return l_AO;
    }

    public void setL_AO(double l_AO) {
        this.l_AO = l_AO;
    }

    public double getL_DO() {
        return l_DO;
    }

    public void setL_DO(double l_DO) {
        this.l_DO = l_DO;
    }

    public double getL_DIDO() {
        return l_DIDO;
    }

    public void setL_DIDO(double l_DIDO) {
        this.l_DIDO = l_DIDO;
    }

    public double getHAO() {
        return HAO;
    }

    public void setHAO(double HAO) {
        this.HAO = HAO;
    }

    public double getRTD() {
        return RTD;
    }

    public void setRTD(double RTD) {
        this.RTD = RTD;
    }

    public double getMODbus() {
        return MODbus;
    }

    public void setMODbus(double MODbus) {
        this.MODbus = MODbus;
    }

    public double getMbus() {
        return Mbus;
    }

    public void setMbus(double Mbus) {
        this.Mbus = Mbus;
    }

}
