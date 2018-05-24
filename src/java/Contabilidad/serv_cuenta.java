/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contabilidad;

import java.io.IOException;
import java.io.PrintWriter;
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
 * @author Steven
 */
@WebServlet(name = "serv_cuenta", urlPatterns = {"/serv_cuenta"})
public class serv_cuenta extends HttpServlet {

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
    String aux="";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //try (PrintWriter out = response.getWriter()) {
        String is_pantalla = "";

        String mostrar = "none";
        String is_boton = "";
        String cuenta = "";
        String nombre = "";
        String tipo_cuenta = "";
        String busqueda = request.getParameter("cuenta");
        is_boton = request.getParameter("boton");

        if (is_boton == null || is_boton == "") {
            is_pantalla = desplegarPantallaCuenta("", "none","");
        }

        if (is_boton != null && is_boton != "") {
            nombre = request.getParameter("nombre");
            cuenta = request.getParameter("cuenta");
            tipo_cuenta = request.getParameter("tipo_cuenta");
            if (is_boton.equals("Insertar")) {
                //ls_mensaje=String.valueOf(beanContabilidad.InsertarCuenta(nombre, tipo_cuenta));
                if (nombre.equals("")) {
                    ls_mensaje = "Ingrese un nombre de Tipo de Cuenta";
                } else {
                    if (beanContabilidad.verificarCuenta(nombre) != false) {
                        ls_mensaje = "El tipo de Cuenta ya existe";
                    } else {
                        if (beanContabilidad.InsertarCuenta(nombre, tipo_cuenta) == 1) {
                            ls_mensaje = "Ingreso correcto";
                        } else {
                            ls_mensaje = "Error de Ingreso";
                        }
                    }
                }
                is_pantalla = desplegarPantallaCuenta("", "none","");
            }
            if (is_boton.equals("Modificar")) {
                aux=busqueda;
                
                is_pantalla = desplegarPantallaCuenta(busqueda, "block",aux);
            }
            if (is_boton.equals("Guardar")) {
                ls_mensaje = "Guardar";
            }
            if (is_boton.equals("Buscar")) {
                is_pantalla = desplegarPantallaCuenta("", "block","");
                mostrar = "block";
            }
            if (is_boton.equals("Eliminar")) {
                ls_mensaje = "Eliminar";
            }
            if (is_boton.equals("Regresar")) {
                ls_mensaje = "Regresar";
            }
            //is_pantalla = desplegarPantallaCuenta("") + ls_mensaje;
        }

        is_pantalla += ls_mensaje;
        out.println(is_pantalla);
        mostrar = "none";
        ls_mensaje = "";
    }

    public String desplegarPantallaCuenta(String ls_nombre, String mostrar, String selected) {
        String ls_pantalla = "";
        List lista = new ArrayList<String>();
        lista = beanContabilidad.ExtraerTipoCodigos();

        List lista2 = new ArrayList<String>();
        lista2 = beanContabilidad.ExtraerCodigos();
        ls_pantalla += ("<!DOCTYPE html>");
        ls_pantalla += ("<html>");
        ls_pantalla += ("<head>");
        ls_pantalla += ("<title>Servlet serv_cuenta</title>");
        ls_pantalla += "<link rel='stylesheet' type='text/css' href='estilos1.css'>";
        ls_pantalla += ("</head>");
        ls_pantalla += ("<body>");
        ls_pantalla += ("<h1>Cuenta</h1>");
        ls_pantalla += ("<form action='serv_cuenta' method='post'>");
        ls_pantalla += ("Nombre:<input type='text' name='nombre' value='" + ls_nombre + "'></input>");

        ls_pantalla += ("</br>");
        ls_pantalla += ("Tipo de Cuenta: <select id='tipo_cuenta' name='tipo_cuenta' style='display:none>");
        for (int i = 0; i < lista.size(); i++) {
            ls_pantalla += ("<option  value='" + lista.get(i) + "'>" + lista.get(i) + "</option>");
        }
        ls_pantalla += ("</select>");
        ls_pantalla += ("</br>");
        ls_pantalla += "<div id='dcuen' >";
        ls_pantalla += ("</br></br>Cuenta: <select id='cuenta' name='cuenta' style='display:" + mostrar + ";' >");
        for (int i = 0; i < lista2.size(); i++) {
            if(selected.equals(lista2.get(i)))
                ls_pantalla += ("<option  value='" + lista2.get(i) + "' selected>" + lista2.get(i) + "</option>");
            else
                ls_pantalla += ("<option  value='" + lista2.get(i) + "'>" + lista2.get(i) + "</option>");
        }

        ls_pantalla += ("</select>");
        ls_pantalla += "</div></br>";
        ls_pantalla += ("<input type='submit' value='Insertar' name='boton' ></input>");
        ls_pantalla += ("<input type='submit' value='Buscar' name='boton' ></input>");
        ls_pantalla += "</br>";
        ls_pantalla += "</br>";
        ls_pantalla += "<div id='botones_edicion' style='display:" + mostrar + ";'>";
        ls_pantalla += ("<input type='submit' value='Guardar' name='boton' ></input>");
        ls_pantalla += ("<input type='submit' value='Modificar' name='boton' ></input>");
        ls_pantalla += ("<input type='submit' value='Eliminar' name='boton' ></input>");
        ls_pantalla += ("</div>");
        ls_pantalla += "</form>";
        ls_pantalla += "</br>";
        ls_pantalla += ("<a href='http://localhost:8080/proyecto_distribuidas/serv_Menu_Contabilidad'><input type='submit' value='Regresar' name='boton' ></a>");
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
