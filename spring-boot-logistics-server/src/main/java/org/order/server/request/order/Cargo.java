package org.order.server.request.order;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by fx on 2019/1/17.
 * 货物信息
 */
@XmlType(name = "Cargo",propOrder = {"name","count","unit","weight","amount","currency"})
@XmlRootElement
public class Cargo {
    @XmlAttribute
    private String name;//名称
    @XmlAttribute
    private int count;//数量
    @XmlAttribute
    private String unit;//货物单位，如：个、台、本，跨境件报关需要填写
    @XmlAttribute
    private double weight;//订单货物单位重量，包含子母件，单位千克，精确到小数点后3位跨境件报关需要填写
    @XmlAttribute
    private double amount;//货物单价，精确到小数点后3位，跨境件报关需要填写
    @XmlAttribute
    private String currency;//货物单价的币别：CNY: 人民币HKD: 港币USD: 美元

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
