package com.softgroup.kuznietsov.jpa;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "bank")
public class Bank implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "mfo")
    private int mfo;

    @Basic(optional = false)
    @NotNull
    @Column(name = "edrpou")
    private int edrpou;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bank")
    private List<PaymentAccount> paymentAccountList = new ArrayList<>();

    public Bank() {
    }

    public Bank(int mfo, int edrpou, String description) {
        this.mfo = mfo;
        this.edrpou = edrpou;
        this.description = description;
    }

    public int getMfo() {
        return mfo;
    }

    public void setMfo(int mfo) {
        this.mfo = mfo;
    }

    public int getEdrpou() {
        return edrpou;
    }

    public void setEdrpou(int edrpou) {
        this.edrpou = edrpou;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PaymentAccount> getPaymentAccountList() {
        return paymentAccountList;
    }

    public void setPaymentAccountList(List<PaymentAccount> paymentAccountList) {
        this.paymentAccountList = paymentAccountList;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + mfo;
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
        Bank other = (Bank) obj;
        if (mfo != other.mfo)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Bank [mfo=" + mfo + ", edrpou=" + edrpou + ", description=" + description + "]";
    }

}
