package org.order.server.request.order;

import javax.xml.bind.annotation.*;

/**
 * Created by fx on 2019/1/18.
 * 该参数用于：
 * • 客户在确定将货物交付给顺丰托运后，将运单上的一些重要信息，如快件重量通过此接口发送给顺丰。
 * • 客户在发货前取消订单。
 * 注意：订单取消之后，订单号也是不能重复利用的。
 */
@XmlType(name = "OrderConfirm")
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class OrderConfirm {

    @XmlAttribute
    private String orderid;//订单号Id

    @XmlAttribute
    private String dealtype;//客户订单操作标识：1：确认2：取消

    @XmlAttribute
    private String mailno;//顺丰母运单号(如果dealtype=1，必填)

    @XmlAttribute(name = "consign_emp_code")
    private String consign_emp_code;//收派员工号

    @XmlAttribute(name = "source_zone_code")
    private String source_zone_code;//原寄地网点代码


    @XmlElement(name = "OrderConfirmOption")
    private OrderConfirmOption OrderConfirmOption;//确定订单可选项


    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getDealtype() {
        return dealtype;
    }

    public void setDealtype(String dealtype) {
        this.dealtype = dealtype;
    }

    public String getMailno() {
        return mailno;
    }

    public void setMailno(String mailno) {
        this.mailno = mailno;
    }

    public String getConsign_emp_code() {
        return consign_emp_code;
    }

    public void setConsign_emp_code(String consign_emp_code) {
        this.consign_emp_code = consign_emp_code;
    }

    public String getSource_zone_code() {
        return source_zone_code;
    }

    public void setSource_zone_code(String source_zone_code) {
        this.source_zone_code = source_zone_code;
    }

    public OrderConfirmOption getOrderConfirmOption() {
        return OrderConfirmOption;
    }

    public void setOrderConfirmOption(OrderConfirmOption orderConfirmOption) {
        OrderConfirmOption = orderConfirmOption;
    }
}
