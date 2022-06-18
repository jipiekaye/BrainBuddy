package com.jip.BrainBuddy;

import java.awt.*;
import java.awt.TrayIcon.MessageType;

public class Melding {
    private String melding;

    public Melding(String melding){
        this.melding = melding;
    }

    public String toString() {
        return "-----\n" + melding + "\n-----";
    }

    public void windowsMelding() throws AWTException {
        if (SystemTray.isSupported()) {
            Melding td = new Melding(melding);
            td.displayTray();
        } else {
            System.err.println("System tray not supported!");
        }
    }
    private void displayTray() throws AWTException {
        //Obtain only one instance of the SystemTray object
        SystemTray tray = SystemTray.getSystemTray();

        //als icon.png bestaat
        Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
        //alternatief (if the icon is on the classpath):
        //Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png"));

        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
        //resizes icon.png als het nodig is

        trayIcon.setImageAutoSize(true);
        //Set tooltip text for the tray icon
        trayIcon.setToolTip("System tray icon demo");
        tray.add(trayIcon);
        trayIcon.displayMessage(toString(), "MELDING", MessageType.INFO);
    }
}