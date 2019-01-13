
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nenad
 */
public class Sortiranje implements Comparator<Osoba>{

    @Override
    //Metoda pomocu koja sortiramo datume u opadajucem redosledu
    public int compare(Osoba o1, Osoba o2) {
       if(o1.getDatumRodjenja().isBefore(o2.getDatumRodjenja()))
           return 1;
       else if(o1.getDatumRodjenja().isAfter(o2.getDatumRodjenja()))
           return -1;
       else
           return 0;
    }
    
}
