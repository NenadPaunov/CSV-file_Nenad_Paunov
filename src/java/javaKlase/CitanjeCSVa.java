/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaKlase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Nenad
 */
public class CitanjeCSVa {

    public static void procitajCSV(String fileName) {

        String red = "";
        String odvojiRed = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            //Sve dok red nije prazan petlja se vrti
            while ((red = br.readLine()) != null) {

                // Zarez sluzi da odvoji kolone u redovima
                String[] kolone = red.split(odvojiRed);

                System.out.println(kolone[0] + ", " + kolone[1] + ", " + kolone[2] + ", " + kolone[3] + ", " + kolone[4]);

            }

        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }

    }

}
