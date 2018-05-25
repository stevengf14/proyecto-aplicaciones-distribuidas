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
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
        serv_lista_autores obj = new serv_lista_autores();
        if (is_boton == null || is_boton == "") {
            is_pantalla = desplegar_pantallaIngreso("", "", "");
        }
        if (is_boton != null && !"".equals(is_boton)) {
            if (is_boton.equals("Guardar Ingreso")) {
                EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
                EntityManager em1 = factory.createEntityManager();
                Autor pr = new Autor(ls_codigo);
                pr.setAuNombre(ls_nombre);
                pr.setAuApellido(ls_apellifo);
                try {
                    em1.getTransaction().begin();
                    em1.persist(pr);
                    em1.getTransaction().commit();
                    is_pantalla = desplegar_pantalla_confirmacion();
                } catch (Exception ex) {
                    //ls_mensaje = "El error es: " + ex.getMessage();
                    is_pantalla = desplegar_pantallaIngreso("", "", "");
                    ls_mensaje = "Inserción Incorrecta";
                }
                em1.close();
                factory.close();
            }
            if (is_boton.equals("Buscar")) {
                List<String> lista = new ArrayList<String>();
                EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
                EntityManager em1 = factory.createEntityManager();
                try {
                    Query q = em1.createNativeQuery("SELECT AU_NOMBRE FROM AUTOR");
                    lista = q.getResultList();
                    ls_nombre = lista.get(Integer.getInteger(ls_codigo));
                    is_pantalla = desplegar_pantallaIngreso(ls_codigo, ls_nombre, "");
                } catch (Exception ex) {

                }
                em1.close();
                factory.close();
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
                is_pantalla = desplegar_pantallaIngreso("", "", "");
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

    public String desplegar_pantalla_confirmacion() {
        String ls_pantalla = "";
        ls_pantalla += "<!DOCTYPE html>";
        ls_pantalla += "<html>";
        ls_pantalla += "<head>";
        ls_pantalla += "<title>Servlet serv_menu_biblioteca</title>";
        ls_pantalla += "<link rel='stylesheet' type='text/css' href='estilos1.css'>";
        ls_pantalla += "</head>";
        ls_pantalla += "<form action='serv_autor' method='post'>";
        ls_pantalla += "<h1>Tabla de Autores</h1>";
        ls_pantalla += "<table width='50%' border='0' align='center'>";
        ls_pantalla += "<tr>";
        ls_pantalla += "<td>Autor del Libro ingresado correctamente</td>";
        ls_pantalla += "</tr>";
        ls_pantalla += "</table>";
        ls_pantalla += "</br></br></br><center>";
        ls_pantalla += "</center></form>";
        ls_pantalla += "</br></br>";
        ls_pantalla += "<center><a href='http://localhost:8080/proyecto_distribuidas/serv_lista_autores'><input type='submit' value='Regresar' name='boton' ></a></center>";
        ls_pantalla += "</body>";
        ls_pantalla += "</html>";
        return ls_pantalla;
    }

    public String desplegar_pantallaIngreso(String as_codigo, String as_nombre, String as_apellido) {
        String ls_pantalla = "";
        ls_pantalla += "<!DOCTYPE html>";
        ls_pantalla += "<html>";
        ls_pantalla += "<head>";
        ls_pantalla += "<title>Servlet serv_menu_biblioteca</title>";
        ls_pantalla += "<link rel='stylesheet' type='text/css' href='estilos1.css'>";
        ls_pantalla += "</head>";
        ls_pantalla += "<form action='serv_autor' method='post'>";
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
        ls_pantalla += "<td></td><center><td colspan='1'><input type='submit' value='Guardar Ingreso' name='boton'></td><center>";
        ls_pantalla += "</tr>";
        ls_pantalla += "</table>";
        ls_pantalla += "</br></br></br><center>";
        ls_pantalla += "</center></form>";
        ls_pantalla += "</br></br>";
        ls_pantalla += "<center><a href='http://localhost:8080/proyecto_distribuidas/serv_lista_autores'><input type='submit' value='Regresar' name='boton' ></a></center>";
        ls_pantalla += "</body>";
        ls_pantalla += "</html>";
        return ls_pantalla;
    }

    public String desplegar_pantallaBusqueda(String as_codigo) {
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
        ls_pantalla += "<form action='serv_autor' method='post'>";
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
        ls_pantalla += "</form>";
        ls_pantalla += "</br></br>";
        ls_pantalla += "<center><a href='http://localhost:8080/proyecto_distribuidas/serv_lista_autores'><input type='submit' value='Regresar' name='boton' ></a></center>";
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
