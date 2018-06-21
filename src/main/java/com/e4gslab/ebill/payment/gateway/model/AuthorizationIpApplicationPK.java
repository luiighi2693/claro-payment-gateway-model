/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e4gslab.ebill.payment.gateway.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jmercado
 */
@Embeddable
public class AuthorizationIpApplicationPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "APPLICATION_ID")
    private String applicationId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "IP_AUTHORIZATION")
    private String ipAuthorization;

    public AuthorizationIpApplicationPK() {
    }

    public AuthorizationIpApplicationPK(String applicationId, String ipAuthorization) {
        this.applicationId = applicationId;
        this.ipAuthorization = ipAuthorization;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getIpAuthorization() {
        return ipAuthorization;
    }

    public void setIpAuthorization(String ipAuthorization) {
        this.ipAuthorization = ipAuthorization;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (applicationId != null ? applicationId.hashCode() : 0);
        hash += (ipAuthorization != null ? ipAuthorization.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuthorizationIpApplicationPK)) {
            return false;
        }
        AuthorizationIpApplicationPK other = (AuthorizationIpApplicationPK) object;
        if ((this.applicationId == null && other.applicationId != null) || (this.applicationId != null && !this.applicationId.equals(other.applicationId))) {
            return false;
        }
        if ((this.ipAuthorization == null && other.ipAuthorization != null) || (this.ipAuthorization != null && !this.ipAuthorization.equals(other.ipAuthorization))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.e4gslab.claro.payments.gateway.entities.AuthorizationIpApplicationPK[ applicationId=" + applicationId + ", ipAuthorization=" + ipAuthorization + " ]";
    }
    
}
