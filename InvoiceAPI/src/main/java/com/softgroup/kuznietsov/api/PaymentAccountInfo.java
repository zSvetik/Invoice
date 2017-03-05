package com.softgroup.kuznietsov.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 05.03.2017.
 */
@XmlRootElement
public class PaymentAccountInfo {
    @XmlElement(required = false)
    public Long id;
    @XmlElement(required = true)
    public BankInfo bankInfo;
    @XmlElement(required = true)
    public OrganizationInfo organizationInfo;
    @XmlElement(required = false)
    public List<InvoiceInfo> invoiceInfo = new ArrayList<>();
}
