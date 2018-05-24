/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JONATHAN
 */
@WebServlet(name = "serv_Menu_Biblioteca", urlPatterns = {"/serv_Menu_Biblioteca"})
public class serv_Menu_Biblioteca extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        String is_pantalla = "";
        String is_boton = "";
        is_boton = request.getParameter("boton");

        if (is_boton == null || is_boton == "") {
            is_pantalla = desplegarPantallaMenu();
        }
        out.println(is_pantalla);
    }

    public String desplegarPantallaMenu() {
        String ls_pantalla = "";
        ls_pantalla += ("<!DOCTYPE html>");
        ls_pantalla += ("<html>");
        ls_pantalla += ("<head>");
        ls_pantalla += ("<title>Servlet serv_Menu_Contabilidad</title>");
        ls_pantalla += "<link rel='stylesheet' type='text/css' href='estilos1.css'>";
        ls_pantalla += "</style>";
        ls_pantalla += ("</head>");
        ls_pantalla += ("<body>");
        ls_pantalla += ("<div action='serv_Menu_Biblioteca' method='post'>");
        ls_pantalla += "<center><div class='container'>";
        ls_pantalla += "<h1>Menú</h1>";
        ls_pantalla += "<table width='25%' border='0' align='center'>";
        ls_pantalla += "<tr align='center'>";
        ls_pantalla += "<td><a href='http://localhost:8080/proyecto_distribuidas/serv_autor'><input type='submit' name='boton' value='Lista Autores'></a>";
        ls_pantalla += "</td></tr>";
        ls_pantalla += "<tr align='center'>";
        ls_pantalla += "<td><a href='http://localhost:8080/proyecto_distribuidas/serv_crud_libros'><input type='submit' name='boton' value='Lista Libros'></a>";
        ls_pantalla += "</td></tr>";
        ls_pantalla += "<tr align='center'>";
        ls_pantalla += "<td><input type='submit' name='boton' value='Prestamo'></input>";
        ls_pantalla += "</td></tr>";
        ls_pantalla += "<tr align='center'>";
        ls_pantalla += "<td><input type='submit' value='Reportes' name='boton' ></input>";
        ls_pantalla += "</td></tr>";
        ls_pantalla += "<tr align='center'>";
        ls_pantalla += "<td><a href='http://localhost:8080/proyecto_distribuidas/serv_menu'><input type='submit' value='Regresar' name='boton' ></input>";
        ls_pantalla += "</td></tr>";
        ls_pantalla += "</center></div>";
        ls_pantalla += "</div>";
        ls_pantalla += ("</body>");
        ls_pantalla += ("</html>");
        return ls_pantalla;

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
        processRequest(request, response);
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
