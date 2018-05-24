/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_persistencia;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Steven
 */
@Entity
@Table(name = "PRESTAMO_CABECERA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrestamoCabecera.findAll", query = "SELECT p FROM PrestamoCabecera p")
    , @NamedQuery(name = "PrestamoCabecera.findByPcNombre", query = "SELECT p FROM PrestamoCabecera p WHERE p.pcNombre = :pcNombre")
    , @NamedQuery(name = "PrestamoCabecera.findByPcFecha", query = "SELECT p FROM PrestamoCabecera p WHERE p.pcFecha = :pcFecha")
    , @NamedQuery(name = "PrestamoCabecera.findByPcDescripcion", query = "SELECT p FROM PrestamoCabecera p WHERE p.pcDescripcion = :pcDescripcion")})
public class PrestamoCabecera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "PC_NOMBRE")
    private String pcNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PC_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pcFecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "PC_DESCRIPCION")
    private String pcDescripcion;

    public PrestamoCabecera() {
    }

    public PrestamoCabecera(String pcNombre) {
        this.pcNombre = pcNombre;
    }

    public PrestamoCabecera(String pcNombre, Date pcFecha, String pcDescripcion) {
        this.pcNombre = pcNombre;
        this.pcFecha = pcFecha;
        this.pcDescripcion = pcDescripcion;
    }

    public String getPcNombre() {
        return pcNombre;
    }

    public void setPcNombre(String pcNombre) {
        this.pcNombre = pcNombre;
    }

    public Date getPcFecha() {
        return pcFecha;
    }

    public void setPcFecha(Date pcFecha) {
        this.pcFecha = pcFecha;
    }

    public String getPcDescripcion() {
        return pcDescripcion;
    }

    public void setPcDescripcion(String pcDescripcion) {
        this.pcDescripcion = pcDescripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pcNombre != null ? pcNombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrestamoCabecera)) {
            return false;
        }
        PrestamoCabecera other = (PrestamoCabecera) object;
        if ((this.pcNombre == null && other.pcNombre != null) || (this.pcNombre != null && !this.pcNombre.equals(other.pcNombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkg_persistencia.PrestamoCabecera[ pcNombre=" + pcNombre + " ]";
    }
    
}
