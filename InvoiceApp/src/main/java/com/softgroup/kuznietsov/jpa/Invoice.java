package com.softgroup.kuznietsov.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "invoice")
public class Invoice implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "id_payment_account", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PaymentAccount paymentAccount;

    @JoinColumn(name = "id_room", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Room room;

    @Basic(optional = false)
    @NotNull
    @Column(name = "personal_account")
    private Long personalAccount;

    @Basic(optional = false)
    @NotNull
    @Column(name = "credited_with")
    private Long creditedWith;

    @Basic(optional = false)
    @NotNull
    @Column(name = "rate")
    private Long rate;

    @Basic(optional = false)
    @NotNull
    @Column(name = "discount")
    private Long discount = new Long(0);

    @Basic(optional = false)
    @NotNull
    @Column(name = "subvention")
    private Long subvention = new Long(0);

    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private Long total;

    @Basic(optional = false)
    @NotNull
    @Column(name = "paid")
    private Long paid = new Long(0);

    @Column(name = "d_open")
    @Temporal(TemporalType.DATE)
    private Date dateOpen;

    @Column(name = "d_close")
    @Temporal(TemporalType.DATE)
    private Date dateClose;

    public Invoice() {
    }

    public Invoice(Long id, Long personalAccount, Long creditedWith, Long rate, Long total, Date dateOpen) {
        this.id = id;
        this.personalAccount = personalAccount;
        this.creditedWith = creditedWith;
        this.rate = rate;
        this.total = total;
        this.dateOpen = dateOpen;
    }

    public Invoice(Long id, Long personalAccount, Long creditedWith, Long rate, Long discount, Long subvention, Long total, Long paid,
            Date dateOpen) {
        this.id = id;
        this.personalAccount = personalAccount;
        this.creditedWith = creditedWith;
        this.rate = rate;
        this.discount = discount;
        this.subvention = subvention;
        this.total = total;
        this.paid = paid;
        this.dateOpen = dateOpen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PaymentAccount getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(PaymentAccount paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Long getPersonalAccount() {
        return personalAccount;
    }

    public void setPersonalAccount(Long personalAccount) {
        this.personalAccount = personalAccount;
    }

    public Long getCreditedWith() {
        return creditedWith;
    }

    public void setCreditedWith(Long creditedWith) {
        this.creditedWith = creditedWith;
    }

    public Long getRate() {
        return rate;
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public Long getSubvention() {
        return subvention;
    }

    public void setSubvention(Long subvention) {
        this.subvention = subvention;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getPaid() {
        return paid;
    }

    public void setPaid(Long paid) {
        this.paid = paid;
    }

    public Date getDateOpen() {
        return dateOpen;
    }

    public void setDateOpen(Date dateOpen) {
        this.dateOpen = dateOpen;
    }

    public Date getDateClose() {
        return dateClose;
    }

    public void setDateClose(Date dateClose) {
        this.dateClose = dateClose;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Invoice other = (Invoice) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Invoice [id=" + id + "]";
    }
}
