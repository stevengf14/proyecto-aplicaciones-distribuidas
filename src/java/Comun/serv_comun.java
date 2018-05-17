/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comun;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "serv_comun", urlPatterns = {"/serv_comun"})
public class serv_comun extends HttpServlet {

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
        //try (PrintWriter out = response.getWriter()) {
        String is_pantalla = "";
        
        String is_boton = "";
        is_boton = request.getParameter("boton");
        
        if (is_boton == null || is_boton == "") {
            is_pantalla = desplegarPantallaMenu();
        }

        if (is_boton != null && is_boton != "") {
            if (is_boton.equals("Insertar")) {
                is_pantalla = desplegarPantallaUsuarios();
            }

            //Create Employee1 Entity
            //Store Employees
        }
        //is_pantalla += ls_mensaje;
        out.println(is_pantalla);
    }
    
    public String desplegarPantallaMenu()
    {
        String ls_pantalla = "";
        ls_pantalla += ("<!DOCTYPE html>");
        ls_pantalla += ("<html>");
        ls_pantalla += ("<head>");
        ls_pantalla += ("<title>Servlet serv_comun</title>");
        ls_pantalla += ("</head>");
        ls_pantalla += ("<body>");
        //ls_pantalla+=("<h1>Servlet servlet_relaciones at " + request.getContextPath() + "</h1>");
        ls_pantalla += ("<form action='serv_comun' method='post'>");
        /*ls_pantalla += ("Nombre:<input type='text' name='nombre'" + " value='" + ls_nombre + "'></input>");
        ls_pantalla += ("<br>");
        ls_pantalla += ("Salario:<input type='text' name='salario'" + " value='" + ls_salario + "'></input>");
        ls_pantalla += ("<br>");
        ls_pantalla += ("Ocupación:<input type='text' name='dig'" + " value='" + ls_dig + "'></input>");
        ls_pantalla += ("<br>");*/

        ls_pantalla += ("<input type='submit' value='Insertar' name='boton' ></input>");
        ls_pantalla += "</form>";
        ls_pantalla += ("</body>");
        ls_pantalla += ("</html>");
        return ls_pantalla;
        
    }
    /*public String desplegarPantallaMenu()
    {
        String ls_pantalla = "";
        ls_pantalla += ("<!DOCTYPE html>");
        ls_pantalla += ("<html>");
        ls_pantalla += ("<head>");
        ls_pantalla += ("<title>Servlet serv_comun</title>");
        ls_pantalla += ("</head>");
        ls_pantalla += ("<body>");
        ls_pantalla += ("<form action='serv_comun' method='post'>");
        ls_pantalla+="<div class="'wrapper'"><div class="'container'">Welcome</h1><form class="'form'"><input type="'text'" placeholder="'Username'"><input type="'password'" placeholder="'Password'"><button type=\"submit\" id=\"login-button\">Login</button></form></div><ul class=\"bg-bubbles\"><li></li><li></li><li></li><li></li><li></li><li></li><li></li><li></li><li></li><li></li></ul></div>";
        ls_pantalla += "</form>";
        ls_pantalla += ("</body>");
        ls_pantalla += ("</html>");
        return ls_pantalla;
              
    }*/
    public String desplegarPantallaUsuarios()
    {
        String ls_pantalla = "",ls_nombre="",ls_salario="",ls_dig="";
        ls_pantalla += ("<!DOCTYPE html>");
        ls_pantalla += ("<html>");
        ls_pantalla += ("<head>");
        ls_pantalla += ("<title>Servlet serv_comun</title>");
        ls_pantalla += ("</head>");
        ls_pantalla += ("<body>");
        //ls_pantalla+=("<h1>Servlet servlet_relaciones at " + request.getContextPath() + "</h1>");
        ls_pantalla += ("<form action='serv_comun' method='post'>");
        ls_pantalla += ("Nombre:<input type='text' name='nombre'" + " value='" + ls_nombre + "'></input>");
        ls_pantalla += ("<br>");
        ls_pantalla += ("Salario:<input type='text' name='salario'" + " value='" + ls_salario + "'></input>");
        ls_pantalla += ("<br>");
        ls_pantalla += ("Ocupación:<input type='text' name='dig'" + " value='" + ls_dig + "'></input>");
        ls_pantalla += ("<br>");

        ls_pantalla += ("<input type='submit' value='Insertar' name='boton' ></input>");
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
