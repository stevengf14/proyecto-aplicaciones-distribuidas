/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Steven
 */
@Entity
@Table(name = "MOTIVO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Motivo.findAll", query = "SELECT m FROM Motivo m")
    , @NamedQuery(name = "Motivo.findByMCodigo", query = "SELECT m FROM Motivo m WHERE m.mCodigo = :mCodigo")
    , @NamedQuery(name = "Motivo.findByMNombre", query = "SELECT m FROM Motivo m WHERE m.mNombre = :mNombre")})
public class Motivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "M_CODIGO")
    private String mCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "M_NOMBRE")
    private String mNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mCodigo")
    private List<NominaDetalle> nominaDetalleList;

    public Motivo() {
    }

    public Motivo(String mCodigo) {
        this.mCodigo = mCodigo;
    }

    public Motivo(String mCodigo, String mNombre) {
        this.mCodigo = mCodigo;
        this.mNombre = mNombre;
    }

    public String getMCodigo() {
        return mCodigo;
    }

    public void setMCodigo(String mCodigo) {
        this.mCodigo = mCodigo;
    }

    public String getMNombre() {
        return mNombre;
    }

    public void setMNombre(String mNombre) {
        this.mNombre = mNombre;
    }

    @XmlTransient
    public List<NominaDetalle> getNominaDetalleList() {
        return nominaDetalleList;
    }

    public void setNominaDetalleList(List<NominaDetalle> nominaDetalleList) {
        this.nominaDetalleList = nominaDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mCodigo != null ? mCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Motivo)) {
            return false;
        }
        Motivo other = (Motivo) object;
        if ((this.mCodigo == null && other.mCodigo != null) || (this.mCodigo != null && !this.mCodigo.equals(other.mCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkg_persistencia.Motivo[ mCodigo=" + mCodigo + " ]";
    }
    
}
