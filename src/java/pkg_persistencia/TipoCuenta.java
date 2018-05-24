/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "TIPO_CUENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCuenta.findAll", query = "SELECT t FROM TipoCuenta t")
    , @NamedQuery(name = "TipoCuenta.findByTpCodigo", query = "SELECT t FROM TipoCuenta t WHERE t.tpCodigo = :tpCodigo")
    , @NamedQuery(name = "TipoCuenta.findByTpNombre", query = "SELECT t FROM TipoCuenta t WHERE t.tpNombre = :tpNombre")})
public class TipoCuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "TP_CODIGO")
    private String tpCodigo;
    @Size(max = 100)
    @Column(name = "TP_NOMBRE")
    private String tpNombre;
    @OneToMany(mappedBy = "tpCodigo")
    private List<Cuenta> cuentaList;

    public TipoCuenta() {
    }

    public TipoCuenta(String tpCodigo) {
        this.tpCodigo = tpCodigo;
    }

    public String getTpCodigo() {
        return tpCodigo;
    }

    public void setTpCodigo(String tpCodigo) {
        this.tpCodigo = tpCodigo;
    }

    public String getTpNombre() {
        return tpNombre;
    }

    public void setTpNombre(String tpNombre) {
        this.tpNombre = tpNombre;
    }

    @XmlTransient
    public List<Cuenta> getCuentaList() {
        return cuentaList;
    }

    public void setCuentaList(List<Cuenta> cuentaList) {
        this.cuentaList = cuentaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tpCodigo != null ? tpCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCuenta)) {
            return false;
        }
        TipoCuenta other = (TipoCuenta) object;
        if ((this.tpCodigo == null && other.tpCodigo != null) || (this.tpCodigo != null && !this.tpCodigo.equals(other.tpCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkg_persistencia.TipoCuenta[ tpCodigo=" + tpCodigo + " ]";
    }
    
}
