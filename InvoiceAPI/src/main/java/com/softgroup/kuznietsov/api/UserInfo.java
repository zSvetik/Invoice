package com.softgroup.kuznietsov.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by User on 02.03.2017.
 */
@XmlRootElement
public class UserInfo {
    @XmlElement(required=false)
    public Long user_id;
    @XmlElement(required=true)
    public String login;
    @XmlElement(required=true)
    public Boolean isAdmin;
}
