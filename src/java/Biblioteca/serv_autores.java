/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca;

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
 * @author JONATHAN
 */
@WebServlet(name = "serv_menu_biblioteca", urlPatterns = {"/serv_menu_biblioteca"})
public class serv_autores extends HttpServlet {

    String ls_mensaje = "";
    negocio_biblioteca nb = new negocio_biblioteca();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String is_pantalla = "";
        String is_boton = "";
        String ls_codigo = "";
        String ls_nombre = "";
        String ls_apellido = "";
        is_boton = request.getParameter("boton");
        ls_codigo = request.getParameter("codigo");
        ls_nombre = request.getParameter("nombre");
        ls_apellido = request.getParameter("apellido");
        is_pantalla = desplegar_pantalla(ls_codigo, ls_nombre, ls_apellido);
        out.println(is_pantalla);
    }

    public String desplegar_pantalla(String codigo, String nombre, String apellido) {
        String ls_pantalla = "";
        ls_pantalla += "<!DOCTYPE html>";
        ls_pantalla += "<html>";
        ls_pantalla += "<head>";
        ls_pantalla += "<title>Servlet serv_menu_biblioteca</title>";
        ls_pantalla += "</head>";
        ls_pantalla += "<body>";
        ls_pantalla += "<h1>Tabla de Autores</h1>";
        ls_pantalla += "<header>";
        ls_pantalla += "<nav>";
        ls_pantalla += "<ul>";
        ls_pantalla += "<li><a href='#'>Inicio</a></li>";
        ls_pantalla += "<li><a href='#'>Categoria</a></li>";
        ls_pantalla += "<li><a href='#'>Categoria 2</a></li>";
        ls_pantalla += "<li><a href='#'>Categoria 3</a></li>";
        ls_pantalla += "</ul>";
        ls_pantalla += "</nav>";
        ls_pantalla += "</header>";
        ls_pantalla += "<form action='serv_autores' method='post'>";
       ls_pantalla += "<table width='50%' border='1' align='center' id='tabla'>";
        ls_pantalla += "<table width='50%' border='1' align='center' id='tabla'>";
        ls_pantalla += "<tr>";
        ls_pantalla += "<td class='primera_fila'>Código</td>";
        ls_pantalla += "<td class='primera_fila'>Nombre</td>";
        ls_pantalla += "<td class='primera_fila'>Apellido</td>";
        ls_pantalla += "</tr>";
        //for (int i = 0; i < 5; i++) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        Autor ar = new Autor();
        //try {
        String aux = "1";
        ar = em1.find(Autor.class, aux);
        codigo = ar.getAuCodigo();
        nombre = ar.getAuNombre();
        apellido = ar.getAuApellido();
        ls_pantalla += "<tr>";
        ls_pantalla += "<td><input type='text' size='20' class='centrado'  paddding=10px name='codigo' " + "value='" + codigo + "'></input></td>";
        ls_pantalla += "<td><input type='text' size='20' class='centrado' paddding=10px name='nombre' " + "value='" + nombre + "'></input></td>";
        ls_pantalla += "<td><input type='text' size='20' class='centrado' paddding=10px name='apellido' " + "value='" + apellido + "'></input></td>";
        ls_pantalla += "</tr>";
        //} catch (Exception ex) {
        //    ls_pantalla+="ERROR: falla en la base de datos";
        // }
        em1.close();
        factory.close();
        //      }
        ls_pantalla += "</table>";
        ls_pantalla += "<br>";
        ls_pantalla += "</form>";

        ls_pantalla += "<a href='http://localhost:9090/proyecto_distribuidas/serv_modificacion_autores'><input type='submit' name='boton' value='Insertar'></a>";
        ls_pantalla += "<a href='http://localhost:9090/proyecto_distribuidas/serv_modificacion_autores'><input type='submit' name='boton' value='Modificar'></a>";
        ls_pantalla += "<a href='http://localhost:9090/proyecto_distribuidas/serv_modificacion_autores'><input type='submit' name='boton' value='Eliminar'></a>";
        ls_pantalla += "<a href='http://localhost:9090/proyecto_distribuidas/serv_modificacion_autores'><input type='submit' name='boton' value='Buscar'></a>";
        ls_pantalla += "<aside>";
        ls_pantalla += "</aside>";

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
