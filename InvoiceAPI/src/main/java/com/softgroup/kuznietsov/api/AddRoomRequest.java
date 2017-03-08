package com.softgroup.kuznietsov.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by User on 08.03.2017.
 */
@XmlRootElement
public class AddRoomRequest {
    @XmlElement(required=true)
    public RoomInfo roomInfo;
}
