/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_persistencia;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "CABECERA_DETALLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CabeceraDetalle.findAll", query = "SELECT c FROM CabeceraDetalle c")
    , @NamedQuery(name = "CabeceraDetalle.findByCdCodigo", query = "SELECT c FROM CabeceraDetalle c WHERE c.cdCodigo = :cdCodigo")
    , @NamedQuery(name = "CabeceraDetalle.findByCcNumero", query = "SELECT c FROM CabeceraDetalle c WHERE c.ccNumero = :ccNumero")
    , @NamedQuery(name = "CabeceraDetalle.findByCCodigo", query = "SELECT c FROM CabeceraDetalle c WHERE c.cCodigo = :cCodigo")
    , @NamedQuery(name = "CabeceraDetalle.findByCdCantidadDebe", query = "SELECT c FROM CabeceraDetalle c WHERE c.cdCantidadDebe = :cdCantidadDebe")
    , @NamedQuery(name = "CabeceraDetalle.findByCdCantidadHaber", query = "SELECT c FROM CabeceraDetalle c WHERE c.cdCantidadHaber = :cdCantidadHaber")})
public class CabeceraDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "CD_CODIGO")
    private String cdCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "CC_NUMERO")
    private String ccNumero;
    @Size(max = 3)
    @Column(name = "C_CODIGO")
    private String cCodigo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "CD_CANTIDAD_DEBE")
    private BigDecimal cdCantidadDebe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CD_CANTIDAD_HABER")
    private BigDecimal cdCantidadHaber;

    public CabeceraDetalle() {
    }

    public CabeceraDetalle(String cdCodigo) {
        this.cdCodigo = cdCodigo;
    }

    public CabeceraDetalle(String cdCodigo, String ccNumero, BigDecimal cdCantidadDebe, BigDecimal cdCantidadHaber) {
        this.cdCodigo = cdCodigo;
        this.ccNumero = ccNumero;
        this.cdCantidadDebe = cdCantidadDebe;
        this.cdCantidadHaber = cdCantidadHaber;
    }

    public String getCdCodigo() {
        return cdCodigo;
    }

    public void setCdCodigo(String cdCodigo) {
        this.cdCodigo = cdCodigo;
    }

    public String getCcNumero() {
        return ccNumero;
    }

    public void setCcNumero(String ccNumero) {
        this.ccNumero = ccNumero;
    }

    public String getCCodigo() {
        return cCodigo;
    }

    public void setCCodigo(String cCodigo) {
        this.cCodigo = cCodigo;
    }

    public BigDecimal getCdCantidadDebe() {
        return cdCantidadDebe;
    }

    public void setCdCantidadDebe(BigDecimal cdCantidadDebe) {
        this.cdCantidadDebe = cdCantidadDebe;
    }

    public BigDecimal getCdCantidadHaber() {
        return cdCantidadHaber;
    }

    public void setCdCantidadHaber(BigDecimal cdCantidadHaber) {
        this.cdCantidadHaber = cdCantidadHaber;
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
        if (!(object instanceof CabeceraDetalle)) {
            return false;
        }
        CabeceraDetalle other = (CabeceraDetalle) object;
        if ((this.cdCodigo == null && other.cdCodigo != null) || (this.cdCodigo != null && !this.cdCodigo.equals(other.cdCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkg_persistencia.CabeceraDetalle[ cdCodigo=" + cdCodigo + " ]";
    }
    
}
