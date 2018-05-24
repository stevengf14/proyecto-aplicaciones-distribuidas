/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca;

import java.math.BigDecimal;
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
    
    public int insertarAutor(String codigo, String nombre, String apellido) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        Biblioteca.Autor ar = new Biblioteca.Autor();
        ar.setAuCodigo(codigo);
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
    
    public int insertarLibro(String isbn, String titulo, String autor,BigDecimal valor_prestamo) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        Biblioteca.Libro lr = new Biblioteca.Libro();
        lr.setLibIsbn(isbn);
        lr.setLibTitulo(titulo);
        lr.setAuCodigo(autor);    
        lr.setLibValorPrestamo(valor_prestamo);
        try {
            em1.getTransaction().begin();
            em1.persist(lr);
            em1.getTransaction().commit();
            ii_retorno = 1;
        } catch (Exception ex) {
            ii_retorno = -1;
        }
        em1.close();
        factory.close();
        return ii_retorno;
    }
    
    public int modificarLibro(String isbn, String titulo, String autor,BigDecimal valor_prestamo) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        Biblioteca.Libro lr = new Biblioteca.Libro();
        try {
            lr = em1.find(Libro.class, isbn);
            em1.getTransaction().begin();
            if ("".equals(titulo)) {
                lr.setAuCodigo(autor);
                lr.setLibValorPrestamo(valor_prestamo);
            } else if (autor.toString() == "") {
                lr.setLibTitulo(titulo);                
                lr.setLibValorPrestamo(valor_prestamo);
            } else if (valor_prestamo.toString() == "") {
                lr.setLibTitulo(titulo);   
                lr.setAuCodigo(autor);
            }else {
                lr.setLibTitulo(titulo);   
                lr.setAuCodigo(autor);                
                lr.setLibValorPrestamo(valor_prestamo);
            }
            em1.persist(lr);
            em1.getTransaction().commit();
            ii_retorno = 1;
        } catch (Exception ex) {
            ii_retorno = -1;
        }
        em1.close();
        factory.close();
        return ii_retorno;
    }

    public String buscarLibro(String isbn) {
        String ls_isbn;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        Biblioteca.Libro lr = new Biblioteca.Libro();
        try {
            lr = em1.find(Libro.class, isbn);
            ls_isbn = lr.getLibIsbn();
        } catch (Exception ex) {
            ls_isbn = null;
        }
        em1.close();
        factory.close();
        return ls_isbn;
    }
    
    public int eliminarLibro(String isbn) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        Biblioteca.Libro lr = new Biblioteca.Libro();
        lr.setLibIsbn(isbn);
        try {
            lr = em1.find(Libro.class, isbn);
            em1.getTransaction().begin();
            em1.remove(lr);
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
