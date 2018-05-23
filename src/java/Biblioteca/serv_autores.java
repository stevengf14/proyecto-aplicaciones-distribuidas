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
@WebServlet(name = "serv_menu_biblioteca", urlPatterns = {"/serv_menu_biblioteca"})
public class serv_autores extends HttpServlet {

    String ls_mensaje = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String is_pantalla = "";
        is_pantalla = desplegar_pantalla("", "", "", "3");
        out.println(is_pantalla);
    }

    public String desplegar_pantalla(String codigo, String nombre, String apellido, String numero) {
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
        ls_pantalla += "<li><a href='#'>Categoria</a></li>";
        ls_pantalla += "<li><a href='#'>Categoria 2</a></li>";
        ls_pantalla += "<li><a href='#'>Categoria 3</a></li>";
        ls_pantalla += "</ul>";
        ls_pantalla += "</nav>";
        ls_pantalla += "</header>";
        ls_pantalla += "<table width='50%' border='1' align='center' id='tabla'>";
        ls_pantalla += "<tr>";
        ls_pantalla += "<td class='primera_fila'>Código</td>";
        ls_pantalla += "<td class='primera_fila'>Nombre</td>";
        ls_pantalla += "<td class='primera_fila'>Apellido</td>";
        ls_pantalla += "</tr>";
        ls_pantalla += "<tr>";
        ls_pantalla += "<td><input type='text' size='20' class='centrado'  paddding=10px name='codigo_libro' " + "value='" + codigo + "'></input></td>";
        ls_pantalla += "<td><input type='text' size='20' class='centrado' paddding=10px name='nombre' " + "value='" + nombre + "'></input></td>";
        ls_pantalla += "<td><input type='text' size='20' class='centrado' paddding=10px name='apellido' " + "value='" + apellido + "'></input></td>";
        ls_pantalla += "</tr>";
        ls_pantalla += "</table>";
        ls_pantalla += "<aside>";
        ls_pantalla += "<input type='submit' value='Insertar' name='boton'></input>";
        ls_pantalla += "<input type='submit' value='Eliminar' name='boton' ></input>";
        ls_pantalla += "<input type='submit' value='Modificar' name='boton'></input>";
        ls_pantalla += "<input type='submit' value='Buscar' name='boton'></input>";
        ls_pantalla += "</aside>";
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
