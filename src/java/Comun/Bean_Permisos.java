/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comun;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import pkg_persistencia.Activo;
import pkg_persistencia.Cuenta;
import pkg_persistencia.Usuario;

/**
 *
 * @author Steven
 */
@Stateful
public class Bean_Permisos implements Bean_PermisosLocal {

    public String asignar_permiso(String con, String bib, String nom, String usu) {
        String permiso = "";
        if (con != null && usu != null && bib != null && nom != null) {
            permiso = "13";
        } else if (usu != null && bib != null && nom != null) {
            permiso = "12";

        } else if (usu != null && bib != null && con != null) {
            permiso = "11";
        } else if (usu != null && con != null && nom != null) {
            permiso = "10";
        } else if (con != null && bib != null && nom != null) {
            permiso = "6";
        } else if (usu != null && bib != null) {
            permiso = "9";
        } else if (nom != null && usu != null) {
            permiso = "8";
        } else if (con != null && usu != null) {
            permiso = "7";
        } else if (nom != null && bib != null) {
            permiso = "5";
        } else if (con != null && bib != null) {
            permiso = "4";
        } else if (con != null && nom != null) {
            permiso = "3";
        } else if (bib != null) {
            permiso = "2";
        } else if (nom != null) {
            permiso = "1";
        } else if (con != null) {
            permiso = "0";
        } else if (usu != null) {
            permiso = "14";
        } else {
            permiso = "Se debe asignar permiso al menos a un módulo";
        }
        return permiso;
    }

    public List ExtraerUsuarios() {
        List<String> lista = new ArrayList<String>();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        try {
            Query q = em1.createNativeQuery("SELECT USU_USUARIO FROM USUARIO");

            lista = q.getResultList();
            //ls_mensaje=String.valueOf(lista.size());
        } catch (Exception ex) {
            //ls_mensaje = ex.getMessage();
        }
        em1.close();
        factory.close();
        return lista;
    }

    public boolean VerificarUsuario(String usu, String contra) {
        boolean val = false;
        List<String> usuario = new ArrayList<String>();
        List<String> contrasenia = new ArrayList<String>();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        try {
            Query q = em1.createNativeQuery("SELECT USU_USUARIO FROM USUARIO WHERE USU_USUARIO='" + usu + "'");
            Query q2 = em1.createNativeQuery("SELECT USU_CONTRASENIA FROM USUARIO WHERE USU_USUARIO='" + usu + "'");
            usuario = q.getResultList();
            contrasenia = q2.getResultList();
            if (usuario.size() != 0 && contrasenia.size() != 0) {
                val = true;
            } else {
                val = false;
            }
            //ls_mensaje=String.valueOf(lista.size());
        } catch (Exception ex) {
            //ls_mensaje = ex.getMessage();
            val = false;
        }
        em1.close();
        factory.close();
        return val;
    }

    public int InsertarUsuario(String nombres, String apellidos, String usuario, String contrasenia) {
        int retorno = 0;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        //pkg_persistencia.TipoCuenta tc = new pkg_persistencia.TipoCuenta();
        Usuario u = new Usuario();
        u.setUsuUsuario(usuario);
        u.setUsuNombres(nombres);
        u.setUsuApellidos(apellidos);
        u.setUsuContrasenia(contrasenia);
        u.setUsuPermisos("10");
        try {
            em1.getTransaction().begin();
            em1.persist(u);
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

    public int ModificarPermisos(String usuario, String permisos) {
        int resultado = 0;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        Usuario u = new Usuario(usuario);
        try {
            u = em1.find(Usuario.class, usuario);
            em1.getTransaction().begin();
            u.setUsuPermisos(permisos);

            em1.persist(u);
            em1.getTransaction().commit();
            resultado = 1;
        } catch (Exception e) {
            resultado = 0;
        }
        em1.close();
        factory.close();
        return resultado;
    }
    
    public int InsertarUsuarioActivo(String usuario) {
        int retorno=0;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        //pkg_persistencia.TipoCuenta tc = new pkg_persistencia.TipoCuenta();
        
        
        try {
            String permisos = ExtraerPermisos(usuario);
        List<String> lista = new ArrayList<String>();
            lista = ExtraerActivo();
        int num = lista.size() + 1;
        Activo a = new Activo();
        a.setUsuUsuario(usuario);
        a.setUsuPermisos(permisos);
        a.setUCodigo(String.valueOf(num));
            em1.getTransaction().begin();
            em1.persist(a);
            em1.getTransaction().commit();
            retorno=1;
        } catch (Exception ex) {
            retorno=0;
            ex.getMessage();
        }
        
        em1.close();
        factory.close();
        return retorno;
    }

    public List ExtraerActivo() {
        List<String> lista = new ArrayList<String>();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        try {
            Query q = em1.createNativeQuery("SELECT U_CODIGO FROM ACTIVO");

            lista = q.getResultList();
            //ls_mensaje=String.valueOf(lista.size());
        } catch (Exception ex) {
            //ls_mensaje = ex.getMessage();
        }
        em1.close();
        factory.close();
        return lista;
    }
    public String UsuarioActivo()
    {
        List<String> lista = new ArrayList<String>();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        try {
            Query q = em1.createNativeQuery("SELECT USU_USUARIO FROM ACTIVO WHERE U_CODIGO='"+ExtraerUsuarioActivo()+"'");

            lista = q.getResultList();
            //ls_mensaje=String.valueOf(lista.size());
        } catch (Exception ex) {
            //ls_mensaje = ex.getMessage();
        }
        em1.close();
        factory.close();
        return lista.get(0);
    }

    public String ExtraerPermisos(String usuario) {
        List<String> lista = new ArrayList<String>();
        //String retorno="";
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        try {
            Query q = em1.createNativeQuery("SELECT USU_USUARIO FROM ACTIVO WHERE USU_USUARIO='" + usuario + "'");
            lista = q.getResultList();
        } catch (Exception ex) {
            //ls_mensaje = ex.getMessage();
        }
        em1.close();
        factory.close();
        return lista.get(0);
    }

    public boolean validarVentana(String ventana) {
        boolean val=false;
        String codigo = ExtraerUsuarioActivo();
        int permiso = Integer.parseInt(ExtraerPermisoUsuarioActivo(codigo));
        if (ventana.equals("Nómina")) {
            if(permiso==1 || permiso ==5 || permiso==6 || permiso==8 || permiso==10 || permiso==12 || permiso==13)
                val=true;
            else
                val=false;
        }
        else if(ventana.equals("Contabilidad"))
        {
            if(permiso==0 || permiso ==3 || permiso==4 || permiso==6 || permiso==7 || permiso==10 || permiso==11|| permiso==13)
                val=true;
            else
                val=false;
        }
        else if(ventana.equals("Biblioteca"))
        {
            if(permiso==2 || permiso ==4 || permiso==5 || permiso==6 || permiso==9 || permiso==11 || permiso==12 || permiso==13)
                val=true;
            else
                val=false;
        }
        else if(ventana.equals("Usuarios"))
        {
            if(permiso==7|| permiso ==8 || permiso==9 || permiso==10 || permiso==11 || permiso==12 || permiso==13|| permiso==14)
                val=true;
            else
                val=false;
        }
        return val;

    }

    public String ExtraerUsuarioActivo() {
        List<String> lista = new ArrayList<String>();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        try {
            Query q = em1.createNativeQuery("SELECT MAX(U_CODIGO) FROM ACTIVO");

            lista = q.getResultList();
            //ls_mensaje=String.valueOf(lista.size());
        } catch (Exception ex) {
            //ls_mensaje = ex.getMessage();
        }
        em1.close();
        factory.close();
        return lista.get(0);
    }

    public String ExtraerPermisoUsuarioActivo(String codigo) {
        List<String> lista = new ArrayList<String>();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("proyecto_distribuidasPU");
        EntityManager em1 = factory.createEntityManager();
        try {
            Query q = em1.createNativeQuery("SELECT USU_PERMISOS FROM ACTIVO WHERE U_CODIGO='" + codigo + "'");

            lista = q.getResultList();
            //ls_mensaje=String.valueOf(lista.size());
        } catch (Exception ex) {
            //ls_mensaje = ex.getMessage();
        }
        em1.close();
        factory.close();
        return lista.get(0);
    }
}
