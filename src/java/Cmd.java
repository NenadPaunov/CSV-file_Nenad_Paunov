
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nenad
 */
public class Cmd {

    public static void main(String[] args) {
        //Klasa iz koje se pozivaju sledece metode iz cmd-a: generisanje CSV fajla, sortiranje po datumu i promena boja.
        String fileName1 = System.getProperty("user.home") + "/" + args[0] + ".csv";
        GenerisanjeCSVa.generisanje(fileName1);
        System.out.println("Fajl uspesno kreiran pod nazivom " + args[0]);
        System.out.println("Sortiranje datuma");
        if (args.length < 4) {
            SortiranjeDatuma.sortirajPoDatumima(System.getProperty("user.home") + "/" + args[0] + ".csv", System.getProperty("user.home") + "/" + args[1] + ".csv", null);
            System.out.println("Sortiran je i kreiran novi CSV fajl pod nazivom " + args[1] + " sa 1000 osoba");
            PromenaBoja.promeniBoje(System.getProperty("user.home") + "/" + args[1] + ".csv", System.getProperty("user.home") + "/" + args[2] + ".csv");
            System.out.println("Kreiran je novi fajl pod nazivom " + args[2] + " sa promenjenim omiljenim bojama u osnovne.");

        } else {
            SortiranjeDatuma.sortirajPoDatumima(System.getProperty("user.home") + "/" + args[0] + ".csv", System.getProperty("user.home") + "/" + args[1] + ".csv", args[2]);
            System.out.println("Sortiran je i kreiran novi CSV fajl pod nazivom " + args[1] + " sa " + args[2] + " osoba");
            PromenaBoja.promeniBoje(System.getProperty("user.home") + "/" + args[1] + ".csv", System.getProperty("user.home") + "/" + args[3] + ".csv");
            System.out.println("Kreiran je novi fajl pod nazivom " + args[3] + " sa promenjenim omiljenim bojama u osnovne.");
        }

    }

}
