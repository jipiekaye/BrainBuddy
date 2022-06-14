package com.jip.BrainBuddy;

import com.jip.BrainBuddy.Taak.DagelijkseTaak;
import com.jip.BrainBuddy.Taak.Taak;

import java.util.ArrayList;
import java.util.Scanner;

public class Gebruiker {
    private String naam;
    static ArrayList<Taak> Taken = new ArrayList<>();

    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Goedendag, ik ben BrainBuddy." + "\n" + "Wilt u Basistaken aan of uit zetten ?");
        System.out.print("ja/nee:");
        String antwoord = scanner.nextLine();
        if (antwoord.equals("ja")) {
            initializeerBasistaken();
        }
    }

    public static void initializeerBasistaken(){
        ArrayList<TijdStip> takeMedTijd = new ArrayList<>();
        takeMedTijd.add(new TijdStip("1200"));
        Taken.add(new DagelijkseTaak("takeMed", takeMedTijd));
    }
}
