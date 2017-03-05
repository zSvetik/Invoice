package com.softgroup.kuznietsov.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by User on 05.03.2017.
 */
@XmlRootElement
public class RoleInfo {
    @XmlElement(required = false)
    public Long id;
    @XmlElement(required = true)
    public String role;
}
