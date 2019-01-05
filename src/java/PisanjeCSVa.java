/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nenad
 */
public class PisanjeCSVa {

    public static final String zarez = ",";
    public static final String noviRed = "\n";

    public static void upisiCSV(String fileName) {

        Osoba prva = new Osoba(1, "Nenad", "Paunov", LocalDate.of(1990, 11, 26), "zelena");
        Osoba druga = new Osoba(2, "Nenad", "Siler", LocalDate.of(1990, 10, 11), "crna");
        Osoba treca = new Osoba(3, "Anja", "Nikolic", LocalDate.of(1995, 12, 12), "roza");
        Osoba cetvrta = new Osoba(4, "Zoran", "Lekic", LocalDate.of(1986, 1, 8), "plava");
        Osoba peta = new Osoba(5, "Dajana", "Komarov", LocalDate.of(1994, 6, 18), "zuta");
        Osoba sesta = new Osoba(6, "Mira", "Fink", LocalDate.of(1992, 2, 28), "crvena");
        Osoba sedma = new Osoba(7, "Petar", "Bojovic", LocalDate.of(1996, 4, 3), "braon");
        Osoba osma = new Osoba(8, "Jasna", "Komaric", LocalDate.of(1977, 6, 18), "siva");
        Osoba deveta = new Osoba(9, "Milos", "Aleksej", LocalDate.of(1926, 6, 18), "crna");
        Osoba deseta = new Osoba(10, "Milica", "Jaksic", LocalDate.of(2003, 8, 18), "plava");

        List<Osoba> lista = new ArrayList();
        lista.add(prva);
        lista.add(druga);
        lista.add(treca);
        lista.add(cetvrta);
        lista.add(peta);
        lista.add(sesta);
        lista.add(sedma);
        lista.add(osma);
        lista.add(deveta);
        lista.add(deseta);

        FileWriter file = null;
        try {
            file = new FileWriter(fileName);
            for (Iterator<Osoba> it = lista.iterator(); it.hasNext();) {
                Osoba osoba = it.next();
                file.append(String.valueOf(osoba.getId()));
                file.append(zarez);
                file.append(osoba.getIme());
                file.append(zarez);
                file.append(osoba.getPrezime());
                file.append(zarez);
                file.append(osoba.getDatumRodjenja().toString());
                file.append(zarez);
                file.append(osoba.getOmiljenaBoja());
                file.append(noviRed);
            }
        } catch (IOException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        try {
            file.flush();
            file.close();
        } catch (Exception e) {
            e.getStackTrace();
        }

    }
}
