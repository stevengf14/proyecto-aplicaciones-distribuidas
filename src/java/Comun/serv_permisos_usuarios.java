/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comun;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Steven
 */
@WebServlet(name = "serv_permisos_usuarios", urlPatterns = {"/serv_permisos_usuarios"})
public class serv_permisos_usuarios extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String ls_mensaje = "";

    @EJB
    Bean_PermisosLocal bean_permisos;
            
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //try (PrintWriter out = response.getWriter()) {
        String is_pantalla = "";

        String is_boton = "";
        
        is_boton = request.getParameter("boton");

        if (is_boton == null || is_boton == "") {
            is_pantalla = desplegarPantallaUsuarios();
        }

        if (is_boton != null && is_boton != "") {
            if (is_boton.equals("Guardar")) {
                ls_mensaje=bean_permisos.asignar_permiso(request.getParameter("check_cont"),request.getParameter("check_biblioteca"), request.getParameter("check_nomina"), request.getParameter("check_usuarios"));
                
            }
                is_pantalla = desplegarPantallaUsuarios() + ls_mensaje;
            }

        
        out.println(is_pantalla);
    }
    
    public String desplegarPantallaUsuarios() {
        String ls_pantalla = "";
        ls_pantalla += ("<!DOCTYPE html>");
        ls_pantalla += ("<html>");
        ls_pantalla += ("<head>");
        ls_pantalla += ("<title>Servlet serv_permisos_usuarios</title>");
        ls_pantalla += ("</head>");
        ls_pantalla += ("<body>");
        ls_pantalla += ("<h1>Permisos de Usuarios</h1>");
        ls_pantalla += ("<form action='serv_permisos_usuarios' method='post'>");
        ls_pantalla += ("Seleccione usuario:</br>");
        ls_pantalla += ("<select>");
        for(int i=0;i<5;i++)
        {
            ls_pantalla += ("<option value="+i+">"+i+"</option>");
        }
        ls_pantalla += ("</select>");
        ls_pantalla += ("</br>");
        ls_pantalla += ("<input type='checkbox' name='check_cont' id='contabilidad' value='contabilidad'>Contabilidad</input><br>");
        ls_pantalla += ("<input type='checkbox' name='check_biblioteca' id='biblioteca' value='biblioteca'>Biblioteca</input><br>");
        ls_pantalla += ("<input type='checkbox' name='check_nomina' id='nomina' value='nomina'>Nómina</input><br>");
        ls_pantalla += ("<input type='checkbox' name='check_usuarios' id='nomina' value='usuarios'>Usuarios</input><br>");
        ls_pantalla += ("<input type='submit' value='Guardar' name='boton' ></input>");
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
