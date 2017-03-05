package com.softgroup.kuznietsov.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 05.03.2017.
 */
@XmlRootElement
public class BankListReply extends GenericReply {
    @XmlElement(required=true)
    public List<BankInfo> bankList = new ArrayList<>();
}
