package com.jip.BrainBuddy.Taak;

import com.jip.BrainBuddy.Melding;

public abstract class Taak {
    private String naam;
    private Melding melding;

    public Taak(String naam) {
        this.naam = naam;
    }

    @Override
    public String toString() {
        return "Taak{" +
                "naam='" + naam + '\'' +
                ", melding=" + melding +
                '}';
    }
}
