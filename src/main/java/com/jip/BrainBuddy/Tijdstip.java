package com.jip.BrainBuddy;

public class Tijdstip extends Klok {
    private String tijdstip;

    public boolean isNu(){
        Klok klok = new Klok();
        return tijdstip.equals(klok.getTijd());
    }

    public Tijdstip(String tijdStip) {
        this.tijdstip = tijdStip;
    }
}
