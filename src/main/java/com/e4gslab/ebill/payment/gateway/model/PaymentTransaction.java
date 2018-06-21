/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e4gslab.ebill.payment.gateway.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jmercado
 */
@Entity
@Table(name = "PAYMENT_TRANSACTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaymentTransaction.findAll", query = "SELECT p FROM PaymentTransaction p"),
    @NamedQuery(name = "PaymentTransaction.findByIdPaymentTransaction", query = "SELECT p FROM PaymentTransaction p WHERE p.idPaymentTransaction = :idPaymentTransaction"),
    @NamedQuery(name = "PaymentTransaction.findByIp", query = "SELECT p FROM PaymentTransaction p WHERE p.ip = :ip"),
    @NamedQuery(name = "PaymentTransaction.findByResponseCode", query = "SELECT p FROM PaymentTransaction p WHERE p.responseCode = :responseCode"),
    @NamedQuery(name = "PaymentTransaction.findByMessage", query = "SELECT p FROM PaymentTransaction p WHERE p.message = :message"),
    @NamedQuery(name = "PaymentTransaction.findByAuthCode", query = "SELECT p FROM PaymentTransaction p WHERE p.authCode = :authCode"),
    @NamedQuery(name = "PaymentTransaction.findByCardNum", query = "SELECT p FROM PaymentTransaction p WHERE p.cardNum = :cardNum"),
    @NamedQuery(name = "PaymentTransaction.findByNameOnCard", query = "SELECT p FROM PaymentTransaction p WHERE p.nameOnCard = :nameOnCard"),
    @NamedQuery(name = "PaymentTransaction.findByAmount", query = "SELECT p FROM PaymentTransaction p WHERE p.amount = :amount"),
    @NamedQuery(name = "PaymentTransaction.findByZip", query = "SELECT p FROM PaymentTransaction p WHERE p.zip = :zip"),
    @NamedQuery(name = "PaymentTransaction.findByStreet", query = "SELECT p FROM PaymentTransaction p WHERE p.street = :street"),
    @NamedQuery(name = "PaymentTransaction.findByCreateDate", query = "SELECT p FROM PaymentTransaction p WHERE p.createDate = :createDate")})
public class PaymentTransaction implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "ID_PAYMENT_TRANSACTION")
    private String idPaymentTransaction;
    @Size(max = 20)
    @Column(name = "IP")
    private String ip;
    @Column(name = "REQUEST_PORT")
    private BigInteger puerto;
    @Size(max = 20)
    @Column(name = "RESPONSE_CODE")
    private String responseCode;
    @Size(max = 255)
    @Column(name = "MESSAGE")
    private String message;
    @Size(max = 20)
    @Column(name = "AUTH_CODE")
    private String authCode;
    @Size(max = 20)
    @Column(name = "CARD_NUM")
    private String cardNum;
    @Size(max = 100)
    @Column(name = "NAME_ON_CARD")
    private String nameOnCard;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AMOUNT")
    private BigDecimal amount;
    @Size(max = 20)
    @Column(name = "ZIP")
    private String zip;
    @Size(max = 255)
    @Column(name = "STREET")
    private String street;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Size(max = 20)
    @Column(name = "PCRF_TRANSA_ID")
    private String PCRFTransaID;
    @Size(max = 10)
    @Column(name = "BAN")
    private String ban;
    @Size(max=1)
    @Column(name = "STATUS")
    private String status;
    @JoinColumn(name = "APLICATION_ID", referencedColumnName = "APLICATION_ID")
    @ManyToOne(optional = false)
    private Aplication aplicationId;

    public PaymentTransaction() {
    }

    public PaymentTransaction(String idPaymentTransaction) {
        this.idPaymentTransaction = idPaymentTransaction;
    }

    public String getIdPaymentTransaction() {
        return idPaymentTransaction;
    }

    public void setIdPaymentTransaction(String idPaymentTransaction) {
        this.idPaymentTransaction = idPaymentTransaction;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getPCRFTransaID() {
		return PCRFTransaID;
	}

	public void setPCRFTransaID(String pCRFTransaID) {
		PCRFTransaID = pCRFTransaID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Aplication getAplicationId() {
        return aplicationId;
    }

    public void setAplicationId(Aplication aplicationId) {
        this.aplicationId = aplicationId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaymentTransaction != null ? idPaymentTransaction.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentTransaction)) {
            return false;
        }
        PaymentTransaction other = (PaymentTransaction) object;
        if ((this.idPaymentTransaction == null && other.idPaymentTransaction != null) || (this.idPaymentTransaction != null && !this.idPaymentTransaction.equals(other.idPaymentTransaction))) {
            return false;
        }
        return true;
    }

	

	public BigInteger getPuerto() {
		return puerto;
	}

	public void setPuerto(BigInteger puerto) {
		this.puerto = puerto;
	}


	public String getBan() {
		return ban;
	}

	public void setBan(String ban) {
		this.ban = ban;
	}

	@Override
	public String toString() {
		return "PaymentTransaction [idPaymentTransaction="
				+ idPaymentTransaction + ", ip=" + ip + ", puerto=" + puerto
				+ ", responseCode=" + responseCode + ", message=" + message
				+ ", authCode=" + authCode + ", cardNum=" + cardNum
				+ ", nameOnCard=" + nameOnCard + ", amount=" + amount
				+ ", zip=" + zip + ", street=" + street + ", createDate="
				+ createDate + ", PCRFTransaID=" + PCRFTransaID + ", ban="
				+ ban + ", status=" + status + ", aplicationId=" + aplicationId
				+ "]";
	}

    
    
}
