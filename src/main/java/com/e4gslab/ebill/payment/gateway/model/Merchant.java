
package com.e4gslab.ebill.payment.gateway.model;

import java.io.Serializable;
import java.util.Date;

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
 * @author dthompson
 */
@Entity
@Table(name = "MERCHANT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Merchant.findAll", query = "SELECT m FROM Merchant m WHERE m.enabled = 'Y'"),
    @NamedQuery(name = "Merchant.findByMerchantTypeId", query = "SELECT m FROM Merchant m WHERE m.merchantId = :merchantId")})
public class Merchant implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "MERCHANT_ID")
    private String merchantId;
    
    @Size(max = 250)
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "UPDATED_DATE")
    private Date updatedDate;
    
    @Size(max = 250)
    @Column(name = "USERNAME")
    private String userName;  
    
    @Size(max = 250)
    @Column(name = "PASSWORD")
    private String password;  
    
    @Size(max = 20)
    @Column(name = "MERCHANT_TYPE_ID")
    private String merchantTypeId;       
    
    @Size(max=1)
    @Column(name = "ENABLED")
    private String enabled;    
    
    @Size(max=250)
    @Column(name = "URL")
    private String url;  
    
    @JoinColumn(name = "MERCHANT_TYPE_ID", referencedColumnName = "MERCHANT_TYPE_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private MerchantType merchantType;    
    
    public Merchant() {
    }

    public Merchant(String merchanteId) {
        this.merchantTypeId = merchanteId;
    }

    public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMerchantTypeId() {
		return merchantTypeId;
	}

	public void setMerchantTypeId(String merchantTypeId) {
		this.merchantTypeId = merchantTypeId;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public MerchantType getMerchantType() {
		return merchantType;
	}

	public void setMerchantType(MerchantType merchantType) {
		this.merchantType = merchantType;
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
        Merchant other = (Merchant) object;
        if ((this.merchantId == null && other.merchantId != null) || (this.merchantId != null && !this.merchantId.equals(other.merchantId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.e4gslab.claro.payments.gateway.entities.Merchant[ merchantId=" + merchantId + " ]";
    }
    
}
