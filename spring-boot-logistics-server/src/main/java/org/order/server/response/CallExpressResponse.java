package org.order.server.response;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by fx on 2019/1/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Response")
public class CallExpressResponse implements Serializable{

    private static final long serialVersionUID = 1L;
    //响应状态
    @XmlElement(name = "Head")
    private String Head;
    //响应失败原因
    @XmlElement(name = "ERROR")
    private ERROR ERROR;
    //响应结果
    @XmlElement(name = "Body")
    private Body Body;


    @XmlAccessorType(XmlAccessType.NONE)
    public static class ERROR {
        @XmlAttribute(name = "code")
        private String code;
        @XmlValue
        private String text;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    @XmlAccessorType(XmlAccessType.NONE)
    public static class Body {

        @XmlElement(name = "OrderResponse")
        private OrderResponse OrderResponse;//订单查询结果或者下单返回

        @XmlElement(name = "OrderConfirmResponse")
        private OrderConfirmResponse OrderConfirmResponse;//订单确认/取消接口返回

        @XmlElement(name = "RouteResponse")
        private RouteResponse RouteResponse;//路由查询返回

        public CallExpressResponse.OrderResponse getOrderResponse() {
            return OrderResponse;
        }

        public void setOrderResponse(CallExpressResponse.OrderResponse orderResponse) {
            OrderResponse = orderResponse;
        }

        public CallExpressResponse.RouteResponse getRouteResponse() {
            return RouteResponse;
        }

        public void setRouteResponse(CallExpressResponse.RouteResponse routeResponse) {
            RouteResponse = routeResponse;
        }


        public CallExpressResponse.OrderConfirmResponse getOrderConfirmResponse() {
            return OrderConfirmResponse;
        }

        public void setOrderConfirmResponse(CallExpressResponse.OrderConfirmResponse orderConfirmResponse) {
            OrderConfirmResponse = orderConfirmResponse;
        }
    }

    @XmlRootElement(name="OrderResponse")
    @XmlAccessorType(XmlAccessType.NONE)
    public static class OrderResponse {
        //订单号
        @XmlAttribute(name = "orderid")
        private String orderId;
        //运单号
        @XmlAttribute(name = "mailno")
        private String mailNo;
        //原寄地区域代码(可用于顺丰电子运单标签打印)
        @XmlAttribute(name = "origincode")
        private String originCode;
        //目的地区域代码(可用于顺丰电子运单标签打印)
        @XmlAttribute(name = "destcode")
        private String destCode;
        //筛单结果：1：人工确认 2：可收派 3：不可以收派
        @XmlAttribute(name = "filter_result")
        private String filterResult;
        //如果filter_result=3时为必填，不可以收派的原因代码：1：收方超范围2：派方超范围3-：其它原因
        @XmlAttribute(name = "remark")
        private String remark;

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getMailNo() {
            return mailNo;
        }

        public void setMailNo(String mailNo) {
            this.mailNo = mailNo;
        }

        public String getOriginCode() {
            return originCode;
        }

        public void setOriginCode(String originCode) {
            this.originCode = originCode;
        }

        public String getDestCode() {
            return destCode;
        }

        public void setDestCode(String destCode) {
            this.destCode = destCode;
        }

        public String getFilterResult() {
            return filterResult;
        }

        public void setFilterResult(String filterResult) {
            this.filterResult = filterResult;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }

    @XmlRootElement(name="OrderConfirmResponse")
    @XmlAccessorType(XmlAccessType.NONE)
    public static class OrderConfirmResponse {
        //订单id
        @XmlAttribute(name = "orderid")
        private String orderid;
        //顺丰母运单号(如果dealtype=1，必填)
        @XmlAttribute(name = "mailno")
        private String mailno;
        //备注1：客户订单号与顺丰运单不匹配2 ：操作成功
        @XmlAttribute(name="res_status")
        private int res_status;

        public String getOrderid() {
            return orderid;
        }

        public void setOrderid(String orderid) {
            this.orderid = orderid;
        }

        public String getMailno() {
            return mailno;
        }

        public void setMailno(String mailno) {
            this.mailno = mailno;
        }

        public int getRes_status() {
            return res_status;
        }

        public void setRes_status(int res_status) {
            this.res_status = res_status;
        }
    }

    @XmlRootElement(name="RouteResponse")
    @XmlAccessorType(XmlAccessType.NONE)
    public static class RouteResponse {
        //运单号
        @XmlAttribute(name = "mailno")
        private String mailNo;
        //路由
        @XmlElement(name = "Route")
        private List<Route> Route ;

        public String getMailNo() {
            return mailNo;
        }

        public void setMailNo(String mailNo) {
            this.mailNo = mailNo;
        }

        public List<CallExpressResponse.Route> getRoute() {
            return Route;
        }

        public void setRoute(List<CallExpressResponse.Route> route) {
            Route = route;
        }
    }

    @XmlRootElement(name="Route")
    @XmlAccessorType(XmlAccessType.NONE)
    public static class Route {
        //路由节点发生的时间
        @XmlAttribute(name = "accept_time")
        private String acceptTime;

        //路由节点具体描述
        @XmlAttribute(name = "remark")
        private String remark;

        //路由节点操作码
        @XmlAttribute(name = "opcode")
        private String opcode;

        public String getAcceptTime() {
            return acceptTime;
        }

        public void setAcceptTime(String acceptTime) {
            this.acceptTime = acceptTime;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getOpcode() {
            return opcode;
        }

        public void setOpcode(String opcode) {
            this.opcode = opcode;
        }
    }

    public String getHead() {
        return Head;
    }

    public void setHead(String head) {
        Head = head;
    }

    public ERROR getERROR() {
        return ERROR;
    }

    public void setERROR(CallExpressResponse.ERROR ERROR) {
        this.ERROR = ERROR;
    }

    public Body getBody() {
        return Body;
    }

    public void setBody(CallExpressResponse.Body body) {
        Body = body;
    }
}
