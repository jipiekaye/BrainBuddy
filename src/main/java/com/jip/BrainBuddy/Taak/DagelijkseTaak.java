package com.jip.BrainBuddy.Taak;

import com.jip.BrainBuddy.TijdStip;

import java.time.DayOfWeek;
import java.util.ArrayList;

class DagelijkseTaak extends Taak{
    private ArrayList<TijdStip> tijdstippen;
    private ArrayList<DayOfWeek> dagen;

    public DagelijkseTaak (String naam, ArrayList<TijdStip> tijdstippen, ArrayList<DayOfWeek> dagen) {
        super(naam);
        this.tijdstippen = tijdstippen;
        this.dagen = dagen;
    }
}
