/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_persistencia;

import Biblioteca.Libro;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PRESTAMO_DETALLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrestamoDetalle.findAll", query = "SELECT p FROM PrestamoDetalle p")
    , @NamedQuery(name = "PrestamoDetalle.findByCdCodigo", query = "SELECT p FROM PrestamoDetalle p WHERE p.cdCodigo = :cdCodigo")
    , @NamedQuery(name = "PrestamoDetalle.findByCdCantidad", query = "SELECT p FROM PrestamoDetalle p WHERE p.cdCantidad = :cdCantidad")
    , @NamedQuery(name = "PrestamoDetalle.findByCdFechaEntrega", query = "SELECT p FROM PrestamoDetalle p WHERE p.cdFechaEntrega = :cdFechaEntrega")})
public class PrestamoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "CD_CODIGO")
    private String cdCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CD_CANTIDAD")
    private BigInteger cdCantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CD_FECHA_ENTREGA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cdFechaEntrega;
    @JoinColumn(name = "LIB_ISBN", referencedColumnName = "LIB_ISBN")
    @ManyToOne(optional = false)
    private Libro libIsbn;
    @JoinColumn(name = "PC_NOMBRE", referencedColumnName = "PC_NOMBRE")
    @ManyToOne(optional = false)
    private PrestamoCabecera pcNombre;

    public PrestamoDetalle() {
    }

    public PrestamoDetalle(String cdCodigo) {
        this.cdCodigo = cdCodigo;
    }

    public PrestamoDetalle(String cdCodigo, BigInteger cdCantidad, Date cdFechaEntrega) {
        this.cdCodigo = cdCodigo;
        this.cdCantidad = cdCantidad;
        this.cdFechaEntrega = cdFechaEntrega;
    }

    public String getCdCodigo() {
        return cdCodigo;
    }

    public void setCdCodigo(String cdCodigo) {
        this.cdCodigo = cdCodigo;
    }

    public BigInteger getCdCantidad() {
        return cdCantidad;
    }

    public void setCdCantidad(BigInteger cdCantidad) {
        this.cdCantidad = cdCantidad;
    }

    public Date getCdFechaEntrega() {
        return cdFechaEntrega;
    }

    public void setCdFechaEntrega(Date cdFechaEntrega) {
        this.cdFechaEntrega = cdFechaEntrega;
    }

    public Libro getLibIsbn() {
        return libIsbn;
    }

    public void setLibIsbn(Libro libIsbn) {
        this.libIsbn = libIsbn;
    }

    public PrestamoCabecera getPcNombre() {
        return pcNombre;
    }

    public void setPcNombre(PrestamoCabecera pcNombre) {
        this.pcNombre = pcNombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdCodigo != null ? cdCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrestamoDetalle)) {
            return false;
        }
        PrestamoDetalle other = (PrestamoDetalle) object;
        if ((this.cdCodigo == null && other.cdCodigo != null) || (this.cdCodigo != null && !this.cdCodigo.equals(other.cdCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkg_persistencia.PrestamoDetalle[ cdCodigo=" + cdCodigo + " ]";
    }
    
}
