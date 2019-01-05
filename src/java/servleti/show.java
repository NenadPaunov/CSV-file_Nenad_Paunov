/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servleti;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nenad
 */
@WebServlet(name = "show", urlPatterns = {"/show"})
public class show extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String odvojiRed = ",";
        String red = "";
        String bojaReda = "";
        String id = "";
        String ime = "";
        String prezime = "";
        String datum = "";
        String omiljenaBoja = "";
        //Odabir fajla koji se prikazuje na HTML strani
        String csv = request.getParameter("upis");
        String fileName3 = System.getProperty("user.home") + "/" + csv + ".csv";
        //Generisanje pocetnih tagova HTML strane i tabele
        out.write("<html>"
                + "<body>"
                + "<center>"
                + "<h3>Generisana tabela CSV fajla pod nazivom <em>" + csv + "</h3>"
                + "<br/>"
                + "<table border ='2'>"
                + "<tr>"
                + "<td>Id</td>"
                + "<td>Ime</td>"
                + "<td>Prezime</td>"
                + "<td>Datum rodjenja</td>"
                + "</tr>");
        try {
            BufferedReader bf = new BufferedReader(new FileReader(fileName3));
            //Sve dok red nije prazan petlja se vrti
            while ((red = bf.readLine()) != null) {
                // Zarez sluzi da odvoji kolone u redovima
                String[] kolone = red.split(odvojiRed);
                //Uzimanje vrednosti pojedinacnih kolona
                id = kolone[0];
                ime = kolone[1];
                prezime = kolone[2];
                datum = kolone[3];
                omiljenaBoja = kolone[4];
                //Na osnovu omiljenje boje, boja reda postaje ta boja
                if (omiljenaBoja.equalsIgnoreCase("plava")) {
                    bojaReda = (" <tr bgcolor=\"#00BFFF\">");
                } else if (omiljenaBoja.equalsIgnoreCase("zuta")) {

                    bojaReda = (" <tr bgcolor=\"#FFFF00\">");
                } else {
                    bojaReda = (" <tr bgcolor=\"#FF0000\">");

                }
                //Ispisivanje vrednosti u redovima u HTML tabeli
                out.write(bojaReda + "<td>");
                out.write(id);
                out.write("</td><td>");
                out.write(ime);
                out.write("</td><td>");
                out.write(prezime);
                out.write("</td><td>");
                out.write(datum);
                out.write(bojaReda + "</tr>");

            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getLocalizedMessage());
        } catch (IOException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        //Zatvaranje HTML tagova
        out.write("</tbody></table></center></body></html>");
        out.close();

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
