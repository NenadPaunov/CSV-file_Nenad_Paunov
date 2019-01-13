/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SortiranjeDatuma {

    public static void sortirajPoDatumima(String fileName, String izlazniFile, String ns) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String red = "";
            String odvojiRed = ",";
            String noviRed = "\n";
            int brojac = 0;
            String[] token = null;
            List<Osoba> osobe = new LinkedList();
            try {
                //Ukoliko je uneta vrednost null, tada ce se sortirati svi redovi
                if (ns == null) {
                    //Sve dok red nije prazan petlja se vrti
                    while ((red = reader.readLine()) != null) {
                        token = red.split(odvojiRed);                      
                            Osoba osoba = new Osoba();
                            osoba.setId(Integer.parseInt(token[0]));
                            osoba.setIme(token[1]);
                            osoba.setPrezime(token[2]);
                            osoba.setDatumRodjenja(LocalDate.parse(token[3]));
                            osoba.setOmiljenaBoja(token[4]);
                            osobe.add(osoba);
                    }

                    //Ukoliko je uneti broj(n) veci od nule, tada ce se za vrednost tog broja sortirati redovi
                } else {
                    //Sve dok red nije prazan petlja se vrti

                    int n = Integer.parseInt(ns);

                    while (((red = reader.readLine()) != null) && (brojac < n)) {
                        token = red.split(odvojiRed);
                        Osoba osoba = new Osoba();
                        osoba.setId(Integer.parseInt(token[0]));
                        osoba.setIme(token[1]);
                        osoba.setPrezime(token[2]);
                        osoba.setDatumRodjenja(LocalDate.parse(token[3]));
                        osoba.setOmiljenaBoja(token[4]);
                        osobe.add(osoba);
                        brojac++;

                    }

                }
                //Pozivamo metodu za sortiranje datuma
                Collections.sort(osobe, new Sortiranje());

            } catch (IOException ex) {
                System.out.println(ex.getLocalizedMessage());
            }
            try {
                reader.close();
            } catch (IOException ex) {
                System.out.println(ex.getLocalizedMessage());
            }
            FileWriter writer = null;
            try {
                //Novi CSV fajl
                writer = new FileWriter(izlazniFile);
                for (Osoba osoba : osobe) {
                    writer.append(String.valueOf(osoba.getId()));
                    writer.append(odvojiRed);
                    writer.append(osoba.getIme());
                    writer.append(odvojiRed);
                    writer.append(osoba.getPrezime());
                    writer.append(odvojiRed);
                    writer.append(osoba.getDatumRodjenja().toString());
                    writer.append(odvojiRed);
                    writer.append(osoba.getOmiljenaBoja());
                    writer.append(noviRed);
                }
                writer.close();

            } catch (IOException ex) {
                System.out.println(ex.getLocalizedMessage());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SortiranjeDatuma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        //Sortiranje datuma preko cmd-a. Ukoliko je dato 2 argumenta tada se novi CSV fajl generise za 1000 osoba
        //, u suprotnom za broj ljudi koji je unesen kao argument.
        System.out.println("Sortiranje datuma:");
        if (args.length == 2) {
            sortirajPoDatumima(System.getProperty("user.home") + "/" + args[0] + ".csv", System.getProperty("user.home") + "/" + args[1] + ".csv", null);
            System.out.println("Sortiran je i kreiran novi CSV fajl pod nazivom " + args[1] + " sa 1000 osoba");
        }
        else if (args.length == 3) {
            sortirajPoDatumima(System.getProperty("user.home") + "/" + args[0] + ".csv", System.getProperty("user.home") + "/" + args[1] + ".csv", args[2]);
            System.out.println("Sortiran je i kreiran novi CSV fajl pod nazivom " + args[1] + " sa " + args[2] + " osoba");
        } else {
            System.out.println("Niste uneli dovoljan broj argumenata");
        }
    }
}
