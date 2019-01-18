package org.order.server.request;


import org.order.server.request.body.Body;

import javax.xml.bind.annotation.*;

/**
 * Created by fx on 2019/1/16.
 *
 *
 */
@XmlType(name = "request")
@XmlRootElement(name = "Request")
@XmlAccessorType(XmlAccessType.FIELD)
public class CallExpressRequest {

    @XmlAttribute
    private String service;

    @XmlAttribute
    private String lang;

    @XmlElement
    private String Head;

    @XmlElement
    private Body Body;

    public void setService(String service) {
        this.service = service;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public void setHead(String head) {
        Head = head;
    }

    public void setBody(Body body) {
        this.Body = body;
    }

    public String getService() {
        return service;
    }

    public String getLang() {
        return lang;
    }

    public String getHead() {
        return Head;
    }

    public Body getBody() {
        return Body;
    }



}
