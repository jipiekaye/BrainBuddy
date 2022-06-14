package com.jip.BrainBuddy.Taak;

import com.jip.BrainBuddy.TijdStip;

import java.time.DayOfWeek;

class WekelijkseTaak extends Taak {
    private TijdStip tijdstip;
    private DayOfWeek dag;

    public WekelijkseTaak(String naam, TijdStip tijdstip, DayOfWeek dag) {
        super(naam);
        this.tijdstip = tijdstip;
        this.dag = dag;
    }
}
