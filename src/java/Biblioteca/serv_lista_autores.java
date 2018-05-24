/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
 * @author JONATHAN
 */
@WebServlet(name = "serv_lista_autores", urlPatterns = {"/serv_lista_autores"})
public class serv_lista_autores extends HttpServlet {

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
    negocio_biblioteca nb = new negocio_biblioteca();
    @EJB
    Bean_BibliotecaLocal beanBiblioteca;

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
        serv_autor obj = new serv_autor();
        //is_pantalla = desplegar_pantalla("", "", "", "block");
        //out.println(is_pantalla);
        if (is_boton == null || is_boton == "") {
            is_pantalla = desplegar_pantalla("", "", "", "block");
        }
        if (is_boton != null && !"".equals(is_boton)) {
            if (is_boton.equals("Insertar")) {
                is_pantalla = desplegar_pantalla("", "", "", "block")+obj.desplegar_pantallaIngreso("","", "");
            }
        }
        out.println(is_pantalla);
    }

    public String desplegar_pantalla(String codigo, String nombre, String apellido, String mostrar) {
        List lista = new ArrayList<String>();
        List lista1 = new ArrayList<String>();
        List lista2 = new ArrayList<String>();
        lista2 = beanBiblioteca.ExtraerCodigosLibrosCodigo();
        lista = beanBiblioteca.ExtraerCodigosLibrosApellido();
        lista1 = beanBiblioteca.ExtraerCodigosLibrosNombre();
        String ls_pantalla = "";
        ls_pantalla += "<!DOCTYPE html>";
        ls_pantalla += "<html>";
        ls_pantalla += "<head>";
        ls_pantalla += "<title>Servlet serv_menu_biblioteca</title>";
        ls_pantalla += "<link rel='stylesheet' type='text/css' href='estilos1.css'>";
        ls_pantalla += "</head>";
        ls_pantalla += "<body>";
        ls_pantalla += "<h1>Tabla de Autores</h1>";
        ls_pantalla += "<form action='serv_lista_autores' method='post'>";
        ls_pantalla += "<table width='50%' border='1' align='center' id='tabla'>";
        ls_pantalla += "<tr>";
        ls_pantalla += "<td class='primera_fila'>Código</td>";
        ls_pantalla += "<td class='primera_fila'>Nombre</td>";
        ls_pantalla += "<td class='primera_fila'>Apellido</td>";
        ls_pantalla += "</tr>";

        //ls_pantalla += "<select id='cuenta' name='cuenta' style='display:+" + mostrar + ";>";
        for (int i = 0; i < lista.size(); i++) {
            ls_pantalla += "<center><tr>";
            ls_pantalla += "<td><input type='text' size='20' class='centrado'  paddding=10px name='codigo' " + "value='" + lista2.get(i) + "'></input></td>";
            ls_pantalla += "<td><input type='text' size='20' class='centrado' paddding=10px name='nombre' " + "value='" + lista1.get(i) + "'></input></td>";
            ls_pantalla += "<td><input type='text' size='20' class='centrado' paddding=10px name='apellido' " + "value='" + lista.get(i) + "'></input></td>";
            ls_pantalla += "</tr></center>";
        }
        //ls_pantalla += "</select>";
        ls_pantalla += "</table>";
        ls_pantalla += "</br>";
        ls_pantalla += "<input type='submit' value='Insertar' name='boton'></input>";
        ls_pantalla += "<input type='submit' value='Buscar' name='boton'></input>";
        ls_pantalla += "<input type='submit' value='Eliminar' name='boton'></input>";
        ls_pantalla += "<input type='submit' value='Actualziar' name='boton'></input>";
        ls_pantalla += "</form>";

        //ls_pantalla += "<center><a href='http://localhost:8080/proyecto_distribuidas/serv_autor'><input type='submit' name='boton' value='Insertar'></a></center>";
        ls_pantalla += "</br></br>";
        ls_pantalla += "<aside>";
        ls_pantalla += "<center><a href='http://localhost:8080/proyecto_distribuidas/serv_Menu_Biblioteca'><input type='submit' value='Regresar' name='boton' ></a></center>";
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
