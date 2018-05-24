/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_persistencia;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Steven
 */
@Entity
@Table(name = "NOMINA_CABECERA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NominaCabecera.findAll", query = "SELECT n FROM NominaCabecera n")
    , @NamedQuery(name = "NominaCabecera.findByNcNumero", query = "SELECT n FROM NominaCabecera n WHERE n.ncNumero = :ncNumero")
    , @NamedQuery(name = "NominaCabecera.findByNcFecha", query = "SELECT n FROM NominaCabecera n WHERE n.ncFecha = :ncFecha")})
public class NominaCabecera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "NC_NUMERO")
    private String ncNumero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NC_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ncFecha;
    @JoinColumn(name = "EMP_CEDULA", referencedColumnName = "EMP_CEDULA")
    @ManyToOne(optional = false)
    private Empleado empCedula;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ncNumero")
    private List<NominaDetalle> nominaDetalleList;

    public NominaCabecera() {
    }

    public NominaCabecera(String ncNumero) {
        this.ncNumero = ncNumero;
    }

    public NominaCabecera(String ncNumero, Date ncFecha) {
        this.ncNumero = ncNumero;
        this.ncFecha = ncFecha;
    }

    public String getNcNumero() {
        return ncNumero;
    }

    public void setNcNumero(String ncNumero) {
        this.ncNumero = ncNumero;
    }

    public Date getNcFecha() {
        return ncFecha;
    }

    public void setNcFecha(Date ncFecha) {
        this.ncFecha = ncFecha;
    }

    public Empleado getEmpCedula() {
        return empCedula;
    }

    public void setEmpCedula(Empleado empCedula) {
        this.empCedula = empCedula;
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
        hash += (ncNumero != null ? ncNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NominaCabecera)) {
            return false;
        }
        NominaCabecera other = (NominaCabecera) object;
        if ((this.ncNumero == null && other.ncNumero != null) || (this.ncNumero != null && !this.ncNumero.equals(other.ncNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkg_persistencia.NominaCabecera[ ncNumero=" + ncNumero + " ]";
    }
    
}
