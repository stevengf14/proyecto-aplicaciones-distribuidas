/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JONATHAN
 */
@WebServlet(name = "serv_lista_libros", urlPatterns = {"/serv_lista_libros"})
public class serv_lista_libros extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB
    Bean_BibliotecaLocal beanBiblioteca;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String is_pantalla = "";
        String is_boton = "";
        String ls_isbn = "";
        String ls_titulo = "";
        String ls_autor = "";
        String ls_valor_prestamo = "";
        is_boton = request.getParameter("boton");
        ls_isbn = request.getParameter("isbn");
        ls_titulo = request.getParameter("titulo");
        ls_titulo = request.getParameter("autor");
        ls_valor_prestamo = request.getParameter("valor_prestamo");
        is_pantalla = desplegar_pantalla("", "", "", 0, "block");
        out.println(is_pantalla);
    }

    public String desplegar_pantalla(String isbn, String titulo, String autor, int valor_prestamo, String mostrar) {
        List lista = new ArrayList<String>();
        List lista1 = new ArrayList<String>();
        lista = beanBiblioteca.ExtraerCodigosLibrosApellido();
        lista1 = beanBiblioteca.ExtraerCodigosLibrosNombre();

        List lista2 = new ArrayList<String>();
        List lista3 = new ArrayList<String>();
        List lista4 = new ArrayList<String>();
        lista2 = beanBiblioteca.ExtraerCodigosLibrosIsbn();
        lista3 = beanBiblioteca.ExtraerCodigosLibrosTitulo();
        lista4 = beanBiblioteca.ExtraerCodigosLibrosValor();

        String ls_pantalla = "";
        ls_pantalla += "<!DOCTYPE html>";
        ls_pantalla += "<html>";
        ls_pantalla += "<head>";
        ls_pantalla += "<title>Servlet serv_menu_biblioteca</title>";
        ls_pantalla += "</head>";
        ls_pantalla += "<body>";
        ls_pantalla += "<form action='serv_autores' method='post'>";
        ls_pantalla += "<h1>Tabla de Libro</h1>";
        ls_pantalla += "<table width='50%' border='1' align='center' id='tabla'>";
        ls_pantalla += "<tr>";
        ls_pantalla += "<td class='primera_fila'>Código Isbn</td>";
        ls_pantalla += "<td class='primera_fila'>Titulo</td>";
        ls_pantalla += "<td class='primera_fila'>Autor</td>";
        ls_pantalla += "<td class='primera_fila'>Valor Prestamo</td>";
        ls_pantalla += "</tr>";
        for (int i = 0; i < lista2.size(); i++) {
            ls_pantalla += "<tr>";
            ls_pantalla += "<td><input type='text' size='20' class='centrado'  paddding=10px name='isbn' " + "value='" + lista2.get(i) + "'></input></td>";
            ls_pantalla += "<td><input type='text' size='20' class='centrado' paddding=10px name='titulo' " + "value='" + lista3.get(i) + "'></input></td>";
            ls_pantalla += "<td><input type='text' size='20' class='centrado'  paddding=10px name='autor' " + "value='" + lista1.get(i) + " " + lista.get(i) + "'></input></td>";
            ls_pantalla += "<td><input type='text' size='20' class='centrado' paddding=10px name='valor_prestamo' " + "value='" + lista4.get(i) + "'></input></td>";
            ls_pantalla += "</tr>";
        }
        ls_pantalla += "</table>";
        ls_pantalla += "<center><a href='http://localhost:8080/proyecto_distribuidas/serv_crud_libros'><input type='submit' name='boton' value='Insertar'></a></center>";
        ls_pantalla += "</br></br>";
        ls_pantalla += "<center><a href='http://localhost:8080/proyecto_distribuidas/serv_Menu_Biblioteca'><input type='submit' value='Regresar' name='boton' ></a></center>";

        ls_pantalla += "<br>";
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
