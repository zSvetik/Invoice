package com.softgroup.kuznietsov.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 05.03.2017.
 */
@XmlRootElement
public class RoomInfo {
    @XmlElement(required = false)
    public Long id;
    @XmlElement(required = true)
    public String owner;
    @XmlElement(required = true)
    public Integer guests;
    @XmlElement(required = true)
    public Float area;
    @XmlElement(required = false)
    public List<InvoiceInfo> invoiceInfoList = new ArrayList<>();
    @XmlElement(required = false)
    public List<UserInfo> userInfoList = new ArrayList<>();
}
