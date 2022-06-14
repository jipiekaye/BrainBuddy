package com.jip.BrainBuddy.Taak;

public class ConstanteTaak extends Taak {
    private Integer minimaleWaarde;
    private Integer maximaleWaarde;
    private Integer huidigeWaarde;

    public ConstanteTaak(String naam, Integer minimaleWaarde, Integer maximaleWaarde, Integer huidigeWaarde) {
        super(naam);
        this.minimaleWaarde = minimaleWaarde;
        this.maximaleWaarde = maximaleWaarde;
        this.huidigeWaarde = huidigeWaarde;
    }
}
