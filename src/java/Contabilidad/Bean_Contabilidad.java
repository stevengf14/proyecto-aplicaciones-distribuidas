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
import pkg_persistencia.Cuenta;
import pkg_persistencia.TipoCuenta;

/**
 *
 * @author Steven
 */
@Stateful
public class Bean_Contabilidad implements Bean_ContabilidadLocal {

    public boolean verificarTipoCuenta(String nombre) {
        boolean val = false;
        List<String> lista = new ArrayList<String>();
        //String retorno="";
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        try {
            Query q = em1.createNativeQuery("SELECT TP_CODIGO FROM TIPO_CUENTA WHERE TP_NOMBRE='" + nombre + "'");
            lista = q.getResultList();
            //ls_mensaje=String.valueOf(lista.size());
        } catch (Exception ex) {
            //ls_mensaje = ex.getMessage();
        }
        em1.close();
        factory.close();
        if (lista.size() != 0) {
            val = true;
        } else {
            val = false;
        }
        return val;
    }

    public int InsertarTipoCuenta(String nombre) {
        int retorno = 0;
        List<String> lista = new ArrayList<String>();
        lista = ExtraerTipoCodigos();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        //pkg_persistencia.TipoCuenta tc = new pkg_persistencia.TipoCuenta();
        TipoCuenta tc = new TipoCuenta(String.valueOf(lista.size() + 1));
        tc.setTpNombre(nombre);
        try {
            em1.getTransaction().begin();
            em1.persist(tc);
            em1.getTransaction().commit();
            retorno = 1;
        } catch (Exception ex) {
            retorno = 0;
        }

        em1.close();
        factory.close();
        return retorno;
    }

    public List ExtraerTipoCodigos() {
        List<String> lista = new ArrayList<String>();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        try {
            Query q = em1.createNativeQuery("SELECT TP_NOMBRE FROM TIPO_CUENTA");

            lista = q.getResultList();
            //ls_mensaje=String.valueOf(lista.size());
        } catch (Exception ex) {
            //ls_mensaje = ex.getMessage();
        }
        em1.close();
        factory.close();
        return lista;
    }

    public String BuscarTipoCuenta(String nombre) {
        List<String> lista = new ArrayList<String>();
        //String retorno="";
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        try {
            Query q = em1.createNativeQuery("SELECT TP_CODIGO FROM TIPO_CUENTA WHERE TP_NOMBRE='" + nombre + "'");
            lista = q.getResultList();
            //ls_mensaje=String.valueOf(lista.size());
        } catch (Exception ex) {
            //ls_mensaje = ex.getMessage();
        }
        em1.close();
        factory.close();
        return lista.get(0);
    }

    public int ModificarTipoCuenta(String nombre, String cambio) {
        int retorno = 0;
        String tp_codigo=BuscarTipoCuenta(nombre);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        TipoCuenta tc= new TipoCuenta(tp_codigo);
        try {
            tc = em1.find(TipoCuenta.class, nombre);
            em1.getTransaction().begin();
            tc.setTpNombre(cambio);

            em1.persist(tc);
            em1.getTransaction().commit();
            retorno = 1;
        } catch (Exception ex) {
            retorno = 0;
            //ls_mensaje = ex.getMessage();
        }
        em1.close();
        factory.close();
        return retorno;
    }

    public int EliminarTipoCuenta(String nombre) {
        int retorno = 0;
        String tp_codigo=BuscarTipoCuenta(nombre);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        
        try {
            TipoCuenta tc= new TipoCuenta();
            tc = em1.find(TipoCuenta.class, tp_codigo);
            em1.getTransaction().begin();
            em1.remove(tc);
            em1.getTransaction().commit();
            retorno = 1;
        } catch (Exception ex) {
            retorno = 0;
            //ls_mensaje = ex.getMessage();
        }
        em1.close();
        factory.close();
        return retorno;
    }

    /*CUENTAS*/
    public boolean verificarCuenta(String nombre) {
        boolean val = false;
        List<String> lista = new ArrayList<String>();
        //String retorno="";
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        try {
            Query q = em1.createNativeQuery("SELECT C_CODIGO FROM CUENTA WHERE C_NOMBRE='" + nombre + "'");
            lista = q.getResultList();
            //ls_mensaje=String.valueOf(lista.size());
        } catch (Exception ex) {
            //ls_mensaje = ex.getMessage();
        }
        em1.close();
        factory.close();
        if (lista.size() != 0) {
            val = true;
        } else {
            val = false;
        }
        return val;
    }

    /*public int InsertarCuenta(String nombre, String tp_nombre) {
        int retorno=0;
        List<String> lista = new ArrayList<String>();
        lista = ExtraerCodigos();
        String tp_codigo = BuscarTipoCuenta(tp_nombre);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        int num = lista.size() + 1;
        try {
            
            //Query q = em1.createNativeQuery("INSERT INTO CUENTA (C_CODIGO,TP_CODIGO,C_NOMBRE) VALUES('" + num + "','" + tp_codigo + "','" + nombre + "');");
            Query q = em1.createNativeQuery("INSERT INTO DISTRIBUIDAS.CUENTA (C_CODIGO,TP_CODIGO,C_NOMBRE) VALUES('3','2','deudas')");
            retorno=q.executeUpdate();
            retorno=1;
            
        } catch (Exception e) {
            retorno = 0;
        }
        
        return retorno;
    }*/

    public int InsertarCuenta(String nombre, String tp_nombre) {
        int retorno = 0;
        List<String> lista = new ArrayList<String>();
        lista = ExtraerCodigos();
        int num = lista.size() + 1;
        String tpCodigo=BuscarTipoCuenta(tp_nombre);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        //pkg_persistencia.TipoCuenta tc = new pkg_persistencia.TipoCuenta();
        Cuenta c = new Cuenta();
        c.setCCodigo(String.valueOf(num));
        c.setCNombre(nombre);
        c.setTpCodigo(tpCodigo);
        try {
            em1.getTransaction().begin();
            em1.persist(c);
            em1.getTransaction().commit();
            retorno = 1;
        } catch (Exception ex) {
            retorno = 0;
            ex.getMessage();
        }

        em1.close();
        factory.close();
        return retorno;
    }

    public List ExtraerCodigos() {
        List<String> lista = new ArrayList<String>();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        try {
            Query q = em1.createNativeQuery("SELECT C_NOMBRE FROM CUENTA");

            lista = q.getResultList();
            //ls_mensaje=String.valueOf(lista.size());
        } catch (Exception ex) {
            //ls_mensaje = ex.getMessage();
        }
        em1.close();
        factory.close();
        return lista;
    }

    public String BuscarCuenta(String nombre) {
        List<String> lista = new ArrayList<String>();
        //String retorno="";
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        try {
            Query q = em1.createNativeQuery("SELECT C_CODIGO FROM CUENTA WHERE C_NOMBRE='" + nombre + "'");
            lista = q.getResultList();
            //ls_mensaje=String.valueOf(lista.size());
        } catch (Exception ex) {
            //ls_mensaje = ex.getMessage();
        }
        em1.close();
        factory.close();
        return lista.get(0);
    }

    public int ModificarCuenta(String nombre) {
        int retorno = 0;
        String codigo = BuscarTipoCuenta(nombre);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        //pkg_persistencia.TipoCuenta tc = new pkg_persistencia.TipoCuenta();
        Cuenta c = new Cuenta();

        try {
            c = em1.find(Cuenta.class, codigo);
            c.setCNombre(nombre);
            em1.getTransaction().begin();
            em1.persist(c);
            em1.getTransaction().commit();
            retorno = 1;
        } catch (Exception ex) {
            retorno = 0;
        }

        em1.close();
        factory.close();
        return retorno;
    }

    public int Eliminaruenta(String nombre) {
        int retorno = 0;
        String codigo = BuscarTipoCuenta(nombre);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        try {
            Query q = em1.createNativeQuery("DELETE FROM CUENTA WHERE C_CODIGO='" + codigo + "'");
            q.executeUpdate();
            retorno = 1;
            //ls_mensaje=String.valueOf(lista.size());
        } catch (Exception ex) {
            retorno = 0;
            //ls_mensaje = ex.getMessage();
        }

        em1.close();
        factory.close();
        return retorno;
    }
}
