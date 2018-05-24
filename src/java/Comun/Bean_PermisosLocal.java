/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comun;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Steven
 */
@Local
public interface Bean_PermisosLocal {
    public String asignar_permiso(String con, String bib, String nom, String usu);
    public List ExtraerUsuarios();
    public boolean VerificarUsuario(String usu, String contra);
    public int InsertarUsuario(String nombres,String apellidos,String usuario,String contrasenia);
    public int ModificarPermisos(String usuario, String permisos);
    public int InsertarUsuarioActivo(String usuario);
    public List ExtraerActivo();
    public boolean validarVentana(String ventana);
    public String ExtraerUsuarioActivo();
    public String ExtraerPermisoUsuarioActivo(String codigo);
    public String UsuarioActivo();
}
