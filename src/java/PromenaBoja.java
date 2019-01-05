/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nenad
 */
public class PromenaBoja {

    public static void promeniBoje(String fileName, String izlazniFajl) {
        String red = "";
        String odvojiRed = ",";
        String noviRed = "\n";
        FileWriter file = null;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            file = new FileWriter(izlazniFajl);
            //Sve dok red nije prazan petlja se vrti
            while ((red = br.readLine()) != null) {

                // Zarez sluzi da odvoji kolone u redovima
                String[] kolone = red.split(odvojiRed);
                ////Uzimanje vrednosti pojedinacnih kolona i njihovo upisivanje u novi CSV fajl
                file.append(kolone[0]);
                file.append(odvojiRed);
                file.append(kolone[1]);
                file.append(odvojiRed);
                file.append(kolone[2]);
                file.append(odvojiRed);
                file.append(kolone[3]);
                file.append(odvojiRed);
                //Ukoliko je boja osnovna, samo je upisuje u novi CSV fajl
                if ((kolone[4].equalsIgnoreCase("crvena")) || (kolone[4].equalsIgnoreCase("zuta"))
                        || (kolone[4].equalsIgnoreCase("plava"))) {
                    file.append(kolone[4]);
                    //Ukoliko neka od boja nije osnovna, nasumicnim odabirom se menja u jednu od njih
                } else {
                    String[] osnovne = {"plava", "crvena", "zuta"};
                    Random random = new Random();
                    int randomBroj = random.nextInt(osnovne.length);
                    file.append(osnovne[randomBroj]);

                }
                //Zapocinjanje novog reda u CSV fajlu
                file.append(noviRed);
            }

        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        } finally {
            try {
                file.flush();
                file.close();
            } catch (IOException ex) {
                System.out.println(ex.getLocalizedMessage());
            }

        }

    }
    public static void main(String[] args) {
        //Promena boja preko cmd-a.
        promeniBoje(System.getProperty("user.home") + "/"+args[0]+".csv", System.getProperty("user.home") + "/"+args[1]+".csv");
        System.out.println("Kreiran je novi fajl pod nazivom "+args[1]+" sa promenjenim omiljenim bojama u osnovne.");
    }

}
