package org.order.server.request.order;

import javax.xml.bind.annotation.*;

/**
 * Created by fx on 2019/1/17.
 * 因Internet环境下，网络不是绝对可靠，用户系统下订单到顺丰后，不一定可以收到顺丰系统返回的数据，此接口用于在未收到返回数据时，查询下订单（含筛选）接口客户订单当前的处理情况。
 */
@XmlType(name = "OrderSearch")
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public class OrderSearch {

    @XmlAttribute
    private String orderid;//订单id

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getOrderid() {
        return orderid;
    }
}
