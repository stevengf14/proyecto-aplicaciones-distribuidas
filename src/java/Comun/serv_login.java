/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comun;

import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Steven
 */
@WebServlet(name = "serv_comun", urlPatterns = {"/serv_comun"})
public class serv_login extends HttpServlet {

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
        is_boton = request.getParameter("boton");
        is_pantalla = desplegarPantallaLogin();
  /*     if (is_boton == null || is_boton == "") {
            is_pantalla = desplegarPantallaLogin();
        }

        if (is_boton != null && is_boton != "") {

            if (is_boton.equals("Ingresar")) {
                String ls_usuario = "";
                String ls_contrasenia = "";
                ls_usuario = request.getParameter("usuario");
                ls_contrasenia = request.getParameter("contrasenia");

                if (ls_usuario.equals("steven") && ls_contrasenia.equals("1234")) {
                    is_pantalla = "";
                    RequestDispatcher rd = request.getRequestDispatcher("/serv_menu.java");
                    rd.forward(request, response);
                } else {
                    is_pantalla = desplegarPantallaLogin() + ("<p style=\"color: #F6DAD4\">Usuario o Contrasenia Incorrectos!</p>");
                }
            }
        }*/

        out.println(is_pantalla);
    }

    public String desplegarPantallaLogin() {
        String ls_pantalla = "";
        ls_pantalla += ("<!DOCTYPE html>");
        ls_pantalla += ("<html>");
        ls_pantalla += ("<head>");
        ls_pantalla += ("<title>Servlet serv_comun</title>");
        ls_pantalla += "<style type='text/css'>";
        ls_pantalla += "@import url(https://fonts.googleapis.com/css?family=Open+Sans);\n"
                + ".btn { display: inline-block; *display: inline; *zoom: 1; padding: 4px 10px 4px; margin-bottom: 0; font-size: 13px; line-height: 18px; color: #333333; text-align: center;text-shadow: 0 1px 1px rgba(255, 255, 255, 0.75); vertical-align: middle; background-color: #f5f5f5; background-image: -moz-linear-gradient(top, #ffffff, #e6e6e6); background-image: -ms-linear-gradient(top, #ffffff, #e6e6e6); background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#ffffff), to(#e6e6e6)); background-image: -webkit-linear-gradient(top, #ffffff, #e6e6e6); background-image: -o-linear-gradient(top, #ffffff, #e6e6e6); background-image: linear-gradient(top, #ffffff, #e6e6e6); background-repeat: repeat-x; filter: progid:dximagetransform.microsoft.gradient(startColorstr=#ffffff, endColorstr=#e6e6e6, GradientType=0); border-color: #e6e6e6 #e6e6e6 #e6e6e6; border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.25); border: 1px solid #e6e6e6; -webkit-border-radius: 4px; -moz-border-radius: 4px; border-radius: 4px; -webkit-box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05); -moz-box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05); box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05); cursor: pointer; *margin-left: .3em; }\n"
                + ".btn:hover, .btn:active, .btn.active, .btn.disabled, .btn[disabled] { background-color: #e6e6e6; }\n"
                + ".btn-large { padding: 9px 14px; font-size: 15px; line-height: normal; -webkit-border-radius: 5px; -moz-border-radius: 5px; border-radius: 5px; }\n"
                + ".btn:hover { color: #333333; text-decoration: none; background-color: #e6e6e6; background-position: 0 -15px; -webkit-transition: background-position 0.1s linear; -moz-transition: background-position 0.1s linear; -ms-transition: background-position 0.1s linear; -o-transition: background-position 0.1s linear; transition: background-position 0.1s linear; }\n"
                + ".btn-primary, .btn-primary:hover { text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25); color: #ffffff; }\n"
                + ".btn-primary.active { color: rgba(255, 255, 255, 0.75); }\n"
                + ".btn-primary { background-color: #4a77d4; background-image: -moz-linear-gradient(top, #6eb6de, #4a77d4); background-image: -ms-linear-gradient(top, #6eb6de, #4a77d4); background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#6eb6de), to(#4a77d4)); background-image: -webkit-linear-gradient(top, #6eb6de, #4a77d4); background-image: -o-linear-gradient(top, #6eb6de, #4a77d4); background-image: linear-gradient(top, #6eb6de, #4a77d4); background-repeat: repeat-x; filter: progid:dximagetransform.microsoft.gradient(startColorstr=#6eb6de, endColorstr=#4a77d4, GradientType=0);  border: 1px solid #3762bc; text-shadow: 1px 1px 1px rgba(0,0,0,0.4); box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.5); }\n"
                + ".btn-primary:hover, .btn-primary:active, .btn-primary.active, .btn-primary.disabled, .btn-primary[disabled] { filter: none; background-color: #4a77d4; }\n"
                + ".btn-block { width: 100%; display:block; }\n"
                + "\n"
                + "* { -webkit-box-sizing:border-box; -moz-box-sizing:border-box; -ms-box-sizing:border-box; -o-box-sizing:border-box; box-sizing:border-box; }\n"
                + "\n"
                + "html { width: 100%; height:100%; overflow:hidden; }\n"
                + "\n"
                + "body { \n"
                + "	width: 100%;\n"
                + "	height:100%;\n"
                + "	font-family: 'Open Sans', sans-serif;\n"
                + "	background: #092756;\n"
                + "	background: -moz-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%),-moz-linear-gradient(top,  rgba(57,173,219,.25) 0%, rgba(42,60,87,.4) 100%), -moz-linear-gradient(-45deg,  #670d10 0%, #092756 100%);\n"
                + "	background: -webkit-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), -webkit-linear-gradient(top,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), -webkit-linear-gradient(-45deg,  #670d10 0%,#092756 100%);\n"
                + "	background: -o-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), -o-linear-gradient(top,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), -o-linear-gradient(-45deg,  #670d10 0%,#092756 100%);\n"
                + "	background: -ms-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), -ms-linear-gradient(top,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), -ms-linear-gradient(-45deg,  #670d10 0%,#092756 100%);\n"
                + "	background: -webkit-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), linear-gradient(to bottom,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), linear-gradient(135deg,  #670d10 0%,#092756 100%);\n"
                + "	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#3E1D6D', endColorstr='#092756',GradientType=1 );\n"
                + "}\n"
                + ".login { \n"
                + "	position: absolute;\n"
                + "	top: 50%;\n"
                + "	left: 50%;\n"
                + "	margin: -150px 0 0 -150px;\n"
                + "	width:300px;\n"
                + "	height:300px;\n"
                + "}\n"
                + ".login h1 { color: #fff; text-shadow: 0 0 10px rgba(0,0,0,0.3); letter-spacing:1px; text-align:center; }\n"
                + "\n"
                + "input { \n"
                + "	width: 100%; \n"
                + "	margin-bottom: 10px; \n"
                + "	background: rgba(0,0,0,0.3);\n"
                + "	border: none;\n"
                + "	outline: none;\n"
                + "	padding: 10px;\n"
                + "	font-size: 13px;\n"
                + "	color: #fff;\n"
                + "	text-shadow: 1px 1px 1px rgba(0,0,0,0.3);\n"
                + "	border: 1px solid rgba(0,0,0,0.3);\n"
                + "	border-radius: 4px;\n"
                + "	box-shadow: inset 0 -5px 45px rgba(100,100,100,0.2), 0 1px 1px rgba(255,255,255,0.2);\n"
                + "	-webkit-transition: box-shadow .5s ease;\n"
                + "	-moz-transition: box-shadow .5s ease;\n"
                + "	-o-transition: box-shadow .5s ease;\n"
                + "	-ms-transition: box-shadow .5s ease;\n"
                + "	transition: box-shadow .5s ease;\n"
                + "}\n"
                + "input:focus { box-shadow: inset 0 -5px 45px rgba(100,100,100,0.4), 0 1px 1px rgba(255,255,255,0.2); }";
        ls_pantalla += "</style>";
        ls_pantalla += "<script type=\"text/javascript\">"
                + "function abrirVentana(url) "
                + "{"
                + "var usuario;"
                + "usuario=document.getElementById('usuario').value;"
                + "var contrasenia;"
                + "contrasenia=document.getElementById('contrasenia').value;"
                + "var us;"
                + "us='steven';"
                + "var cont;"
                + "cont='1234';"
                + "if(usuario==us)"
                + "{"
                //+"location.replace('serv_menu');"
                + "window.open(url);\n"
                +"}"
                +"else"
                + "{"
                + "alert('Usuario y/o contrasenia incorrectos');"
                + "}"
                + "}" + "</script>";
        ls_pantalla += ("</head>");
        ls_pantalla += ("<body>");
        //ls_pantalla+="<div class="'wrapper'"><div class="'container'">Welcome</h1><form class="'form'"><input type="'text'" placeholder="'Username'"><input type="'password'" placeholder="'Password'"><button type=\"submit\" id=\"login-button\">Login</button></form></div><ul class=\"bg-bubbles\"><li></li><li></li><li></li><li></li><li></li><li></li><li></li><li></li><li></li><li></li></ul></div>";
        ls_pantalla += "<form class='login' id='div1' name='div'>";
        ls_pantalla += "<h1>Login</h1>";
        ls_pantalla += "<input type='text' name='usuario' id='usuario' placeholder='Usuario' required='required' />";
        ls_pantalla += "<input type='password' name='contrasenia' id='contrasenia' placeholder='Contrasenia' required='required' />";
        //ls_pantalla += "<a href='http://localhost:8080/distribuidas/serv_menu'><input type='submit' class='btn btn-primary btn-block btn-large' name='boton' value='Ingresar'></a>";
        ls_pantalla += "<input type='submit' class='btn btn-primary btn-block btn-large' name='boton' onClick=abrirVentana('http://localhost:8080/distribuidas/serv_menu') value='Ingresar'>";
        ls_pantalla += "<a href='http://localhost:8080/distribuidas/serv_usuarios'>Crear usuario</a>";
        ls_pantalla += "</form>";

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
