package com.jip.BrainBuddy.Taak;
import com.jip.BrainBuddy.Melding;
import com.jip.BrainBuddy.TijdStip;
import java.awt.*;
import java.time.DayOfWeek;
import java.util.ArrayList;

public class DagelijkseTaak extends Taak{
    private ArrayList<TijdStip> tijdstippen;
    private ArrayList<DayOfWeek> dagen;
    private Melding melding;

    public DagelijkseTaak (String naam, ArrayList<TijdStip> tijdstippen, String melding) {
        super(naam);
        this.tijdstippen = tijdstippen;
        this.melding = new Melding(melding);
    }
    public void taakControle() throws AWTException {
        for (TijdStip inhoud:tijdstippen) {
            if (inhoud.isNu()) {
                System.out.println(melding);
                melding.windowsMelding();
            }
        }
    }
}