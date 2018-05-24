/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contabilidad;

import javax.ejb.Local;

/**
 *
 * @author Steven
 */
@Local
public interface Bean_ContabilidadLocal {
    public void InsertarTipoCuenta(String nombre);
    public String ExtraerCodigoCuenta(String nombre);
}
