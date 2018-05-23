/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JONATHAN
 */
@WebServlet(name = "serv_modificacion_autores", urlPatterns = {"/serv_modificacion_autores"})
public class serv_crud_autores extends HttpServlet {

    String ls_mensaje = "";
    negocio_biblioteca nb = new negocio_biblioteca();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String is_pantalla = "";
        ls_mensaje = "";
        String is_boton = "";
        String ls_codigo = "";
        String ls_nombre = "";
        String ls_apellido = "";
        is_boton = request.getParameter("boton");
        ls_codigo = request.getParameter("codigo");
        ls_nombre = request.getParameter("nombre");
        ls_apellido = request.getParameter("apellido");
        if (is_boton == null || is_boton == "") {
            is_pantalla = desplegar_pantalla("", "", "");
        }
        if (is_boton != null && is_boton != "") {
            if (is_boton.equals("Actualizar")) {
                if (nb.modificarAutor(ls_codigo, ls_nombre, ls_apellido) == 1) {
                    ls_mensaje = "Se modificó";
                } else {
                    ls_mensaje = "No se pudo modificar";
                }
                is_pantalla = desplegar_pantalla("", "", "");
                is_pantalla += ls_mensaje;
            }
            if (is_boton.equals("Buscar")) {
                ls_nombre = nb.buscarAutor(ls_codigo);
                if (ls_nombre != null) {
                    ls_mensaje = "Se encontró";
                } else {
                    ls_mensaje = "No se encontró";
                }
                is_pantalla = desplegar_pantalla(ls_codigo, ls_nombre, ls_apellido);
                is_pantalla += ls_mensaje;
            }
        }
        out.println(is_pantalla);

    }

    public String desplegar_pantalla(String codigo, String nombre, String apellido) {
        String ls_pantalla = "";
        ls_pantalla += "<!DOCTYPE html>";
        ls_pantalla += "<html>";
        ls_pantalla += "<head>";
        ls_pantalla += "<title>Servlet serv_menu_biblioteca</title>";
        ls_pantalla += "</head>";

        ls_pantalla += "<SCRIPT language='javascript'>";
        ls_pantalla += "function addRow(tableID) {";
        ls_pantalla += "var table = document.getElementById(tableID);";
        ls_pantalla += "var rowCount = table.rows.length;";
        ls_pantalla += "var row = table.insertRow(rowCount);";
        ls_pantalla += "var cell1 = row.insertCell(0);";
        ls_pantalla += "var element1 = document.createElement('input');";
        ls_pantalla += "element1.type = 'checkbox';";
        ls_pantalla += "cell1.appendChild(element1);";
        ls_pantalla += "var cell2 = row.insertCell(1);";
        ls_pantalla += "var element2 = document.createElement('input');";
        ls_pantalla += "element2.type = 'text';";
        ls_pantalla += "cell2.appendChild(element2);";
        ls_pantalla += "}";
        ls_pantalla += "</SCRIPT>";

        ls_pantalla += "<body onload='addRow()'>";
        ls_pantalla += "<form action='serv_autores' method='post'>";
        ls_pantalla += "<h1>Tabla de Autores</h1>";
        ls_pantalla += "<header>";
        ls_pantalla += "<nav>";
        ls_pantalla += "<ul>";
        ls_pantalla += "<li><a href='#'>Inicio</a></li>";
        ls_pantalla += "<li><a href='#'>Autores</a></li>";
        ls_pantalla += "<li><a href='#'>Libros</a></li>";
        ls_pantalla += "<li><a href='#'>Prestamos</a></li>";
        ls_pantalla += "<li><a href='#'>Regresar al menu principal</a></li>";
        ls_pantalla += "</ul>";
        ls_pantalla += "</nav>";
        ls_pantalla += "</header>";
        ls_pantalla += "<table width='25%' border='0' align='center'>";
        ls_pantalla += "<tr>";
        ls_pantalla += "<td>Código del Cliente</td>";
        ls_pantalla += "<td><label for='codigo'></label>";
        ls_pantalla += "<input type='text' name='codigo' id='codigo' value='" + codigo + "'>" + codigo + "</td>";
        ls_pantalla += "</tr>";
        ls_pantalla += "<tr>";
        ls_pantalla += "<td>Nombre del Cliente</td>";
        ls_pantalla += "<td><label for='nombre_cliente'></label>";
        ls_pantalla += "<input type='text' name='nombre' id='nombre' class='centrado' value='" + nombre + "'></td>";
        ls_pantalla += "</tr>";
        ls_pantalla += "<tr>";
        ls_pantalla += "<td>Apellido del Cliente</td>";
        ls_pantalla += "<td><label for='apellido'></label>";
        ls_pantalla += "<input type='text' name='apellido' id='apellido' class='centrado' value='" + apellido + "'></td>";
        ls_pantalla += "</tr>";
        ls_pantalla += "<tr>";
        ls_pantalla += "<td><br><br></td>";
        ls_pantalla += "<td colspan='1'><input type='submit' name='bot_buscar' id='bot_actualizar' value='Buscar'></td>";
        ls_pantalla += "<td colspan='1'><input type='submit' name='bot_actualizar' id='bot_actualizar' value='Actualizar'></td>";
        ls_pantalla += "</tr>";
        ls_pantalla += "</table>";
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
