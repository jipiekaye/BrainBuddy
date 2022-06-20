package com.jip.BrainBuddy;

import com.jip.BrainBuddy.Taak.DagelijkseTaak;
import com.jip.BrainBuddy.Taak.Taak;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Gebruiker {
    static ArrayList<Taak> Taken = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    private static boolean exit = false;

    public static void main(String[] args) throws InterruptedException {
        Gebruiker gebruiker = new Gebruiker();
        // initializeer multithreading zodat meldingen kunnen worden weergeven terwijl een menu draait in de terminal
        final ExecutorService pool = Executors.newFixedThreadPool(2);

        //thread klok gaat lopen
        pool.execute(() -> {
            try {
                gebruiker.doKlok();
            } catch (AWTException e) {
                e.printStackTrace();
            }
        });

        //thread menu gaat lopen
        pool.execute(gebruiker::menu);

        pool.shutdown();

        if (pool.awaitTermination(1, TimeUnit.MINUTES)) {
            System.err.println("Programma is niet afgesloten.");
        }
    }

    private void doKlok() throws AWTException {
        String lastTime = null;
        while (!exit) {
            Klok klok = new Klok();
            if (lastTime == null)
                lastTime = klok.getTijd();
            if (!lastTime.equals(klok.getTijd())) {
//              System.out.println(klok.getTijd());// use as test in case time breaks
                for (Taak inhoud : Taken) {
                    inhoud.taakControle();
                }
            }
            lastTime = klok.getTijd();
        }
    }

    private void menu() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println();
            System.out.println("1. Configureer Basistaken.");
            System.out.println("2. Overzicht van Taken weergeven.");
            System.out.println("3. Taken aanmaken/verwijderen.");
            System.out.println("4. Zie huidige meldingen.");
            System.out.println("0. Exit");
            System.out.print("Uw keuze: ");

            int optie;
            for (optie = scanner.nextInt(); optie > 8 || optie < 0; optie = scanner.nextInt()) {
                System.out.println("Vul a.u.b. een keuze 0 t/m 8 in.");
            }

            if (optie == 0) {
                exit = true;
            }

            if (optie == 1) {
                initializeerBasistaken();
            }

            if (optie == 2) {
            }

            if (optie == 3) {
                System.out.println("1. Taak aanmaken.");
                System.out.println("2. Taak verwijderen.");
                System.out.println("0. Exit");
                System.out.print("Uw keuze: ");
                int optie2;
                for (optie2 = scanner.nextInt(); optie2 > 2 || optie2 < 0; optie2 = scanner.nextInt()) {
                    System.out.println("Vul a.u.b. een keuze 0 t/m 2 in.");
                }
                if (optie2 == 1) {
                    voegTaakToe();
                }
                if (optie2 == 2) {
                    verwijderTaak();
                }
            }

            if (optie == 4) {
            }

        } while (!exit);
    }

    private static ArrayList<Taak> initializeerBasistaken() {
        ArrayList<Tijdstip> slapen = new ArrayList<>();
        Klok klok = new Klok();
        slapen.add(new Tijdstip(klok.getTijd() + "\b\b" + "59"));
        Taken.add(new DagelijkseTaak("Slapen", slapen, "Het is bedtijd !"));
        return Taken;
    }

    private void voegTaakToe() {
        System.out.println("1. Dagelijkse taak aanmaken");
 //       System.out.println("2. Wekelijkse taak aanmaken");//
 //       System.out.println("3. Maandelijkse taak aanmaken");//
        System.out.print("Uw keuze: ");
        if (scanner.nextInt() == 1)
            Taken.add(new DagelijkseTaak());

    }

    private void verwijderTaak() {
        if (!Taken.isEmpty()) {
            System.out.println("welke taak wilt u verwijderen?");
            int i = 1;
            for (Taak inhoud : Taken) {
                System.out.println(i + ") " + inhoud);
                i++;
            }
            System.out.print("1-" + i + ": ");
            Taken.remove(scanner.nextInt() - 1);
        }
        else System.out.println("Er zijn geen taken om te verwijderen.");
    }
}