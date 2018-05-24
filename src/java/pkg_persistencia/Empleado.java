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
@Table(name = "EMPLEADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
    , @NamedQuery(name = "Empleado.findByEmpCedula", query = "SELECT e FROM Empleado e WHERE e.empCedula = :empCedula")
    , @NamedQuery(name = "Empleado.findByEmpNombre", query = "SELECT e FROM Empleado e WHERE e.empNombre = :empNombre")
    , @NamedQuery(name = "Empleado.findByEmpFechaIngreso", query = "SELECT e FROM Empleado e WHERE e.empFechaIngreso = :empFechaIngreso")
    , @NamedQuery(name = "Empleado.findByEmpEmpSueldo", query = "SELECT e FROM Empleado e WHERE e.empEmpSueldo = :empEmpSueldo")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "EMP_CEDULA")
    private String empCedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "EMP_NOMBRE")
    private String empNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMP_FECHA_INGRESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date empFechaIngreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMP_EMP_SUELDO")
    private double empEmpSueldo;

    public Empleado() {
    }

    public Empleado(String empCedula) {
        this.empCedula = empCedula;
    }

    public Empleado(String empCedula, String empNombre, Date empFechaIngreso, double empEmpSueldo) {
        this.empCedula = empCedula;
        this.empNombre = empNombre;
        this.empFechaIngreso = empFechaIngreso;
        this.empEmpSueldo = empEmpSueldo;
    }

    public String getEmpCedula() {
        return empCedula;
    }

    public void setEmpCedula(String empCedula) {
        this.empCedula = empCedula;
    }

    public String getEmpNombre() {
        return empNombre;
    }

    public void setEmpNombre(String empNombre) {
        this.empNombre = empNombre;
    }

    public Date getEmpFechaIngreso() {
        return empFechaIngreso;
    }

    public void setEmpFechaIngreso(Date empFechaIngreso) {
        this.empFechaIngreso = empFechaIngreso;
    }

    public double getEmpEmpSueldo() {
        return empEmpSueldo;
    }

    public void setEmpEmpSueldo(double empEmpSueldo) {
        this.empEmpSueldo = empEmpSueldo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empCedula != null ? empCedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.empCedula == null && other.empCedula != null) || (this.empCedula != null && !this.empCedula.equals(other.empCedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkg_persistencia.Empleado[ empCedula=" + empCedula + " ]";
    }
    
}
