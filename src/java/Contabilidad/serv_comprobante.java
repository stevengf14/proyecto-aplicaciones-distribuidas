/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contabilidad;

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
@WebServlet(name = "serv_comprobante", urlPatterns = {"/serv_comprobante"})
public class serv_comprobante extends HttpServlet {

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
        String fecha = "";
        String cabecera = "";
        String observaciones = "";
        is_boton = request.getParameter("boton");

        if (is_boton == null || is_boton == "") {
            is_pantalla = desplegarPantallaCabecera("");
        }

        if (is_boton != null && is_boton != "") {
            observaciones = request.getParameter("observaciones");
            cabecera = request.getParameter("cabecera");
            fecha = request.getParameter("fecha");
            if (is_boton.equals("Insertar")) {
                ls_mensaje = observaciones + " Insertado a la cuenta " + cabecera + " y tipo de cuenta: " + fecha;
                is_pantalla = desplegarPantallaCabecera("");
            }
            if (is_boton.equals("Modificar")) {
                ls_mensaje = "Modificar";
                is_pantalla = desplegarPantallaCabecera("");
            }
            if (is_boton.equals("Guardar")) {
                ls_mensaje = observaciones;
                is_pantalla = desplegarPantallaCabecera("");
            }
            if (is_boton.equals("Buscar")) {
                ls_mensaje = "Buscar";
                is_pantalla = desplegarPantallaCompleta(observaciones,"","");
            }
            if (is_boton.equals("Eliminar")) {
                ls_mensaje = "Eliminar";
                is_pantalla = desplegarPantallaCabecera("");
            }
            if (is_boton.equals("Regresar")) {
                ls_mensaje = "Regresar";
                is_pantalla = desplegarPantallaCabecera("");
            }
            //is_pantalla = desplegarPantallaCuenta("") + ls_mensaje;
        }

        is_pantalla += ls_mensaje;
        out.println(is_pantalla);
    }

    public String desplegarPantallaCompleta(String ls_observaciones, String ls_cantidad_debe, String ls_cantidad_haber) {
        String ls_pantalla = "";
        ls_pantalla += ("<!DOCTYPE html>");
        ls_pantalla += ("<html>");
        ls_pantalla += ("<head>");
        ls_pantalla += ("<title>Servlet serv_comprobante</title>");
        ls_pantalla += "<link rel='stylesheet' type='text/css' href='estilos1.css'>";
        ls_pantalla += ("</head>");
        ls_pantalla += ("<body>");
        ls_pantalla += ("<h1>Comprobante</h1>");
        ls_pantalla += ("<form action='serv_comprobante' method='post'>");
        ls_pantalla += ("<h2>Cabecera Comprobante</h2>");
        ls_pantalla += ("Seleccionar Cabecera: <select id='cabecera' name='cabecera'>");
        for (int i = 0; i < 5; i++) {
            ls_pantalla += ("<option  value=cabecera_" + i + ">Cabecera No. " + i + "</option>");
        }
        ls_pantalla += ("</select>");
        ls_pantalla += ("</br>");
        ls_pantalla += ("Fecha: <input type='date' name='date' id='date' value='12-12-1999;'></input>");
        ls_pantalla += ("</br>");
        ls_pantalla += "Apellidos:<input type='text' name='apellido'" + " value='12/12/1999'></input>";
        ls_pantalla += ("</br>");
        ls_pantalla += ("Observaciones:</br><div id='inputs' contenteditable value='" + ls_observaciones + "'></div>");
        ls_pantalla += ("</br>");
        ls_pantalla += ("<input type='submit' value='Insertar' name='boton' ></input>");
        ls_pantalla += ("<input type='submit' value='Guardar' name='boton' ></input>");
        ls_pantalla += ("<input type='submit' value='Modificar' name='boton' ></input>");
        ls_pantalla += ("<input type='submit' value='Buscar' name='boton' ></input>");
        ls_pantalla += ("<input type='submit' value='Eliminar' name='boton' ></input>");
        ls_pantalla += ("</br>");

        ls_pantalla += "</form>";

        ls_pantalla += ("<form action='serv_comprobante' method='post'>");
        ls_pantalla += ("<h2>Detalle Comprobante</h2>");
        ls_pantalla += ("Seleccionar Detalle: <select id='detalle' name='detalle'>");
        for (int i = 0; i < 5; i++) {
            ls_pantalla += ("<option  value=detalle_" + i + ">Detalle No. " + i + "</option>");
        }
        ls_pantalla += ("</select>");
        ls_pantalla += ("</br>");
        ls_pantalla += ("Seleccionar Cuenta: </br>");
        ls_pantalla += ("<select id='cuenta' name='cuenta'>");
        for(int i=0;i<5;i++)
        {
            ls_pantalla += ("<option  value=cuenta_"+i+">Cuenta No. "+i+"</option>");
        }
        ls_pantalla += ("</select>");
        ls_pantalla += ("</br>");
        ls_pantalla += ("Cantidad Debe: <input type='text' value= '"+ls_cantidad_debe+"'>");
        ls_pantalla += ("</br>");
        ls_pantalla += ("Cantidad Haber: <input type='text' value= '"+ls_cantidad_haber+"'>");
        ls_pantalla += ("</br>");
        ls_pantalla += ("<input type='submit' value='Insertar' name='boton2' ></input>");
        ls_pantalla += ("<input type='submit' value='Guardar' name='boton2' ></input>");
        ls_pantalla += ("<input type='submit' value='Modificar' name='boton2' ></input>");
        ls_pantalla += ("<input type='submit' value='Buscar' name='boton2' ></input>");
        ls_pantalla += ("<input type='submit' value='Eliminar' name='boton2' ></input>");
        ls_pantalla += ("</br>");

        ls_pantalla += "</form>";
        ls_pantalla += ("<input type='submit' value='Regresar' name='boton' ></input>");
        ls_pantalla += ("</body>");
        ls_pantalla += ("</html>");
        return ls_pantalla;
    }

    public String desplegarPantallaCabecera(String ls_observaciones) {
        String ls_pantalla = "";
        ls_pantalla += ("<!DOCTYPE html>");
        ls_pantalla += ("<html>");
        ls_pantalla += ("<head>");
        ls_pantalla += ("<title>Servlet serv_comprobante</title>");
        ls_pantalla += "<link rel='stylesheet' type='text/css' href='estilos1.css'>";
        ls_pantalla += ("</head>");
        ls_pantalla += ("<body>");
        ls_pantalla += ("<h1>Comprobante</h1>");
        ls_pantalla += ("<form action='serv_comprobante' method='post'>");
        ls_pantalla += ("<h2>Cabecera Comprobante</h2>");
        ls_pantalla += ("Seleccionar Cabecera: <select id='cabecera' name='cabecera'>");
        for (int i = 0; i < 5; i++) {
            ls_pantalla += ("<option  value=cabecera_" + i + ">Cabecera No. " + i + "</option>");
        }
        ls_pantalla += ("</select>");
        ls_pantalla += ("</br>");
        ls_pantalla += ("Fecha: <input name='date' id='date' type='text' placeholder='dd/mm/aaaa'>");
        ls_pantalla += ("</br>");
        ls_pantalla += ("Observaciones:</br><textarea id='observaciones' name='observaciones'  value='" + ls_observaciones + "'></textarea>");
        ls_pantalla += ("</br>");
        ls_pantalla += ("<input type='submit' value='Insertar' name='boton' ></input>");
        ls_pantalla += ("<input type='submit' value='Guardar' name='boton' ></input>");
        ls_pantalla += ("<input type='submit' value='Modificar' name='boton' ></input>");
        ls_pantalla += ("<input type='submit' value='Buscar' name='boton' ></input>");
        ls_pantalla += ("<input type='submit' value='Eliminar' name='boton' ></input>");
        ls_pantalla += ("</br>");

        ls_pantalla += "</form>";

        /*ls_pantalla += ("<h2>Detalle Comprobante</h2>");
        ls_pantalla += ("Seleccionar Detalle: <select id='cabecera' name='cabecera'>");
        for(int i=0;i<5;i++)
        {
            ls_pantalla += ("<option  value=cabecera_"+i+">Cabecera No. "+i+"</option>");
        }
        ls_pantalla += ("</select>");
        ls_pantalla += ("</br>");
        ls_pantalla += ("Fecha: <input id='date' type='date'>");
        ls_pantalla += ("</br>");
        ls_pantalla += ("Observaciones:</br> <textarea rows='5' cols='50' name='observaciones' required='required' value='" + ls_observaciones + "'></textarea>");
        
        ls_pantalla += ("</br>");
        ls_pantalla += ("<input type='submit' value='Insertar' name='boton' ></input>");
        ls_pantalla += ("<input type='submit' value='Guardar' name='boton' ></input>");
        ls_pantalla += ("<input type='submit' value='Modificar' name='boton' ></input>");
        ls_pantalla += ("<input type='submit' value='Buscar' name='boton' ></input>");
        ls_pantalla += ("<input type='submit' value='Eliminar' name='boton' ></input>");
        ls_pantalla += ("</br>");
        
        ls_pantalla += "</form>";*/
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
