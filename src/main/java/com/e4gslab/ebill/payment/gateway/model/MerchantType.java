
package com.e4gslab.ebill.payment.gateway.model;

import java.io.Serializable;
import java.util.Date;

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
 * @author dthompson
 */
@Entity
@Table(name = "MERCHANT_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MerchantType.findAll", query = "SELECT mt FROM MerchantType mt WHERE mt.enabled = 'Y'"),
    @NamedQuery(name = "MerchantType.findByMerchantTypeId", query = "SELECT mt FROM MerchantType mt WHERE mt.merchantTypeId = :merchantTypeId")})
public class MerchantType implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "MERCHANT_TYPE_ID")
    private String merchantTypeId;
    
    @Size(max = 255)
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Size(max=1)
    @Column(name = "ENABLED")
    private String enabled;    
    
    public MerchantType() {
    }

    public MerchantType(String merchantTypeId) {
        this.merchantTypeId = merchantTypeId;
    }

    public String getMerchantTypeId() {
        return merchantTypeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getCreatedDate() {
		return createdDate;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	
    public String getEnabled() {
		return enabled;
	}

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (merchantTypeId != null ? merchantTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MerchantType)) {
            return false;
        }
        MerchantType other = (MerchantType) object;
        if ((this.merchantTypeId == null && other.merchantTypeId != null) || (this.merchantTypeId != null && !this.merchantTypeId.equals(other.merchantTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.e4gslab.claro.payments.gateway.entities.MerchantType[ aplicationId=" + merchantTypeId + " ]";
    }
    
}
