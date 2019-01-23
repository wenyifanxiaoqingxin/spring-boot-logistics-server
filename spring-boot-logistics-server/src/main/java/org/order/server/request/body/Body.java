package org.order.server.request.body;

import org.order.server.request.order.Order;
import org.order.server.request.order.OrderConfirm;
import org.order.server.request.order.OrderSearch;
import org.order.server.request.order.RouteRequest;

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
    private Order Order;//body下单请求体
    @XmlElement
    private OrderSearch OrderSearch;//body订单查询请求体
    @XmlElement
    private OrderConfirm OrderConfirm;//body订单确认请求体
    @XmlElement
    private RouteRequest RouteRequest;//body路由信息请求体

    public org.order.server.request.order.Order getOrder() {
        return Order;
    }

    public void setOrder(org.order.server.request.order.Order order) {
        Order = order;
    }

    public org.order.server.request.order.OrderSearch getOrderSearch() {
        return OrderSearch;
    }

    public void setOrderSearch(org.order.server.request.order.OrderSearch orderSearch) {
        OrderSearch = orderSearch;
    }

    public org.order.server.request.order.OrderConfirm getOrderConfirm() {
        return OrderConfirm;
    }

    public void setOrderConfirm(org.order.server.request.order.OrderConfirm orderConfirm) {
        OrderConfirm = orderConfirm;
    }

    public org.order.server.request.order.RouteRequest getRouteRequest() {
        return RouteRequest;
    }

    public void setRouteRequest(org.order.server.request.order.RouteRequest routeRequest) {
        RouteRequest = routeRequest;
    }
}
