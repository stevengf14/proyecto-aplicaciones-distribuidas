/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author JONATHAN
 */
@Stateless
public class Bean_Biblioteca implements Bean_BibliotecaLocal {

    public String BuscarCuenta(String nombre) {
        List<String> lista = new ArrayList<String>();
        //String retorno="";
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        try {
            Query q = em1.createNativeQuery("SELECT AU_NOMBRE, AU_APELLIDO FROM AUTOR WHERE AU_CODIGO='" + nombre + "'");
            lista = q.getResultList();
            //ls_mensaje=String.valueOf(lista.size());
        } catch (Exception ex) {
            //ls_mensaje = ex.getMessage();
        }
        em1.close();
        factory.close();
        return lista.get(0);
    }

    @Override
    public List ExtraerCodigos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List ExtraerCodigosLibrosCodigo() {
        List<String> lista = new ArrayList<String>();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        try {
            Query q = em1.createNativeQuery("SELECT AU_CODIGO FROM AUTOR");
            lista = q.getResultList();
            //ls_mensaje=String.valueOf(lista.size());
        } catch (Exception ex) {
            //ls_mensaje = ex.getMessage();
        }
        em1.close();
        factory.close();
        return lista;
    }

    @Override
    public List ExtraerCodigosLibrosNombre() {
        List<String> lista = new ArrayList<String>();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        try {
            Query q = em1.createNativeQuery("SELECT AU_NOMBRE FROM AUTOR");
            lista = q.getResultList();
            //ls_mensaje=String.valueOf(lista.size());
        } catch (Exception ex) {
            //ls_mensaje = ex.getMessage();
        }
        em1.close();
        factory.close();
        return lista;
    }

    @Override
    public List ExtraerCodigosLibrosApellido() {
        List<String> lista = new ArrayList<String>();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        try {
            Query q = em1.createNativeQuery("SELECT AU_APELLIDO FROM AUTOR");

            lista = q.getResultList();
            //ls_mensaje=String.valueOf(lista.size());
        } catch (Exception ex) {
            //ls_mensaje = ex.getMessage();
        }
        em1.close();
        factory.close();
        return lista;
    }

    @Override
    public List ExtraerCodigosLibrosIsbn() {
        List<String> lista = new ArrayList<String>();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        try {
            Query q = em1.createNativeQuery("SELECT LIB_ISBN FROM LIBRO");
            lista = q.getResultList();
            //ls_mensaje=String.valueOf(lista.size());
        } catch (Exception ex) {
            //ls_mensaje = ex.getMessage();
        }
        em1.close();
        factory.close();
        return lista;
    }

    @Override
    public List ExtraerCodigosLibrosTitulo() {
        List<String> lista = new ArrayList<String>();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        try {
            Query q = em1.createNativeQuery("SELECT LIB_TITULO FROM LIBRO");
            lista = q.getResultList();
            //ls_mensaje=String.valueOf(lista.size());
        } catch (Exception ex) {
            //ls_mensaje = ex.getMessage();
        }
        em1.close();
        factory.close();
        return lista;
    }

    @Override
    public List ExtraerCodigosLibrosValor() {
        List<String> lista = new ArrayList<String>();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        try {
            Query q = em1.createNativeQuery("SELECT LIB_VALOR_PRESTAMO FROM LIBRO");
            lista = q.getResultList();
            //ls_mensaje=String.valueOf(lista.size());
        } catch (Exception ex) {
            //ls_mensaje = ex.getMessage();
        }
        em1.close();
        factory.close();
        return lista;
    }
}
