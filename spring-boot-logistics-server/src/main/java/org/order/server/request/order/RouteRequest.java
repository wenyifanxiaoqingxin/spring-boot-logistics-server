package org.order.server.request.order;

import javax.xml.bind.annotation.*;

/**
 * Created by fx on 2019/1/22.
 */
@XmlType(name = "RouteRequest")
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class RouteRequest {


    /**
     * 默认值1，查询号类别：1：根据顺丰运单号查询，order节点中tracking_number将被当作顺丰运单号处理
     * 2：根据客户订单号查询，order节点中tracking_number将被当作客户订单号处理
     * 3：逆向单，根据客户原始订单号查询，order节点中tracking_number将被当作逆向单原始订单号处理
     */
    @XmlAttribute(name = "tracking_type")
    private int tracking_type;

    /**
     * 查询号：如果tracking_type=1，则此值为顺丰运单号
     * 如果tracking_type=2，则此值为客户订单号
     * 如果tracking_type=3，则此值为逆向单原始订单号
     * 如果有多个单号，以逗号分隔，如"123,124,125"。
     */
    @XmlAttribute(name = "tracking_number")
    private String tracking_number;

    @XmlAttribute(name = "method_type")
    private int method_type;//默认1，路由查询类别：1：标准路由查询2：定制路由查询

    /**
     校验电话号码后四位值；
     按运单号查询路由时，可通过该参数传入用于校验的电话号码后4位（寄方或收方都可以），
     如果涉及多个运单号，对应该值也需按顺序传入多个，并以英文逗号隔开。
     */
    @XmlAttribute(name = "check_phoneNo")
    private String  check_phoneNo; //check_phoneNo

    public int getTracking_type() {
        return tracking_type;
    }

    public void setTracking_type(int tracking_type) {
        this.tracking_type = tracking_type;
    }

    public String getTracking_number() {
        return tracking_number;
    }

    public void setTracking_number(String tracking_number) {
        this.tracking_number = tracking_number;
    }

    public int getMethod_type() {
        return method_type;
    }

    public void setMethod_type(int method_type) {
        this.method_type = method_type;
    }

    public String getCheck_phoneNo() {
        return check_phoneNo;
    }

    public void setCheck_phoneNo(String check_phoneNo) {
        this.check_phoneNo = check_phoneNo;
    }
}
