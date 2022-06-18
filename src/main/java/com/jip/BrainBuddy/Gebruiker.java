package com.jip.BrainBuddy;

import com.jip.BrainBuddy.Taak.DagelijkseTaak;
import com.jip.BrainBuddy.Taak.Taak;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Gebruiker {
    static ArrayList<Taak> Taken = new ArrayList<>();

    public static boolean exit = false;

    public static void main(String[]args){
        initializeerBasistaken();
        final ExecutorService pool = Executors.newFixedThreadPool(2);

        pool.execute(() -> {

            try {
                doKlok();
            } catch (AWTException e) {
                e.printStackTrace();
            }
        });

        pool.shutdown();
    }

    private static void doKlok() throws AWTException {
        String lastTime = null;
        while (!exit) {
            Klok klok = new Klok();
            if (lastTime == null)
                lastTime = klok.getTijd();
            if (!lastTime.equals(klok.getTijd())) {
                System.out.println(klok.getTijd());
                for (Taak inhoud:Taken) {
                    inhoud.taakControle();
                }
            }
            lastTime= klok.getTijd();
        }
    }

    private static void menu() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("1. Configureer Basistaken.");
            System.out.println("2. Overzicht van Taken weergeven.");
            System.out.println("3. Taken aanmaken/verwijderen.");
            System.out.println("4. Zie huidige meldingen.");
            System.out.println("0. Exit");
            System.out.println("Your choice:");

            int optie;
            for(optie = scanner.nextInt(); optie > 8 || optie < 0; optie = scanner.nextInt()) {
                System.out.println("Vul a.u.b. een keuze 0 t/m 8 in.");
            }

            if (optie == 0) {
                exit = true;
            }

            if (optie == 1) {
            }

            if (optie == 2) {
            }

            if (optie == 3) {
            }

            if (optie == 4) {
            }

        } while(!exit);
    }

    public static void initializeerBasistaken(){
        ArrayList<TijdStip> takeMedTijd = new ArrayList<>();
        takeMedTijd.add(new TijdStip("14:25:00"));
        takeMedTijd.add(new TijdStip("14:25:10"));
        takeMedTijd.add(new TijdStip("14:24:50"));
        Taken.add(new DagelijkseTaak("takeMed", takeMedTijd,"Medicatie moet ingenomen worden"));
    }
}