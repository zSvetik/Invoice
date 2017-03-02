package com.softgroup.kuznietsov.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by User on 02.03.2017.
 */
@XmlRootElement
public class AddUserRequest {
    @XmlElement(required=true)
    public InvUser user;
}
