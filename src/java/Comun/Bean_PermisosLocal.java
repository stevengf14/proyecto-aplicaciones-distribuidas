/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comun;

import javax.ejb.Local;

/**
 *
 * @author Steven
 */
@Local
public interface Bean_PermisosLocal {
    public String asignar_permiso(String con, String bib, String nom, String usu);
    
}
