/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaKlase;

import java.time.LocalDate;

/**
 *
 * @author Nenad
 */
public class Osoba {
private int id;
private String ime;
private String prezime;
private LocalDate datumRodjenja;
private String omiljenaBoja;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public LocalDate getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getOmiljenaBoja() {
        return omiljenaBoja;
    }

    public void setOmiljenaBoja(String omiljenaBoja) {
        this.omiljenaBoja = omiljenaBoja;
    }

    public Osoba(int id, String ime, String prezime, LocalDate datumRodjenja, String omiljenaBoja) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.omiljenaBoja = omiljenaBoja;
    }
    
}
