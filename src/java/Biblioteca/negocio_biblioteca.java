/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author JONATHAN
 */
@ManagedBean()
@SessionScoped

public class negocio_biblioteca {

    int ii_retorno;
    @EJB
    Bean_BibliotecaLocal beanBiblioteca;

    public int insertarAutor(String nombre, String apellido) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();          
        List lista2 = new ArrayList<String>();
        lista2 = beanBiblioteca.ExtraerCodigosLibrosCodigo();
        Biblioteca.Autor ar = new Biblioteca.Autor("00"+lista2.size()+"a");        
        //ar.setAuCodigo(codigo);
        ar.setAuNombre(nombre);
        ar.setAuApellido(apellido);
        try {
            em1.getTransaction().begin();
            em1.persist(ar);
            em1.getTransaction().commit();
            ii_retorno = 1;
        } catch (Exception ex) {
            ii_retorno = -1;
        }
        em1.close();
        factory.close();
        /*
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
                EntityManager em1 = factory.createEntityManager();
                Autor pr = new Autor(ls_codigo);
                pr.setAuNombre(ls_nombre);
                pr.setAuApellido(ls_apellifo);
                try {
                    em1.getTransaction().begin();
                    em1.persist(pr);
                    em1.getTransaction().commit();
                    is_pantalla = desplegar_pantalla_confirmacion();
                } catch (Exception ex) {
                    //ls_mensaje = "El error es: " + ex.getMessage();
                    is_pantalla = desplegar_pantallaIngreso("", "", "");
                    ls_mensaje = "Inserción Incorrecta";
                }
                em1.close();
                factory.close();
        
        */
        
        
        return ii_retorno;
    }

    public int modificarAutor(String codigo, String nombre, String apellido) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        Biblioteca.Autor ar = new Biblioteca.Autor();
        try {
            ar = em1.find(Autor.class, codigo);
            em1.getTransaction().begin();
            if ("".equals(nombre)) {
                ar.setAuApellido(apellido);
            } else if (apellido == "") {
                ar.setAuNombre(nombre);
            } else {
                ar.setAuNombre(nombre);
                ar.setAuApellido(apellido);
            }
            em1.persist(ar);
            em1.getTransaction().commit();
            ii_retorno = 1;
        } catch (Exception ex) {
            ii_retorno = -1;
        }
        em1.close();
        factory.close();
        return ii_retorno;
    }

    public String buscarAutor(String codigo) {
        String ls_codigo;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        Autor ar = new Autor();
        try {
            ar = em1.find(Autor.class, codigo);
            ls_codigo = ar.getAuCodigo();
        } catch (Exception ex) {
            ls_codigo = "no hay chance";
        }
        em1.close();
        factory.close();
        return ls_codigo;
    }

    public int eliminarAutor(String codigo) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        Biblioteca.Autor ar = new Biblioteca.Autor();
        ar.setAuCodigo(codigo);
        try {
            ar = em1.find(Autor.class, codigo);
            em1.getTransaction().begin();
            em1.remove(ar);
            em1.getTransaction().commit();
            ii_retorno = 1;
        } catch (Exception ex) {
            ii_retorno = -1;
        }
        em1.close();
        factory.close();
        return ii_retorno;
    }

}
