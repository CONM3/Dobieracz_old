package com.mycompany.dobieracz001.algorytm;

import com.mycompany.dobieracz001.wyniki.EBMwynik;

import com.mycompany.dobieracz001.sql.sterownik.Sterownik;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 *
 * @since 2017-09-07, 15:39:02
 * @author Grzegorz Brodowski
 */
public class AlgorytmEBM {

    private HashMap<String, Double> sterownikiBLC = new HashMap<>();
    HashMap<String, Sterownik> dbSterowniki;

    private double AI = 0;
    private double BI = 0;
    private double AO = 0;
    private double BO = 0;
    private double AO_r = 0;
    private double BI_kac = 0;
    private double UI_zost = 0;
    private double Suma_mod = 0;
    private double liczbaeBX = 0;

    private boolean boolKAC = false;
    private boolean boolCYK = false;
    private boolean booleBMGR = false;
    private boolean booleBCON = false;

    private double eBCON = 0;
    private double eBMGR = 0;

    private double eBX08 = 0;
    private double eBX04 = 0;

    private double eBM800 = 0;
    private double eBMD800 = 0;
    private double eBM440 = 0;
    private double eBM404 = 0;

    private double KAC4 = 0;
    private double CYK1 = 0;

    private double wAO = 0;
    private double wBO = 0;
    private double wUI = 0;
    private double wBI = 0;

    private double zAO = 0;
    private double zBO = 0;
    private double zUI = 0;
    private double zBI = 0;

    public AlgorytmEBM(double AI, double BI, double AO, double BO,  boolean boolCYK, boolean booleBCON, boolean booleBMGR, HashMap<String, Sterownik> dbSterowniki, double BI_kac) {
        this.AI = AI;
        this.BI = BI;
        this.AO = AO;
        this.BO = BO;
        this.booleBMGR = booleBMGR;
        this.booleBCON = booleBCON;
        
        this.boolCYK = boolCYK;
        this.dbSterowniki = dbSterowniki;
        this.BI_kac = BI_kac;
        if(BI_kac>0)this.boolKAC=true;
    }

    public AlgorytmEBM(double AI, double BI, double AO, double BO, boolean booleBMGR, HashMap<String, Sterownik> dbSterowniki) {
        this.AI = AI;
        this.BI = BI;
        this.AO = AO;
        this.BO = BO;
        this.booleBMGR = booleBMGR;
        this.dbSterowniki = dbSterowniki;
    }

    public AlgorytmEBM(double AI, double BI, double AO, double BO, HashMap<String, Sterownik> dbSterowniki) {
        this.AI = AI;
        this.BI = BI;
        this.AO = AO;
        this.BO = BO;
        this.dbSterowniki = dbSterowniki;

    }

    public EBMwynik CountEnteliIOs2() {
        EBMwynik listaSterowników;
        //obliczanie eBM440
        eBM440 = Math.ceil((AO) / 4);

        //obliczanie eBM404
        if (boolCYK) {
            AO_r = 4 * eBM440 - AO;
            eBM404 = Math.ceil((BO - AO_r) / 4);
            if ((BO - 4 * eBM404) <= 0)
                CYK1 = 0;
            else
                CYK1 = BO - 4 * eBM404;
        } else {
            eBM404 = Math.ceil(BO / 4);
            CYK1 = 0;
        }

        //obliczanie eBM800
        if (boolKAC){
            //if KAC1
            if ((AI - 4 * (eBM404 + eBM440)) > 0)//dobieram moduły do AI
            //gdy jest więcej AI z dotychczas dobranych modułów
            {
                eBM800 = Math.ceil((AI - 4 * (eBM404 + eBM440)) / 8);
                UI_zost = (8 * eBM800 + 4 * eBM440 + 4 * eBM404) - AI;//liczę ile zostało wejść UI
                if (UI_zost >= BI_kac)//sprawdzam czy potrzebne są KACe
                {
                    KAC4 = 0;
                    eBMD800 = 0;
                    UI_zost = UI_zost - BI_kac;
                } //do 8 DI opłaca się dać eBDM800
//                else if (UI_zost + 8 >= BI_kac) {
//                    KAC4 = 0;
//                    eBMD800 = 1;
//                    UI_zost = UI_zost + 8 - BI_kac;
//                }
                //za mało wejsc UI do obsluzenia
                else if (4 * UI_zost >= BI_kac)//potrzebne są KACe ale czy potrzebne też będa moduły?
                {
                    KAC4 = Math.ceil((BI_kac - UI_zost) / 3);
                    eBMD800 = 0;
                    UI_zost = UI_zost - Math.ceil(BI_kac / 4);
                } 
                
                //do 8 DI opłaca się dać eBDM800
                else if (UI_zost + 8 >= BI_kac) {
                    KAC4 = 0;
                    eBMD800 = 1;
                    UI_zost = UI_zost + 8 - BI_kac;
                }
                
                else if (4 * UI_zost +8 >= BI_kac){
                    KAC4 = Math.ceil((BI_kac - UI_zost) / 3);
                    eBMD800 = 1;
                    UI_zost = UI_zost - Math.ceil(BI_kac / 4);
                }
                
                else//dodaję odpowiednią liczbę eBM800 i uaktualniam UI
                {
                    eBM800 = eBM800 + Math.ceil((BI_kac - 4 * UI_zost) / 32);
                    UI_zost = (8 * eBM800 + 4 * eBM440 + 4 * eBM404) - AI;

                    if (UI_zost >= BI_kac)//strawdzam czy po dodaniu modułów potrzebne będą KACe
                    {
                        KAC4 = 0;
                        UI_zost = UI_zost - BI_kac;
                    } else//dodaje odpowiednią liczbę KAC
                        KAC4 = Math.ceil((BI_kac - UI_zost) / 3);
                }
                
               //Gdy UI jest więcej niż potrzebnych AI
            } else {
                UI_zost = 4 * (eBM404 + eBM440) - AI;
                if (UI_zost >= BI_kac)//sprawdzam czy potrzebne są KACe
                {
                    KAC4 = 0;
                    eBMD800 = 0;
                    UI_zost = UI_zost - BI_kac;
                } //do 8 DI opłaca się dać eBDM800
                else if (UI_zost + 8 >= BI_kac) {
                    KAC4 = 0;
                    eBMD800 = 1;
                    UI_zost = UI_zost + 8 - BI_kac;
                } //za mało wejsc UI do obsluzenia
                else if (4 * UI_zost >= BI_kac)//potrzebne są KACe ale czy potrzebne też będa moduły?
                {
                    KAC4 = Math.ceil((BI_kac - UI_zost) / 3);
                    eBMD800 = 0;
                    UI_zost = UI_zost - Math.ceil(BI_kac / 4);
                } else//dodaję odpowiednią liczbę eBM800 i uaktualniam UI
                {
                    eBM800 = eBM800 + Math.ceil((BI_kac - 4 * UI_zost) / 32);
                    UI_zost = (8 * eBM800 + 4 * eBM440 + 4 * eBM404) - AI;

                    if (UI_zost >= BI_kac)//strawdzam czy po dodaniu modułów potrzebne będą KACe
                    {
                        KAC4 = 0;
                        UI_zost = UI_zost - BI_kac;
                    } else//dodaje odpowiednią liczbę KAC
                        KAC4 = Math.ceil((BI_kac - UI_zost) / 3);
                }

            }
            
            if (UI_zost >= BI)//sprawdzam czy potrzebne są KACe
            {
                eBMD800 = eBMD800;
            } else
                //oblicznie eBMD800
                eBMD800 = eBMD800+Math.ceil((BI - UI_zost) / 8);
            
        }

        //nie dobieramyKAC
        else if ((AI - 4 * (eBM404 + eBM440)) >= 0) {
            eBM800 = Math.ceil((AI - 4 * (eBM404 + eBM440)) / 8);
            UI_zost = (8 * eBM800 + 4 * eBM440 + 4 * eBM404) - AI;
            KAC4 = 0;

            //wystarczająca liczba UI
            if (UI_zost >= BI)//sprawdzam czy potrzebne są KACe
            {
                KAC4 = 0;
                eBMD800 = 0;
            } else
                //oblicznie eBMD800
                eBMD800 = Math.ceil((BI - UI_zost) / 8);

            //więcej UI niż potrzebnych AI
        } else {
            eBM800 = 0;
            KAC4 = 0;
            UI_zost = (8 * eBM800 + 4 * eBM440 + 4 * eBM404)-AI;
            if ((AI - 4 * (eBM404 + eBM440) - BI) >= 0)
                eBMD800 = 0;
            else
                eBMD800 = Math.ceil((BI - UI_zost) / 8);
        }

        Suma_mod = eBM404 + eBM440 + eBM800 + eBMD800;

        //dobieranie CPU
        eBX04=0;
        eBX08=0;
        if (booleBMGR) {
            eBMGR = 1;
            eBCON = Math.floor(Suma_mod / 68) - 1;
            if (eBCON < 1)
                eBCON = 0;
            liczbaeBX = (Suma_mod - 4 * eBCON) / 8;
            eBX08 = Math.floor(liczbaeBX);
            if ((Suma_mod - 8 * eBX08) > 4)
                eBX08 = eBX08 + 1;
            else
                eBX04 = 1;
        } else if (booleBCON) {
            eBCON = Math.ceil(Suma_mod / 68);
            liczbaeBX = (Suma_mod - 4 * eBCON) / 8;
            double d1=liczbaeBX%1;
            eBX08 = Math.floor(liczbaeBX);
            if ((Suma_mod - 8 * eBX08) > 8)
                eBX08 = eBX08 + 1;
            else if(liczbaeBX%1<(0.01)||liczbaeBX%1>0.51)
                eBX04 = 0;
            else
                eBX04= 1;
        } else {
            eBMGR = 0;
            eBCON = Math.floor(Suma_mod / 68) - 1;
            if (eBCON < 1)
                eBCON = 0;
            liczbaeBX = (Suma_mod - 4 * eBCON) / 8;
            eBX08 = Math.floor(liczbaeBX);
            if ((Suma_mod - 8 * eBX08) > 4)
                eBX08 = eBX08 + 1;
            else
                eBX04 = 1;
        }

        listaSterowników = new EBMwynik(dbSterowniki, eBCON, eBMGR, eBX08,
                                        eBX04, eBM800, eBMD800, eBM440,
                                        eBM404, KAC4, CYK1);

        wUI = 8 * eBM800 + eBM440 * 4 + eBM404 * 4 - KAC4 - CYK1;
        wBI = 8 * eBMD800 + 4 * KAC4;
        wAO = 4 * eBM440;
        wBO = 4 * eBM404;

        zUI = wUI - AI;
        zBI = wBI - (BI+BI_kac);
        if (zBI < 0) {
            zUI = zUI + zBI;
            zBI = 0;
        }
        zAO = wAO - AO;
        zBO = wBO - BO;

        listaSterowników.setSygnaly(wUI, wAO, wBI, wBO, zUI, zAO, zBI, zBO);
        return listaSterowników;

    }

}
