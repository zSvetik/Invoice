package com.softgroup.kuznietsov.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by User on 05.03.2017.
 */
@XmlRootElement
public class InvoiceInfo {
    @XmlElement(required = false)
    public Long id;
    @XmlElement(required = true)
    public PaymentAccountInfo paymentAccountInfo;
    @XmlElement(required = true)
    public RoomInfo roomInfo;
    @XmlElement(required = true)
    public Long personalAccount;
    @XmlElement(required = true)
    public Long creditedWith;
    @XmlElement(required = true)
    public Long rate;
    @XmlElement(required = false)
    public Long discount;
    @XmlElement(required = false)
    public Long subvention;
    @XmlElement(required = true)
    public Long total;
    @XmlElement(required = false)
    public Long paid;
    @XmlElement(required = true)
    public Date dateOpen;
    @XmlElement(required = false)
    public Date dateClose;
}
