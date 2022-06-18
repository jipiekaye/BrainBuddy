package com.jip.BrainBuddy.Taak;

import com.jip.BrainBuddy.Melding;
import com.jip.BrainBuddy.TijdStip;

import java.awt.*;

public abstract class Taak {
    private String naam;
    private Melding melding;
    private TijdStip tijdStip;

    public Taak(String naam) {
        this.naam = naam;
    }


    public void taakControle() throws AWTException {
        if (tijdStip.isNu())
            System.out.println(melding);
    }
}
