/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contabilidad;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Steven
 */
@Local
public interface Bean_ContabilidadLocal {

    public int InsertarTipoCuenta(String nombre);

    public String BuscarCuenta(String nombre);

    public String BuscarTipoCuenta(String nombre);
    public List ExtraerTipoCodigos();
    public int ModificarTipoCuenta(String nombre, String cambio);
    public int EliminarTipoCuenta(String nombre);
    public boolean verificarTipoCuenta(String nombre);
    
    public boolean verificarCuenta(String nombre);
    public int InsertarCuenta(String nombre, String tp_nombre);
    public List ExtraerCodigos();
    public int ModificarCuenta(String nombre);
    public int Eliminaruenta(String nombre);
}
