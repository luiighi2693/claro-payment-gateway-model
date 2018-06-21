/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e4gslab.ebill.payment.gateway.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

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
 * @author jmercado
 */
@Entity
@Table(name = "APLICATION") //PAYMENT_GATEWAY or PAYMENT_GATEWAY_ADMIN
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aplication.findAll", query = "SELECT a FROM Aplication a"),
    @NamedQuery(name = "Aplication.findByAplicationId", query = "SELECT a FROM Aplication a WHERE a.aplicationId = :aplicationId"),
    @NamedQuery(name = "Aplication.findByDescripcion", query = "SELECT a FROM Aplication a WHERE a.descripcion = :descripcion")})
public class Aplication implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "APLICATION_ID")
    private String aplicationId;
    
    @Size(max = 255)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    
    @Size(max=20)
    @Column(name = "KEY_ENCRYPT")
    private String keyEncrypt;
    
    @Column(name = "CREATED_DATE")
    private Date createdDate;    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aplicationId")
    private Set<PaymentTransaction> paymentTransactionSet;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aplication")
    private Set<AuthorizationIpApplication> authorizationIpApplicationSet;

    public Aplication() {
    }

    public Aplication(String aplicationId) {
        this.aplicationId = aplicationId;
    }

    public String getAplicationId() {
        return aplicationId;
    }

    public void setAplicationId(String aplicationId) {
        this.aplicationId = aplicationId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getKeyEncrypt() {
		return keyEncrypt;
	}

	public void setKeyEncrypt(String keyEncrypt) {
		this.keyEncrypt = keyEncrypt;
	}
	
    public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}	

	@XmlTransient
    public Set<PaymentTransaction> getPaymentTransactionSet() {
        return paymentTransactionSet;
    }

    public void setPaymentTransactionSet(Set<PaymentTransaction> paymentTransactionSet) {
        this.paymentTransactionSet = paymentTransactionSet;
    }

    @XmlTransient
    public Set<AuthorizationIpApplication> getAuthorizationIpApplicationSet() {
        return authorizationIpApplicationSet;
    }

    public void setAuthorizationIpApplicationSet(Set<AuthorizationIpApplication> authorizationIpApplicationSet) {
        this.authorizationIpApplicationSet = authorizationIpApplicationSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aplicationId != null ? aplicationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aplication)) {
            return false;
        }
        Aplication other = (Aplication) object;
        if ((this.aplicationId == null && other.aplicationId != null) || (this.aplicationId != null && !this.aplicationId.equals(other.aplicationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.e4gslab.claro.payments.gateway.entities.Aplication[ aplicationId=" + aplicationId + " ]";
    }
    
}
