/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_persistencia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Steven
 */
@Entity
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByUsuNombres", query = "SELECT u FROM Usuario u WHERE u.usuNombres = :usuNombres")
    , @NamedQuery(name = "Usuario.findByUsuApellidos", query = "SELECT u FROM Usuario u WHERE u.usuApellidos = :usuApellidos")
    , @NamedQuery(name = "Usuario.findByUsuUsuario", query = "SELECT u FROM Usuario u WHERE u.usuUsuario = :usuUsuario")
    , @NamedQuery(name = "Usuario.findByUsuContrasenia", query = "SELECT u FROM Usuario u WHERE u.usuContrasenia = :usuContrasenia")
    , @NamedQuery(name = "Usuario.findByUsuPermisos", query = "SELECT u FROM Usuario u WHERE u.usuPermisos = :usuPermisos")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "USU_NOMBRES")
    private String usuNombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "USU_APELLIDOS")
    private String usuApellidos;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USU_USUARIO")
    private String usuUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "USU_CONTRASENIA")
    private String usuContrasenia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "USU_PERMISOS")
    private String usuPermisos;

    public Usuario() {
    }

    public Usuario(String usuUsuario) {
        this.usuUsuario = usuUsuario;
    }

    public Usuario(String usuUsuario, String usuNombres, String usuApellidos, String usuContrasenia, String usuPermisos) {
        this.usuUsuario = usuUsuario;
        this.usuNombres = usuNombres;
        this.usuApellidos = usuApellidos;
        this.usuContrasenia = usuContrasenia;
        this.usuPermisos = usuPermisos;
    }

    public String getUsuNombres() {
        return usuNombres;
    }

    public void setUsuNombres(String usuNombres) {
        this.usuNombres = usuNombres;
    }

    public String getUsuApellidos() {
        return usuApellidos;
    }

    public void setUsuApellidos(String usuApellidos) {
        this.usuApellidos = usuApellidos;
    }

    public String getUsuUsuario() {
        return usuUsuario;
    }

    public void setUsuUsuario(String usuUsuario) {
        this.usuUsuario = usuUsuario;
    }

    public String getUsuContrasenia() {
        return usuContrasenia;
    }

    public void setUsuContrasenia(String usuContrasenia) {
        this.usuContrasenia = usuContrasenia;
    }

    public String getUsuPermisos() {
        return usuPermisos;
    }

    public void setUsuPermisos(String usuPermisos) {
        this.usuPermisos = usuPermisos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuUsuario != null ? usuUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuUsuario == null && other.usuUsuario != null) || (this.usuUsuario != null && !this.usuUsuario.equals(other.usuUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkg_persistencia.Usuario[ usuUsuario=" + usuUsuario + " ]";
    }
    
}
