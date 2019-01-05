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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SortiranjeDatuma {

    public static void sortirajPoDatumima(String fileName,String izlazniFile,String ns) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            //Sortiranje u opadajucem nizu pomocu metode reverseOrder()
            Map<LocalDate, List<String>> map = new TreeMap<>(Collections.reverseOrder());
            String red = "";
            String odvojiRed = ",";
            int brojac = 0;
            try {
                //Ukoliko je uneta vrednost 0, tada ce se sortirati svi redovi
                if (ns == null) {
                    //Sve dok red nije prazan petlja se vrti
                    while ((red = reader.readLine()) != null) {
                        // Zarez sluzi da odvoji kolone u redovima, dok [3] sluzi da odaberemo koja kolona ce nam biti kljuc
                        //u ovom slucaju datum
                        LocalDate key = LocalDate.parse(red.split(odvojiRed)[3]);
                        //Upisivanje kljuca mape u listu Stringova
                        List<String> lista = map.get(key);                      
                        if (lista == null) {
                            lista = new LinkedList<String>();
                            map.put(key, lista);
                        }
                        lista.add(red);
                    }
                    //Ukoliko je uneti broj(n) veci od nule, tada ce se za vrednost tog broja sortirati redovi
                } else {
                    //Sve dok red nije prazan petlja se vrti
                    int n=Integer.parseInt(ns);
                    while (((red = reader.readLine()) != null) && (brojac < n)) {
                        // Zarez sluzi da odvoji kolone u redovima, dok [3] sluzi da odaberemo koja kolona ce nam biti kljuc
                        //u ovom slucaju datum
                        LocalDate key = LocalDate.parse(red.split(odvojiRed)[3]);
                        //Upisivanje kljuca mape u listu Stringova
                        List<String> lista = map.get(key);
                        if (lista == null) {
                            lista = new LinkedList<String>();                          
                            map.put(key, lista);                           
                        }
                        lista.add(red);
                        brojac++;
                    }
                }
                
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
                //Vrednosti iz mape se pomocu iteratora upisuju u listu stringova
                for (Iterator<List<String>> it = map.values().iterator();
                        it.hasNext();) {
                    List<String> list = it.next();
                    //Stringovi iz liste se upisuju u novi CSV fajl, red po red
                    for (String val : list) {
                        writer.write(val);
                        //Sluzi za odvajanje redova
                        writer.write("\n");
                    }
                }
            writer.close();
        
        } catch (IOException ex) {
            System.out.println(ex.getLocalizedMessage());
        } 
    }   catch (FileNotFoundException ex) {
            Logger.getLogger(SortiranjeDatuma.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    public static void main(String[] args) {
        //Sortiranje datuma preko cmd-a. Ukoliko je dato 2 argumenta tada se novi CSV fajl generise za 1000 osoba
        //, u suprotnom za broj ljudi koji je unesen kao argument.
        System.out.println("Sortiranje datuma");
        if(args.length<3){
        sortirajPoDatumima(System.getProperty("user.home") + "/"+args[0]+".csv",System.getProperty("user.home") + "/"+args[1]+".csv", null);
            System.out.println("Sortiran je i kreiran novi CSV fajl pod nazivom "+args[1]+" sa 1000 osoba");
    }
        else{
            sortirajPoDatumima(System.getProperty("user.home") + "/"+args[0]+".csv",System.getProperty("user.home") + "/"+args[1]+".csv", args[2]);
        System.out.println("Sortiran je i kreiran novi CSV fajl pod nazivom "+args[1]+" sa "+args[2]+" osoba");}
    }
}
