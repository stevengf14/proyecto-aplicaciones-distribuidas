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
@Table(name = "COMPROBANTE_CABECERA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComprobanteCabecera.findAll", query = "SELECT c FROM ComprobanteCabecera c")
    , @NamedQuery(name = "ComprobanteCabecera.findByCcNumero", query = "SELECT c FROM ComprobanteCabecera c WHERE c.ccNumero = :ccNumero")
    , @NamedQuery(name = "ComprobanteCabecera.findByCcFecha", query = "SELECT c FROM ComprobanteCabecera c WHERE c.ccFecha = :ccFecha")
    , @NamedQuery(name = "ComprobanteCabecera.findByCcObservacion", query = "SELECT c FROM ComprobanteCabecera c WHERE c.ccObservacion = :ccObservacion")})
public class ComprobanteCabecera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "CC_NUMERO")
    private String ccNumero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CC_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ccFecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "CC_OBSERVACION")
    private String ccObservacion;

    public ComprobanteCabecera() {
    }

    public ComprobanteCabecera(String ccNumero) {
        this.ccNumero = ccNumero;
    }

    public ComprobanteCabecera(String ccNumero, Date ccFecha, String ccObservacion) {
        this.ccNumero = ccNumero;
        this.ccFecha = ccFecha;
        this.ccObservacion = ccObservacion;
    }

    public String getCcNumero() {
        return ccNumero;
    }

    public void setCcNumero(String ccNumero) {
        this.ccNumero = ccNumero;
    }

    public Date getCcFecha() {
        return ccFecha;
    }

    public void setCcFecha(Date ccFecha) {
        this.ccFecha = ccFecha;
    }

    public String getCcObservacion() {
        return ccObservacion;
    }

    public void setCcObservacion(String ccObservacion) {
        this.ccObservacion = ccObservacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ccNumero != null ? ccNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComprobanteCabecera)) {
            return false;
        }
        ComprobanteCabecera other = (ComprobanteCabecera) object;
        if ((this.ccNumero == null && other.ccNumero != null) || (this.ccNumero != null && !this.ccNumero.equals(other.ccNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkg_persistencia.ComprobanteCabecera[ ccNumero=" + ccNumero + " ]";
    }
    
}
