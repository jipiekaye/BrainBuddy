package com.jip.BrainBuddy.Taak;
import com.jip.BrainBuddy.Melding;
import com.jip.BrainBuddy.TijdStip;
import java.awt.*;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Scanner;

public class DagelijkseTaak extends Taak{
    private ArrayList<TijdStip> tijdStippen;
    private ArrayList<DayOfWeek> dagen;
    private Melding melding;

    public DagelijkseTaak (String naam, ArrayList<TijdStip> tijdstippen, String melding) {
        super(naam);
        this.tijdStippen = tijdstippen;
        this.melding = new Melding(melding);
    }

    public DagelijkseTaak (){
        super("nieuweTaak");
        ArrayList<TijdStip> tijdStippen = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Geef de naam van uw taak: ");
        setNaam(scanner.nextLine());
        System.out.print("Melding: ");
        this.melding = new Melding(scanner.nextLine());

       // System.out.print("geef de dagen dat uw taak uitgevoerd moet worden: ");//
        System.out.print("Op welk tijdstip wilt u de melding ontvangen: (hh:mm:ss)");

        String antwoord;
            do {
                antwoord = scanner.nextLine();
                if (!antwoord.equals("0")){
                    tijdStippen.add(new TijdStip(antwoord));
                System.out.print("voer nog een tijdstip in of voer \"0\" in:");
                }
            } while (!antwoord.equals("0"));
            this.tijdStippen = tijdStippen;
    }


    public void taakControle() throws AWTException {
        for (TijdStip inhoud: tijdStippen) {
            if (inhoud.isNu()) {
                System.out.println(melding);
                melding.windowsMelding();
            }
        }
    }

    @Override
    public String toString() {
        return "Dagelijkse taak: " + super.getNaam();
    }
}