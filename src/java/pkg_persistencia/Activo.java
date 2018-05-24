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
@Table(name = "ACTIVO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Activo.findAll", query = "SELECT a FROM Activo a")
    , @NamedQuery(name = "Activo.findByUsuUsuario", query = "SELECT a FROM Activo a WHERE a.usuUsuario = :usuUsuario")
    , @NamedQuery(name = "Activo.findByUsuPermisos", query = "SELECT a FROM Activo a WHERE a.usuPermisos = :usuPermisos")
    , @NamedQuery(name = "Activo.findByUCodigo", query = "SELECT a FROM Activo a WHERE a.uCodigo = :uCodigo")})
public class Activo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USU_USUARIO")
    private String usuUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "USU_PERMISOS")
    private String usuPermisos;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "U_CODIGO")
    private String uCodigo;

    public Activo() {
    }

    public Activo(String uCodigo) {
        this.uCodigo = uCodigo;
    }

    public Activo(String uCodigo, String usuUsuario, String usuPermisos) {
        this.uCodigo = uCodigo;
        this.usuUsuario = usuUsuario;
        this.usuPermisos = usuPermisos;
    }

    public String getUsuUsuario() {
        return usuUsuario;
    }

    public void setUsuUsuario(String usuUsuario) {
        this.usuUsuario = usuUsuario;
    }

    public String getUsuPermisos() {
        return usuPermisos;
    }

    public void setUsuPermisos(String usuPermisos) {
        this.usuPermisos = usuPermisos;
    }

    public String getUCodigo() {
        return uCodigo;
    }

    public void setUCodigo(String uCodigo) {
        this.uCodigo = uCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uCodigo != null ? uCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Activo)) {
            return false;
        }
        Activo other = (Activo) object;
        if ((this.uCodigo == null && other.uCodigo != null) || (this.uCodigo != null && !this.uCodigo.equals(other.uCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkg_persistencia.Activo[ uCodigo=" + uCodigo + " ]";
    }
    
}
