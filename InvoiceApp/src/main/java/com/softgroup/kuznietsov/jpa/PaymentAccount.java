package com.softgroup.kuznietsov.jpa;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "payment_account")
public class PaymentAccount implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "payment_account")
    private Long paymentAccount;

    @JoinColumn(name = "mfo_bank", referencedColumnName = "mfo")
    @ManyToOne(optional = false)
    private Bank bank;

    @JoinColumn(name = "edrpou_organization", referencedColumnName = "edrpou")
    @ManyToOne(optional = false)
    private Organization organization;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paymentAccount")
    private List<Invoice> invoiceList = new ArrayList<>();

    public PaymentAccount() {
    }

    public PaymentAccount(Long id, Long paymentAccount, Bank bank, Organization organization) {
        this.id = id;
        this.paymentAccount = paymentAccount;
        this.bank = bank;
        this.organization = organization;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(Long paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
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
        PaymentAccount other = (PaymentAccount) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PaymentAccount [id=" + id + "]";
    }

}
