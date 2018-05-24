/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Contabilidad.Bean_ContabilidadLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Temporal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JONATHAN
 */
@WebServlet(name = "serv_autor", urlPatterns = {"/serv_autor"})
public class serv_autor extends HttpServlet {

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
        ls_mensaje = "Registro de Autores";
        String is_boton = "";
        String ls_codigo = "";
        String ls_nombre = "";
        String ls_apellifo = "";
        is_boton = request.getParameter("boton");
        ls_codigo = request.getParameter("codigo");
        ls_nombre = request.getParameter("nombre");
        ls_apellifo = request.getParameter("apellido");
        if (is_boton == null || is_boton == "") {
            is_pantalla = desplegar_pantalla("", "", "");
        }

        if (is_boton != null && is_boton != "") {
            if (is_boton.equals("Insertar")) {
                EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
                EntityManager em1 = factory.createEntityManager();
                Autor pr = new Autor(ls_codigo);
                pr.setAuNombre(ls_nombre);
                pr.setAuApellido(ls_apellifo);
                try {
                    em1.getTransaction().begin();
                    em1.persist(pr);
                    em1.getTransaction().commit();
                    is_pantalla = desplegar_pantalla("", "", "");
                    ls_mensaje = "Inserción correcta";
                } catch (Exception ex) {
                    ls_mensaje = "El error es: " + ex.getMessage();
                    is_pantalla = desplegar_pantalla("", "", "");
                    ls_mensaje = "Inserción Incorrecta";
                }
                em1.close();
                factory.close();
            }
            if (is_boton.equals("Buscar")) {
                is_pantalla = desplegar_pantalla("", "", "");
            }
            if (is_boton.equals("Eliminar")) {
                EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
                EntityManager em1 = factory.createEntityManager();
                Autor pr = new Autor(ls_codigo);
                pr.setAuCodigo(ls_codigo);
                //try {
                pr = em1.find(Autor.class, ls_codigo);
                em1.getTransaction().begin();
                em1.remove(pr);
                em1.getTransaction().commit();
                is_pantalla = desplegar_pantalla("", "", "");
                ls_mensaje = beanBiblioteca.BuscarCuenta(ls_codigo);
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

    public String desplegar_pantalla(String as_codigo, String as_nombre, String as_apellido) {
        String ls_pantalla = "";
        ls_pantalla += "<!DOCTYPE html>";
        ls_pantalla += "<html>";
        ls_pantalla += "<head>";
        ls_pantalla += "<title>Servlet serv_menu_biblioteca</title>";
        ls_pantalla += "<link rel='stylesheet' type='text/css' href='estilos1.css'>";
        ls_pantalla += "</head>";
        ls_pantalla += "<divaction='serv_autor' method='post'>";
        ls_pantalla += "<h1>Tabla de Autores</h1>";
        ls_pantalla += "<table width='50%' border='0' align='center'>";
        ls_pantalla += "<tr>";
        ls_pantalla += "<td>Código del Cliente</td>";
        ls_pantalla += "<td><label for='codigo'></label>";
        ls_pantalla += "<input type='text' name='codigo'" + "value='" + as_codigo + "'></td>";
        ls_pantalla += "</tr>";
        ls_pantalla += "<tr>";
        ls_pantalla += "<td>Nombre del Cliente</td>";
        ls_pantalla += "<td><label for='nombre_cliente'></label>";
        ls_pantalla += "<input type='text' name='nombre' class='centrado'" + "value='" + as_nombre + "'></td>";
        ls_pantalla += "</tr>";
        ls_pantalla += "<tr>";
        ls_pantalla += "<td>Apellido del Cliente</td>";
        ls_pantalla += "<td><label for='apellido'></label>";
        ls_pantalla += "<input type='text' name='apellido' class='centrado'" + "value='" + as_apellido + "'></td>";
        ls_pantalla += "</tr>";
        ls_pantalla += "<tr>";
        ls_pantalla += "<td colspan='1'><input type='submit' value='Insertar' name='boton' padding=20%>";
        ls_pantalla += "<input type='submit' value='Buscar' name='boton' padding=20%></td>";
        ls_pantalla += "<td colspan='1'><input type='submit' value='Eliminar' name='boton' padding=20%>";
        ls_pantalla += "<input type='submit' value='Modificar' name='boton' padding=20%></td>";
        ls_pantalla += "</tr>";
        ls_pantalla += "</table>";
        ls_pantalla += "</br></br></br><center>";
        ls_pantalla += "<a href='http://localhost:8080/proyecto_distribuidas/serv_Menu_Biblioteca'><input type='submit' value='Regresar' name='boton' ></a>";
        ls_pantalla += "</center></div>";
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
