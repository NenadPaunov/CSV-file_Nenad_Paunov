/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaKlase;

/**
 *
 * @author Nenad
 */
public class pokretanje {

    public static void main(String[] args) {
        String fileName1 = System.getProperty("user.home") + "/generisane_osobe.csv";
        String fileName2 = System.getProperty("user.home") + "/sortirane_osobe.csv";
        String fileName3 = System.getProperty("user.home") + "/omiljene_boje.csv";
        String fileName4 = System.getProperty("user.home") + "/upisane_osobe.csv";

        //Generisanje CSV fajla za 1000 osoba
        System.out.println("Generisanje CSV fajla:");

        GenerisanjeCSVa.generisanje(fileName1);
        
        //Drugi nacin za generisanje CSV fajla, vrednosti nisu nasumicne
        System.out.println("Pisanje CSV fajla:");

        PisanjeCSVa.upisiCSV(fileName4);

        //Citanje CSV fajla, pomocna metoda
        //System.out.println("Read CSV file:");

        //CitanjeCSVa.procitajCSV(fileName1);

        //Ulazni fajl, broj osoba, izlazni fajl
        System.out.println("Sortiranje fajla po datumima:");

        SortiranjeDatuma.sortirajPoDatumima(fileName1, 10, fileName2);

        //Ulazni fajl, izlazni fajl
        System.out.println("Promena omiljenih boja:");

        PromenaBoja.promeniBoje(fileName2, fileName3);

    }

}
