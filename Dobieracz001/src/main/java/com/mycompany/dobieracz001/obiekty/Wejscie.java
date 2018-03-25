package com.mycompany.dobieracz001.obiekty;

/**
 * 
 *
 * @since 2017-09-11, 22:23:52
 * @author Grzegorz Brodowski
 */
public class Wejscie {
    String Rozdzielnica;
    double AI,DI,AO,DO;

    public Wejscie(String Rozdzielnica, double AI, double DI, double AO, double DO) {
        this.Rozdzielnica = Rozdzielnica;
        this.AI = AI;
        this.DI = DI;
        this.AO = AO;
        this.DO = DO;
    }

    public String getRozdzielnica() {
        return Rozdzielnica;
    }

    public double getAI() {
        return AI;
    }

    public double getDI() {
        return DI;
    }

    public double getAO() {
        return AO;
    }

    public double getDO() {
        return DO;
    }
    
    

  

  
    
    
    

}