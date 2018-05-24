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
@Table(name = "NOMINA_DETALLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NominaDetalle.findAll", query = "SELECT n FROM NominaDetalle n")
    , @NamedQuery(name = "NominaDetalle.findByNdCodigo", query = "SELECT n FROM NominaDetalle n WHERE n.ndCodigo = :ndCodigo")
    , @NamedQuery(name = "NominaDetalle.findByNdValor", query = "SELECT n FROM NominaDetalle n WHERE n.ndValor = :ndValor")})
public class NominaDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "ND_CODIGO")
    private String ndCodigo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "ND_VALOR")
    private BigDecimal ndValor;
    @JoinColumn(name = "M_CODIGO", referencedColumnName = "M_CODIGO")
    @ManyToOne(optional = false)
    private Motivo mCodigo;
    @JoinColumn(name = "NC_NUMERO", referencedColumnName = "NC_NUMERO")
    @ManyToOne(optional = false)
    private NominaCabecera ncNumero;

    public NominaDetalle() {
    }

    public NominaDetalle(String ndCodigo) {
        this.ndCodigo = ndCodigo;
    }

    public NominaDetalle(String ndCodigo, BigDecimal ndValor) {
        this.ndCodigo = ndCodigo;
        this.ndValor = ndValor;
    }

    public String getNdCodigo() {
        return ndCodigo;
    }

    public void setNdCodigo(String ndCodigo) {
        this.ndCodigo = ndCodigo;
    }

    public BigDecimal getNdValor() {
        return ndValor;
    }

    public void setNdValor(BigDecimal ndValor) {
        this.ndValor = ndValor;
    }

    public Motivo getMCodigo() {
        return mCodigo;
    }

    public void setMCodigo(Motivo mCodigo) {
        this.mCodigo = mCodigo;
    }

    public NominaCabecera getNcNumero() {
        return ncNumero;
    }

    public void setNcNumero(NominaCabecera ncNumero) {
        this.ncNumero = ncNumero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ndCodigo != null ? ndCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NominaDetalle)) {
            return false;
        }
        NominaDetalle other = (NominaDetalle) object;
        if ((this.ndCodigo == null && other.ndCodigo != null) || (this.ndCodigo != null && !this.ndCodigo.equals(other.ndCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkg_persistencia.NominaDetalle[ ndCodigo=" + ndCodigo + " ]";
    }
    
}
