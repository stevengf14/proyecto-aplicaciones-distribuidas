/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comun;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Steven
 */
@WebServlet(name = "serv_usuarios", urlPatterns = {"/serv_usuarios"})
public class serv_usuarios extends HttpServlet {

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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //try (PrintWriter out = response.getWriter()) {
        String is_pantalla = "";

        String is_boton = "";
        String ls_nombres = "";
        String ls_apellidos = "";
        String ls_usuario = "";
        String ls_contrasenia = "";
        String ls_contrasenia2 = "";
        is_boton = request.getParameter("boton");

        if (is_boton == null || is_boton == "") {
            is_pantalla = desplegarPantallaUsuarios("", "", "", "", "");
        }

        if (is_boton != null && is_boton != "") {
            if (is_boton.equals("Insertar")) {
                ls_nombres = request.getParameter("nombres");
                ls_apellidos = request.getParameter("apellidos");
                ls_usuario = request.getParameter("usuario");
                ls_contrasenia = request.getParameter("contrasenia");
                ls_contrasenia2 = request.getParameter("contrasenia2");
                if (!ls_contrasenia.equals(ls_contrasenia2)) {
                    ls_mensaje = "Las contrasenias deben coincidir!";
                } else {
                    /*
                
                
                EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("/*persistencia");
                EntityManager entitymanager = emfactory.createEntityManager();
                try {
                    entitymanager.getTransaction().begin();
                    objeto_usuario usuario = new objeto_usuario();
                    usuario.setNombres(ls_nombres);
                    usuario.setApellidos(ls_apellidos);
                    usuario.setUsuario(ls_usuario);
                    usuario.setContrasenia(ls_contrasenia);
                    usuario.setPermisos("0");
                    
                    entitymanager.persist(usuario);
                    entitymanager.getTransaction().commit();

                    ls_mensaje += ("Se insertó correctamente");
                    is_pantalla = desplegarPantallaUsuarios("","","","","");
                } catch (Exception ex) {
                    entitymanager.getTransaction().commit();
                    ls_mensaje = "inserción incorrecta";
                }
                entitymanager.close();
                emfactory.close();
                
                     */
                }
                is_pantalla = desplegarPantallaUsuarios("", "", "", "", "") + ls_mensaje;
            }

        }
        out.println(is_pantalla);
    }

    public String desplegarPantallaUsuarios(String ls_nombres, String ls_apellidos, String ls_usuario, String ls_contrasenia, String ls_contrasenia2) {
        String ls_pantalla = "";
        ls_pantalla += ("<!DOCTYPE html>");
        ls_pantalla += ("<html>");
        ls_pantalla += ("<head>");
        ls_pantalla += ("<title>Servlet serv_usuarios</title>");
        ls_pantalla += ("</head>");
        ls_pantalla += ("<body>");
        ls_pantalla += ("<h1>Nuevo Usuario</h1>");
        ls_pantalla += ("<form action='serv_usuarios' method='post'>");
        ls_pantalla += ("Nombres:<input type='text' name='nombres' required='required'" + " value='" + ls_nombres + "'></input>");
        ls_pantalla += ("<br>");
        ls_pantalla += ("Apellidos:<input type='text' name='apellidos' required='required'" + " value='" + ls_apellidos + "'></input>");
        ls_pantalla += ("<br>");
        ls_pantalla += ("Usuario:<input type='text' name='usuario' required='required'" + " value='" + ls_usuario + "'></input>");
        ls_pantalla += ("<br>");
        ls_pantalla += ("Contrasenia:<input type='password' name='contrasenia' required='required'" + " value='" + ls_contrasenia + "'></input>");
        ls_pantalla += ("<br>");
        ls_pantalla += ("Repetir Contrasenia:<input type='password' name='contrasenia2' required='required'" + " value='" + ls_contrasenia2 + "'></input>");
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
