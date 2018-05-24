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
@Table(name = "CUENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c")
    , @NamedQuery(name = "Cuenta.findByCCodigo", query = "SELECT c FROM Cuenta c WHERE c.cCodigo = :cCodigo")
    , @NamedQuery(name = "Cuenta.findByTpCodigo", query = "SELECT c FROM Cuenta c WHERE c.tpCodigo = :tpCodigo")
    , @NamedQuery(name = "Cuenta.findByCNombre", query = "SELECT c FROM Cuenta c WHERE c.cNombre = :cNombre")})
public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "C_CODIGO")
    private String cCodigo;
    @Size(max = 3)
    @Column(name = "TP_CODIGO")
    private String tpCodigo;
    @Size(max = 100)
    @Column(name = "C_NOMBRE")
    private String cNombre;

    public Cuenta() {
    }

    public Cuenta(String cCodigo) {
        this.cCodigo = cCodigo;
    }

    public String getCCodigo() {
        return cCodigo;
    }

    public void setCCodigo(String cCodigo) {
        this.cCodigo = cCodigo;
    }

    public String getTpCodigo() {
        return tpCodigo;
    }

    public void setTpCodigo(String tpCodigo) {
        this.tpCodigo = tpCodigo;
    }

    public String getCNombre() {
        return cNombre;
    }

    public void setCNombre(String cNombre) {
        this.cNombre = cNombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cCodigo != null ? cCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.cCodigo == null && other.cCodigo != null) || (this.cCodigo != null && !this.cCodigo.equals(other.cCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkg_persistencia.Cuenta[ cCodigo=" + cCodigo + " ]";
    }
    
}
