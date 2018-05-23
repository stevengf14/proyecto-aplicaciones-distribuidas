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
@WebServlet(name = "serv_crud_libros", urlPatterns = {"/serv_crud_libros"})
public class serv_crud_libros extends HttpServlet {

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
        is_pantalla = desplegar_pantalla("", "", "", "3");
        out.println(is_pantalla);
    }

    public String desplegar_pantalla(String isbn, String titulo, String autor, String valor_prestamo) {
        String ls_pantalla = "";
        ls_pantalla += "<!DOCTYPE html>";
        ls_pantalla += "<html>";
        ls_pantalla += "<head>";
        ls_pantalla += "<title>Servlet serv_menu_biblioteca</title>";
        ls_pantalla += "</head>";

        ls_pantalla += "<body onload='addRow()'>";
        ls_pantalla += "<form action='serv_autores' method='post'>";
        ls_pantalla += "<h1>Tabla de Autores</h1>";
        ls_pantalla += "<header>";
        ls_pantalla += "<nav>";
        ls_pantalla += "<ul>";
        ls_pantalla += "<li><a href='#'>Inicio</a></li>";
        ls_pantalla += "<li><a href='#'>Autores</a></li>";
        ls_pantalla += "<li><a href='#'>Libros</a></li>";
        ls_pantalla += "<li><a href='#'>Prestamos</a></li>";
        ls_pantalla += "<li><a href='#'>Regresar al menu principal</a></li>";
        ls_pantalla += "</ul>";
        ls_pantalla += "</nav>";
        ls_pantalla += "</header>";
        ls_pantalla += "<table width='25%' border='0' align='center'>";
        ls_pantalla += "<tr>";
        ls_pantalla += "<td>Código del libro</td>";
        ls_pantalla += "<td><label for='isbn'></label>";
        ls_pantalla += "<input type='text' name='isbn' id='isbn' value='" + isbn + "'>" + isbn + "</td>";
        ls_pantalla += "</tr>";
        ls_pantalla += "<tr>";
        ls_pantalla += "<td>Tituto del Libro</td>";
        ls_pantalla += "<td><label for='titulo'></label>";
        ls_pantalla += "<input type='text' name='titulo' id='titulo' class='centrado' value='" + titulo + "'></td>";
        ls_pantalla += "</tr>";
        ls_pantalla += "<tr>";
        ls_pantalla += "<td>Autor del libro</td>";
        ls_pantalla += "<td><label for='autor'></label>";
        ls_pantalla += "<input type='text' name='autor' id='autor' class='centrado' value='" + autor + "'></td>";
        ls_pantalla += "</tr>";
        ls_pantalla += "<tr>";
        ls_pantalla += "<td>Valor Prestamo</td>";
        ls_pantalla += "<td><label for='valor_prestamo'></label>";
        ls_pantalla += "<input type='text' name='valor_prestamo' id='valor_prestamo' class='centrado' value='" + valor_prestamo + "'></td>";
        ls_pantalla += "</tr>";
        ls_pantalla += "<tr>";
        ls_pantalla += "<td><br><br></td>";
        ls_pantalla += "<td colspan='1'><input type='submit' name='bot_buscar' id='bot_actualizar' value='Buscar'></td>";
        ls_pantalla += "<td colspan='1'><input type='submit' name='bot_actualizar' id='bot_actualizar' value='Actualizar'></td>";
        ls_pantalla += "</tr>";
        ls_pantalla += "</table>";
        ls_pantalla += "</form>";
        ls_pantalla += "</body>";
        ls_pantalla += "</html>";
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
