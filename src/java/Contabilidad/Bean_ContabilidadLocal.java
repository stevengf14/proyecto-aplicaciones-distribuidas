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
    public List ExtraerCodigos();
}
