package com.jip.BrainBuddy.Taak;

import com.jip.BrainBuddy.Melding;
import com.jip.BrainBuddy.Tijdstip;

import java.awt.*;

public abstract class Taak {
    private String naam;
    private Melding melding;
    private Tijdstip tijdstip;

    public Taak(String naam) {
        this.naam = naam;
    }

    public void taakControle() throws AWTException {
        if (tijdstip.isNu())
            System.out.println(melding);
    }

    protected String getNaam() {
        return naam;
    }

    protected void setNaam(String naam) {
        this.naam = naam;
    }
}
