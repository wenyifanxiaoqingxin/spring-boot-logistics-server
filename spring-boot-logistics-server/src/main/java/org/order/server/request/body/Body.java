package org.order.server.request.body;

import org.order.server.request.order.Order;
import org.order.server.request.order.OrderConfirm;
import org.order.server.request.order.OrderSearch;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by fx on 2019/1/16.
 * 请求体
 */
@XmlType(name = "Body")
@XmlRootElement
public class Body {

    @XmlElement
    private Order Order;//body请求体
    @XmlElement
    private OrderSearch OrderSearch;//body请求体
    @XmlElement
    private OrderConfirm OrderConfirm;//body请求体


    public void setOrder(Order order) {
        this.Order = order;
    }

    public void setOrderSearch(org.order.server.request.order.OrderSearch orderSearch) {
        OrderSearch = orderSearch;
    }

    public org.order.server.request.order.Order getOrder() {
        return Order;
    }

    public org.order.server.request.order.OrderSearch getOrderSearch() {
        return OrderSearch;
    }

    public org.order.server.request.order.OrderConfirm getOrderConfirm() {
        return OrderConfirm;
    }

    public void setOrderConfirm(org.order.server.request.order.OrderConfirm orderConfirm) {
        OrderConfirm = orderConfirm;
    }
}
