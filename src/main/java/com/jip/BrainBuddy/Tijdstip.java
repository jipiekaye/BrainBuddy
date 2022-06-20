package com.jip.BrainBuddy;

public class Tijdstip extends Klok {
    private String tijdStip;

    public boolean isNu(){
        Klok klok = new Klok();
        return tijdStip.equals(klok.getTijd());
    }

    public Tijdstip(String tijdStip) {
        this.tijdStip = tijdStip;
    }

    public String getTijdStip() {
        return tijdStip;
    }
}
