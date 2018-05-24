/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contabilidad;

import Comun.Bean_PermisosLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pkg_persistencia.TipoCuenta;

/**
 *
 * @author Steven
 */
@WebServlet(name = "serv_tipo_cuenta", urlPatterns = {"/serv_tipo_cuenta"})
public class serv_tipo_cuenta extends HttpServlet {

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
    Bean_ContabilidadLocal beanContabilidad;
    String ls_mensaje = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //try (PrintWriter out = response.getWriter()) {
        String is_pantalla = "";

        String is_boton = "";
        String cuenta = "";
        String nombre = "";
        String busqueda= request.getParameter("cuenta");
        is_boton = request.getParameter("boton");

        if (is_boton == null || is_boton == "") {
            is_pantalla = desplegarPantallaTipoCuenta("");
        }

        if (is_boton != null && is_boton != "") {
            nombre = request.getParameter("nombre");
            cuenta = request.getParameter("cuenta");
            if (is_boton.equals("Insertar")) {
                if(beanContabilidad.InsertarTipoCuenta(nombre)==1)
                    ls_mensaje="Ingreso correcto";
                else
                    ls_mensaje="Error de Ingreso";
            }
            if (is_boton.equals("Modificar")) {
                ls_mensaje=beanContabilidad.BuscarCuenta(busqueda);
            }

            if (is_boton.equals("Guardar")) {
                ls_mensaje = "Guardar";
            }
            if (is_boton.equals("Buscar")) {
                String resultado = "";
                String val = "1";
                EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
                EntityManager em1 = factory.createEntityManager();
                pkg_persistencia.TipoCuenta tc = new pkg_persistencia.TipoCuenta();
                
                try {
                    tc = em1.find(TipoCuenta.class, "2");
                    resultado = tc.getTpNombre();
                } catch (Exception ex) {
                    resultado = ex.getMessage();
                }
                em1.close();
                factory.close();
                ls_mensaje = resultado;
            }
            if (is_boton.equals("Eliminar")) {
                ls_mensaje = "Eliminar";
            }
            if (is_boton.equals("Regresar")) {
                ls_mensaje = "Regresar";
            }
            is_pantalla = desplegarPantallaTipoCuenta("") + ls_mensaje;
        }

        out.println(is_pantalla);
    }
    
    

    public String desplegarPantallaTipoCuenta(String ls_nombre) {
        List lista = new ArrayList<String>();
        lista=beanContabilidad.ExtraerCodigos();
        String ls_pantalla = "";
        ls_pantalla += ("<!DOCTYPE html>");
        ls_pantalla += ("<html>");
        ls_pantalla += ("<head>");
        ls_pantalla += ("<title>Servlet serv_tipo_cuenta</title>");
        ls_pantalla += ("</head>");
        ls_pantalla += ("<body>");
        ls_pantalla += ("<h1>Tipo de Cuenta</h1>");
        ls_pantalla += ("<form action='serv_tipo_cuenta' method='post'>");
        ls_pantalla += ("Nombre:<input type='text' name='nombre' required='required'" + " value='" + ls_nombre + "'></input>");
        //ls_pantalla += ("<br>");
        //ls_pantalla += (":</br>");
        ls_pantalla += ("<select id='cuenta' name='cuenta'>");
        for (int i = 0; i < lista.size(); i++) {
            ls_pantalla += ("<option  value='"+lista.get(i)+"'>" + lista.get(i) + "</option>");
        }
        ls_pantalla += ("</select>");
        ls_pantalla += ("</br>");
        ls_pantalla += ("<input type='submit' value='Insertar' name='boton' ></input>");
        ls_pantalla += ("<input type='submit' value='Buscar' name='boton' ></input>");
        ls_pantalla += "</br>";
        ls_pantalla += "<div id='botones_edicion' style='display:none;'>";
        ls_pantalla += ("<input type='submit' value='Guardar' name='boton' ></input>");
        ls_pantalla += ("<input type='submit' value='Modificar' name='boton' ></input>");
        ls_pantalla += ("<input type='submit' value='Eliminar' name='boton' ></input>");
        ls_pantalla += ("</div>");
        ls_pantalla += "</form>";
        ls_pantalla += "</br>";
        ls_pantalla += ("<a href='http://localhost:8080/distribuidas/serv_Menu_Contabilidad'><input type='submit' value='Regresar' name='boton' ></a>");
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
