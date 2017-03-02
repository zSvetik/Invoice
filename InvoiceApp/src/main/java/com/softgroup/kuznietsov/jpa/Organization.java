package com.softgroup.kuznietsov.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "organization")
public class Organization implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "edrpou")
    private int edrpou;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organization")
    private List<PaymentAccount> paymentAccountList = new ArrayList<>();

    public Organization() {
    }

    public Organization(int edrpou, String description) {
        this.edrpou = edrpou;
        this.description = description;
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
        result = prime * result + edrpou;
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
        Organization other = (Organization) obj;
        if (edrpou != other.edrpou)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Organization [edrpou=" + edrpou + ", description=" + description + "]";
    }

}
