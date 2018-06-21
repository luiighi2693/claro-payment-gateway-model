/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e4gslab.ebill.payment.gateway.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jmercado
 */
@Entity
@Table(name = "AUTHORIZATION_IP_APPLICATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuthorizationIpApplication.findAll", query = "SELECT a FROM AuthorizationIpApplication a"),
    @NamedQuery(name = "AuthorizationIpApplication.findByApplicationId", query = "SELECT a FROM AuthorizationIpApplication a WHERE a.authorizationIpApplicationPK.applicationId = :applicationId"),
    @NamedQuery(name = "AuthorizationIpApplication.findByIpAuthorization", query = "SELECT a FROM AuthorizationIpApplication a WHERE a.authorizationIpApplicationPK.ipAuthorization = :ipAuthorization"),
    @NamedQuery(name = "AuthorizationIpApplication.findByDescription", query = "SELECT a FROM AuthorizationIpApplication a WHERE a.description = :description")})
public class AuthorizationIpApplication implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected AuthorizationIpApplicationPK authorizationIpApplicationPK;
    
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    
    @Size(max = 1)
    @Column(name = "ENABLED")
    private String enabled;
    
    @JoinColumn(name = "APPLICATION_ID", referencedColumnName = "APLICATION_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aplication aplication;

    public AuthorizationIpApplication() {
    }

    public AuthorizationIpApplication(AuthorizationIpApplicationPK authorizationIpApplicationPK) {
        this.authorizationIpApplicationPK = authorizationIpApplicationPK;
    }

    public AuthorizationIpApplication(String applicationId, String ipAuthorization) {
        this.authorizationIpApplicationPK = new AuthorizationIpApplicationPK(applicationId, ipAuthorization);
    }

    public AuthorizationIpApplicationPK getAuthorizationIpApplicationPK() {
        return authorizationIpApplicationPK;
    }

    public void setAuthorizationIpApplicationPK(AuthorizationIpApplicationPK authorizationIpApplicationPK) {
        this.authorizationIpApplicationPK = authorizationIpApplicationPK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Aplication getAplication() {
        return aplication;
    }

    public void setAplication(Aplication aplication) {
        this.aplication = aplication;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (authorizationIpApplicationPK != null ? authorizationIpApplicationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuthorizationIpApplication)) {
            return false;
        }
        AuthorizationIpApplication other = (AuthorizationIpApplication) object;
        if ((this.authorizationIpApplicationPK == null && other.authorizationIpApplicationPK != null) || (this.authorizationIpApplicationPK != null && !this.authorizationIpApplicationPK.equals(other.authorizationIpApplicationPK))) {
            return false;
        }
        return true;
    }

	
	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "AuthorizationIpApplication [authorizationIpApplicationPK="
				+ authorizationIpApplicationPK + ", description=" + description
				+ ", enabled=" + enabled + ", aplication=" + aplication + "]";
	}
    
	
}
