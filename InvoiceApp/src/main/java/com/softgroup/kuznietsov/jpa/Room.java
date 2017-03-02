package com.softgroup.kuznietsov.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "room")
public class Room implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "owner")
    private String owner;

    @Basic(optional = false)
    @NotNull
    @Column(name = "guests")
    private int guests;

    @Basic(optional = false)
    @NotNull
    @Column(name = "area")
    private float area;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "room")
    private List<Invoice> invoiceList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "room")
    private List<Users> usersList = new ArrayList<>();

    public Room() {
    }

    public Room(Long id, String owner, int guests, float area) {
        this.id = id;
        this.owner = owner;
        this.guests = guests;
        this.area = area;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
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
        Room other = (Room) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Room [id=" + id + ", owner=" + owner + ", guests=" + guests + ", area=" + area + "]";
    }
}
