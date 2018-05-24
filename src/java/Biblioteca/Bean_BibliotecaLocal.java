/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author JONATHAN
 */
@Local
public interface Bean_BibliotecaLocal {
        public List ExtraerCodigos();
    public String BuscarCuenta(String nombre); 

    public List ExtraerCodigosLibrosNombre();
    public List ExtraerCodigosLibrosApellido();
}
