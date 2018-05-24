/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contabilidad;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import pkg_persistencia.TipoCuenta;

/**
 *
 * @author Steven
 */
@Stateful
public class Bean_Contabilidad implements Bean_ContabilidadLocal {

    public void InsertarTipoCuenta(String nombre) {

        String resultado="";
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1=factory.createEntityManager();   
        pkg_persistencia.TipoCuenta tc =new pkg_persistencia.TipoCuenta();
        tc.setTpCodigo("2");
        tc.setTpNombre(nombre);
        try
           {   
               
               em1.getTransaction().begin();
               em1.persist(tc);
               em1.getTransaction().commit();
               
           }
        catch (Exception ex)
           {          
               resultado=ex.getMessage();
           }
        
         em1.close();
         factory.close();
    }

    public String ExtraerCodigoCuenta(String nombre) {
        String resultado="";
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1=factory.createEntityManager();   
        pkg_persistencia.TipoCuenta tc =new pkg_persistencia.TipoCuenta();
        try
           {   
               tc=em1.find(TipoCuenta.class,"1");
               resultado=tc.getTpNombre();
               /*em1.getTransaction().begin();
               em1.persist(tc);
               em1.getTransaction().commit();*/
               
           }
        catch (Exception ex)
           {          
               resultado=ex.getMessage();
           }
        
         em1.close();
         factory.close();
        return resultado;
    }
}
