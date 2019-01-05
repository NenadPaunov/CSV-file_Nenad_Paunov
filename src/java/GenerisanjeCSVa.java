/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nenad
 */
public class GenerisanjeCSVa {
public static final String zarez=",";
public static final String noviRed="\n";

public static void generisanje(String fileName){
    FileWriter file=null;
    Random random=new Random();
    int randomIme=0;
    int randomPrezime=0;
    int randomMeseci=0;
    int randomDani=0;
    int randomGodine=0;
    int randomBoja=0;
    //45 imena
    String[] imena={"Avram","Agaton","Adam","Aksa","Aleksa","Aleksandar","Aca","Alimpije","Andrej","Andra","Andronik","Andjelko",
        "Antonije","Anto","Arandjel","Arsenije","Arsa","Atanas","Acim","Ana","Anja","Anka","Ankica","Antonina","Andjela","Bojan","Bojana",
        "Boris","Milica","Dunja","Jovan","Joca","Nenad","Jelica","Vera","Borivoje","Nikola","Nemanja","Petar","Sanja","Lenka","Olgica","Dajana","Zoran","Kristina"};
    //33 prezimena
    String[] prezimena={"Babac","Babalj","Babarogic","Babic","Babin","Babovic","Babuskov","Bacanin","Bacetic","Milekic","Milenic",
        "Milenkovic","Milenov","Milenovic","Milentijevic","Milesev","Milesevic","Milesic","Milutinov","Silbaski","Siljegovic","Siljkovic",
        "Siljanovic","Simakic","Simanic","Simeunovic","Simcic","Vujic","Paunov","Grujic","Siler","Lekic","Bojovic"};
    //30 boja
    String[] boje={"Ametist","Bela","Bez","Bistr","Bronzana","Burgundska","Jorgovan","Denim","Zad","Zuta","Zutozelena","Zelena","Zlatna",
        "Indigoplava","Kajsija","Kaki","Kardenal","Koralna","Krem","Lavanda","Lila","Ljubicasta","Maslinasta","Modra","Narandzasta",""
            + "Plava","Crvena","Oker","Purpurna","Siva"};
    try {
        file=new FileWriter(fileName);
        //Generisanje 1000 redova u CSV fajlu pocesvi od 1 do 1000
        for (int i = 1; i < 1001; i++) {
        //Id koji predstavlja primarni kljuc tabele dobija vrednost od brojaca(i)
        file.append(Integer.toString(i));
        file.append(zarez);
        //Nasumicno biranje imena iz niza Stringova imena
        randomIme=random.nextInt(imena.length);
        file.append(imena[randomIme]);
        file.append(zarez);
        //Nasumicno biranje prezimena iz niza Stringova prezimena
        randomPrezime=random.nextInt(prezimena.length);
        file.append(prezimena[randomPrezime]);
        file.append(zarez);
        //Nasumicno biranje godine rodjenja, gde su meseci od 1 do 12, dan izabran shodno mesecu i nasumicna godina od 1950 do 2000
        randomMeseci=random.nextInt(12)+1;
        if(randomMeseci==1){
            randomDani=random.nextInt(31)+1;
        }
        else if(randomMeseci==2){
            randomDani=random.nextInt(28)+1;
        }
         else if(randomMeseci==3){
            randomDani=random.nextInt(31)+1;
        }
         else if(randomMeseci==4){
            randomDani=random.nextInt(30)+1;
        }
         else if(randomMeseci==5){
            randomDani=random.nextInt(31)+1;
        }
         else if(randomMeseci==6){
            randomDani=random.nextInt(30)+1;
        }
         else if(randomMeseci==7){
            randomDani=random.nextInt(31)+1;
        }
         else if(randomMeseci==8){
            randomDani=random.nextInt(31)+1;
        }
         else if(randomMeseci==9){
            randomDani=random.nextInt(30)+1;
        }
         else if(randomMeseci==10){
            randomDani=random.nextInt(31)+1;
        }
         else if(randomMeseci==11){
            randomDani=random.nextInt(30)+1;
        }
         else {
            randomDani=random.nextInt(31)+1;
        }
        randomGodine=random.nextInt((2000-1950)+1)+1950;
        
        String mesec="0";
        String dan="0";
        
        if(randomMeseci<10){
            mesec+=randomMeseci;
        }else{
                    mesec=Integer.toString(randomMeseci);
                    }       
        if(randomDani<10){
            dan+=randomDani;
        }else{
            dan=Integer.toString(randomDani);
        }    
       
        file.append(Integer.toString(randomGodine)+"-"+mesec+"-"+dan);
        file.append(zarez);
        //Nasumican izbor omiljene boje iz niza Stringova boje.
        randomBoja=random.nextInt(boje.length);
        file.append(boje[randomBoja]);
        //Zapocinjanje novog reda u CSV fajlu
        file.append(noviRed);
     
        }
   
    } catch (IOException ex) {
        System.out.println(ex.getLocalizedMessage());;
    }
    finally {
        try {
            file.flush();
            file.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
       
        }
    
}
    public static void main(String[] args) {
        //Generisanje CSV fajla.
        String fileName1 = System.getProperty("user.home") + "/"+args[0]+".csv";
        generisanje(fileName1);
        System.out.println("Fajl uspesno kreiran pod nazivom "+args[0]);
    }
}
