/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca;

import Contabilidad.Bean_ContabilidadLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
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
@WebServlet(name = "serv_crud_libros", urlPatterns = {"/serv_crud_libros"})
public class serv_crud_libros extends HttpServlet {

    String ls_mensaje = "";
    @EJB
    Bean_BibliotecaLocal beanBiblioteca;

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
        ls_mensaje = "Registro de Libros";
        String is_boton = "";
        String ls_isbn = "";
        String ls_titulo = "";
        String ls_autor = "";
        String aux_valor_prestamo = "";
        is_boton = request.getParameter("boton");
        ls_isbn = request.getParameter("isbn");
        ls_titulo = request.getParameter("titulo");
        ls_autor = request.getParameter("autor");
        aux_valor_prestamo = request.getParameter("valor_prestamo");
        if (is_boton == null || is_boton == "") {
            is_pantalla = desplegar_pantalla("", "", "", "", "");
        }
        if (is_boton != null && is_boton != "") {
            if (is_boton.equals("Insertar")) {                
                BigDecimal ls_valor_prestamo;
                ls_valor_prestamo=(BigDecimal.valueOf((double) Integer.parseInt(aux_valor_prestamo)));
                //Autor lst_autor=Autor.forName(ls_autor);
                EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
                EntityManager em1 = factory.createEntityManager();
                Libro pr = new Libro(ls_isbn);
                pr.setLibTitulo(ls_titulo);
                pr.setAuCodigo(ls_autor);
                pr.setLibValorPrestamo(ls_valor_prestamo);
                //try {
                    em1.getTransaction().begin();
                    em1.persist(pr);
                    em1.getTransaction().commit();
                    is_pantalla = desplegar_pantalla("", "", "", "", "block");
                    ls_mensaje = "Inserción correcta";
                /*} catch (Exception ex) {
                    ls_mensaje = "El error es: " + ex.getMessage();
                    is_pantalla = desplegar_pantalla("", "", "", "", "block");
                    ls_mensaje = "Inserción Incorrecta";
                }*/
                em1.close();
                factory.close();
            }
            if (is_boton.equals("Buscar")) {
                is_pantalla = desplegar_pantalla("", "", "", "", "block");
            }
            if (is_boton.equals("Eliminar")) {
                EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
                EntityManager em1 = factory.createEntityManager();
                Autor pr = new Autor(ls_isbn);
                pr.setAuCodigo(ls_isbn);
                //try {
                pr = em1.find(Autor.class, ls_isbn);
                em1.getTransaction().begin();
                em1.remove(pr);
                em1.getTransaction().commit();
                is_pantalla = desplegar_pantalla("", "", "", "", "block");
                ls_mensaje = beanBiblioteca.BuscarCuenta(ls_isbn);
                /*} catch (Exception ex) {
                    is_pantalla = desplegar_pantalla("", "", "");
                    ls_mensaje = "Eliminación incorrecta";
                    em1.getTransaction().rollback();
                }*/
                em1.close();
                factory.close();
            }
        }
        is_pantalla += ls_mensaje;
        out.println(is_pantalla);
    }

    public String desplegar_pantalla(String isbn, String titulo, String autor, String valor_prestamo, String mostrar) {
        List lista = new ArrayList<String>();
        List lista1 = new ArrayList<String>();
        lista = beanBiblioteca.ExtraerCodigosLibrosApellido();
        lista1 = beanBiblioteca.ExtraerCodigosLibrosNombre();
        String ls_pantalla = "";
        ls_pantalla += "<!DOCTYPE html>";
        ls_pantalla += "<html>";
        ls_pantalla += "<head>";
        ls_pantalla += "<title>Servlet serv_menu_biblioteca</title>";
        ls_pantalla += "<link rel='stylesheet' type='text/css' href='estilos1.css'>";
        ls_pantalla += "</head>";
        ls_pantalla += "<form action='serv_crud_libros' method='post'>";
        ls_pantalla += "<h1>Tabla de Libros disponibles</h1>";
        ls_pantalla += "<table width='50%' border='0' align='center'>";
        ls_pantalla += "<tr>";
        ls_pantalla += "<td>Código del Libro</td>";
        ls_pantalla += "<td><label for='codigo'></label>";
        ls_pantalla += "<input type='text' name='isbn'" + "value='" + isbn + "'></td>";
        ls_pantalla += "</tr>";
        ls_pantalla += "<tr>";
        ls_pantalla += "<td>Título del Libro</td>";
        ls_pantalla += "<td><label for='nombre_cliente'></label>";
        ls_pantalla += "<input type='text' name='titulo' class='centrado'" + "value='" + titulo + "'></td>";
        ls_pantalla += "</tr>";
        ls_pantalla += "<tr>";
        ls_pantalla += "<td>Autor del Libro</td>";
        ls_pantalla += "<td><label for='autor'></label>";
        ls_pantalla += ("<select id='cuenta' name='cuenta' style='display:+" + mostrar + ";>");
        for (int i = 0; i < lista.size(); i++) {
            ls_pantalla += ("<option  value='" + lista.get(i) + " " + lista1.get(i) + "'>" + lista.get(i) + " " + lista1.get(i) + "</option>");
        }
        ls_pantalla += "<br><input type='text' name='autor' class='centrado'" + "value='" + autor + "'></td>";
        ls_pantalla += ("</select>");
        ls_pantalla += "<div id='botones_edicion' style='display:+" + mostrar + ";'>";
        ls_pantalla += "</tr>";
        ls_pantalla += "<tr>";
        ls_pantalla += "<td>Valor del prestamo</td>";
        ls_pantalla += "<td><label for='valor_prestamo'></label>";
        ls_pantalla += "<input type='text' name='valor_prestamo' class='centrado'" + "value='" + valor_prestamo + "'></td>";
        ls_pantalla += "</tr>";
        ls_pantalla += "<tr>";
        ls_pantalla += "<td colspan='1'><input type='submit' value='Insertar' name='boton'>";
        ls_pantalla += "<input type='submit' value='Buscar' name='boton'></td>";
        ls_pantalla += "<td colspan='1'><input type='submit' value='Eliminar' name='boton'>";
        ls_pantalla += "<input type='submit' value='Modificar' name='boton'></td>";
        ls_pantalla += "</tr>";
        ls_pantalla += "</table>";
        ls_pantalla += "</form></br></br></br><center>";
        ls_pantalla += "<center><a href='http://localhost:8080/proyecto_distribuidas/serv_Menu_Biblioteca'><input type='submit' value='Regresar' name='boton' ></a></center>";
        ls_pantalla += "</center>";
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
