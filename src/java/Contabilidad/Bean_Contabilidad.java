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

    public int InsertarTipoCuenta(String nombre) {
        int retorno=0;
        List<String> lista= new ArrayList<String>();
        lista=ExtraerCodigos();
                EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
                EntityManager em1 = factory.createEntityManager();
                //pkg_persistencia.TipoCuenta tc = new pkg_persistencia.TipoCuenta();
                TipoCuenta tc= new TipoCuenta(String.valueOf(lista.size()+1));
                tc.setTpNombre(nombre);
                try {
                    em1.getTransaction().begin();
                    em1.persist(tc);
                    em1.getTransaction().commit();
                    retorno=1;
                } catch (Exception ex) {
                    retorno=0;
                }

                em1.close();
                factory.close();
                return retorno;
    }
    public List ExtraerCodigos()
    {
        List<String> lista= new ArrayList<String>();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
                EntityManager em1 = factory.createEntityManager();
                try
                {
                    Query q = em1.createNativeQuery("SELECT TP_NOMBRE FROM TIPO_CUENTA");
                    
                    lista=q.getResultList();
                    //ls_mensaje=String.valueOf(lista.size());
                }
                catch (Exception ex) {
                    //ls_mensaje = ex.getMessage();
                }
                em1.close();
                factory.close();
                return lista;
    }
    public String BuscarCuenta(String nombre) {
        List<String> lista= new ArrayList<String>();
        //String retorno="";
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
                EntityManager em1 = factory.createEntityManager();
                try
                {
                    Query q = em1.createNativeQuery("SELECT TP_CODIGO FROM TIPO_CUENTA WHERE TP_NOMBRE='"+nombre+"'");
                    lista=q.getResultList();
                    //ls_mensaje=String.valueOf(lista.size());
                }
                catch (Exception ex) {
                    //ls_mensaje = ex.getMessage();
                }
                em1.close();
                factory.close();
                return lista.get(0);
    }
}
