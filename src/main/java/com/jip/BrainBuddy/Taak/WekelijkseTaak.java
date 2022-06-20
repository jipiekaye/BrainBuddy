package com.jip.BrainBuddy.Taak;

import com.jip.BrainBuddy.Tijdstip;

import java.time.DayOfWeek;
import java.util.ArrayList;

public class WekelijkseTaak extends Taak {
    private ArrayList<Tijdstip> tijdstippen;
    private ArrayList<DayOfWeek> dagen;

    public WekelijkseTaak(String naam, ArrayList<Tijdstip> tijdstippen, ArrayList<DayOfWeek> dagen) {
        super(naam);
        this.tijdstippen = tijdstippen;
        this.dagen = dagen;
    }
}
