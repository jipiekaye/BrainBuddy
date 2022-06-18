package com.jip.BrainBuddy;

public class TijdStip extends Klok {
    private String tijdStip;

    public boolean isNu(){
        Klok klok = new Klok();
        return tijdStip.equals(klok.getTijd());
    }

    public TijdStip(String tijdStip) {
        this.tijdStip = tijdStip;
    }

    public String getTijdStip() {
        return tijdStip;
    }
}
