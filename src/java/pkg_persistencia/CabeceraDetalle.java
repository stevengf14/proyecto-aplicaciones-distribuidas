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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "CD_CANTIDAD_DEBE")
    private BigDecimal cdCantidadDebe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CD_CANTIDAD_HABER")
    private BigDecimal cdCantidadHaber;
    @JoinColumn(name = "CC_NUMERO", referencedColumnName = "CC_NUMERO")
    @ManyToOne(optional = false)
    private ComprobanteCabecera ccNumero;
    @JoinColumn(name = "C_CODIGO", referencedColumnName = "C_CODIGO")
    @ManyToOne
    private Cuenta cCodigo;

    public CabeceraDetalle() {
    }

    public CabeceraDetalle(String cdCodigo) {
        this.cdCodigo = cdCodigo;
    }

    public CabeceraDetalle(String cdCodigo, BigDecimal cdCantidadDebe, BigDecimal cdCantidadHaber) {
        this.cdCodigo = cdCodigo;
        this.cdCantidadDebe = cdCantidadDebe;
        this.cdCantidadHaber = cdCantidadHaber;
    }

    public String getCdCodigo() {
        return cdCodigo;
    }

    public void setCdCodigo(String cdCodigo) {
        this.cdCodigo = cdCodigo;
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

    public ComprobanteCabecera getCcNumero() {
        return ccNumero;
    }

    public void setCcNumero(ComprobanteCabecera ccNumero) {
        this.ccNumero = ccNumero;
    }

    public Cuenta getCCodigo() {
        return cCodigo;
    }

    public void setCCodigo(Cuenta cCodigo) {
        this.cCodigo = cCodigo;
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
