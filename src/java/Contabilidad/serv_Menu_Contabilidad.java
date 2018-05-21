/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contabilidad;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Steven
 */
@WebServlet(name = "serv_Menu_Contabilidad", urlPatterns = {"/serv_Menu_Contabilidad"})
public class serv_Menu_Contabilidad extends HttpServlet {

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

        if (is_boton != null && is_boton != "") {
            
            if(is_boton.equals("Tipo Cuenta"))
            {
                is_pantalla = desplegarPantallaMenu() + ("<p style=\"color: #F6DAD4\">Tipo Cuenta</p>");
            }
            if(is_boton.equals("Cuenta"))
            {
                is_pantalla = desplegarPantallaMenu() + ("<p style=\"color: #F6DAD4\">Cuenta</p>");
            }
            if(is_boton.equals("Comprobante"))
            {
                is_pantalla = desplegarPantallaMenu() + ("<p style=\"color: #F6DAD4\">Comprobante</p>");
            }
            if(is_boton.equals("Reportes"))
            {
                is_pantalla = desplegarPantallaMenu() + ("<p style=\"color: #F6DAD4\">Reportes</p>");
            }
            if(is_boton.equals("Regresar"))
            {
                is_pantalla = desplegarPantallaMenu() + ("<p style=\"color: #F6DAD4\">Regresar</p>");
            }
        }
        out.println(is_pantalla);
    }
    public String desplegarPantallaMenu() {
        String ls_pantalla = "";
        ls_pantalla += ("<!DOCTYPE html>");
        ls_pantalla += ("<html>");
        ls_pantalla += ("<head>");
        ls_pantalla += ("<title>Servlet serv_Menu_Contabilidad</title>");
        ls_pantalla += "<style type='text/css'>";
        ls_pantalla += "";//Aqui va el css
        ls_pantalla += "</style>";
        ls_pantalla += ("</head>");
        ls_pantalla += ("<body>");
        ls_pantalla += ("<form action='serv_Menu_Contabilidad' method='post'>");
        ls_pantalla += "<div class='container'>";
        ls_pantalla += "<h1>Menú</h1>";
        ls_pantalla += "<li>";
        ls_pantalla += "<input type='submit' name='boton' value='Tipo Cuenta'></input>";
        ls_pantalla += "</li>";
        ls_pantalla += "<li>";
        ls_pantalla += "<input type='submit' name='boton' value='Cuenta'></input>";
        ls_pantalla += "</li>";
        ls_pantalla += "<li>";
        ls_pantalla += "<input type='submit' name='boton' value='Comprobante'></input>";
        ls_pantalla += "</li>";
        ls_pantalla += "<li>";
        ls_pantalla += ("<input type='submit' value='Reportes' name='boton' ></input>");
        ls_pantalla += "</li>";
        ls_pantalla += "<li>";
        ls_pantalla += ("<input type='submit' value='Regresar' name='boton' ></input>");
        ls_pantalla += "</li>";
        ls_pantalla += "</div>";
        ls_pantalla += "</form>";
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
