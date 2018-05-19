/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comun;

import javax.ejb.Stateful;

/**
 *
 * @author Steven
 */
@Stateful
public class Bean_Permisos implements Bean_PermisosLocal {

    public String asignar_permiso(String con, String bib, String nom, String usu) {
        String permiso = "";
        if (con != null && usu != null && bib != null && nom != null) {
            permiso = "13";
        } else if (usu != null && bib != null && nom != null) {
            permiso = "12";

        } else if (usu != null && bib != null && con != null) {
            permiso = "11";
        } else if (usu != null && con != null && nom != null) {
            permiso = "10";
        } else if (con != null && bib != null && nom != null) {
            permiso = "6";
        } else if (usu != null && bib != null) {
            permiso = "9";
        } else if (nom != null && usu != null) {
            permiso = "8";
        } else if (con != null && usu != null) {
            permiso = "7";
        } else if (nom != null && bib != null) {
            permiso = "5";
        } else if (con != null && bib != null) {
            permiso = "4";
        } else if (con != null && nom != null) {
            permiso = "3";
        } else if (bib != null) {
            permiso = "2";
        } else if (nom != null) {
            permiso = "1";
        } else if (con != null) {
            permiso = "0";
        } else if (usu != null) {
            permiso = "14";
        } else {
            permiso = "Se debe asignar permiso al menos a un módulo";
        }
        return permiso;
    }
}
