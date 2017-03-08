package com.softgroup.kuznietsov.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 05.03.2017.
 */
@XmlRootElement
public class OrganizationInfo {
    @XmlElement(required = true)
    public Integer edrpou;
    @XmlElement(required = true)
    public String description;
    @XmlElement(required = true)
    public List<PaymentAccountInfo> paymentAccountInfoList = new ArrayList<>();
}