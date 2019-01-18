package org.order.server.request.order;

import javax.xml.bind.annotation.*;

/**
 * Created by fx on 2019/1/16.
 * 请求订单xml
 * 下订单接口根据客户需要，可提供以下两个功能：
 * 1) 客户系统向顺丰下发订单。
 * 2) 为订单分配运单号。
 */
@XmlType(name = "order")
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Order {

    @XmlAttribute
    private String orderid;//客户订单号

    @XmlAttribute(name = "j_province")
    private String j_province;//寄件方所在省份

    @XmlAttribute(name = "j_city")
    private String j_city;//寄件方所在城市名称 北京市

    @XmlAttribute(name = "j_company")
    private String j_company;//寄件方公司名称

    @XmlAttribute(name = "j_contact")
    private String j_contact;//寄件方联系人

    @XmlAttribute(name = "j_tel")
    private String j_tel;//寄件方电话

    @XmlAttribute(name = "j_mobile")
    private String j_mobile;//寄件方手机

    @XmlAttribute(name = "j_county")
    private String j_county;//寄件方区县

    @XmlAttribute(name ="j_address")
    private String j_address;//寄件方详细地址

    @XmlAttribute(name = "d_province")
    private String d_province;//到件方所在省份 北京市

    @XmlAttribute(name = "d_city")
    private String d_city;//到件方所在城市名称

    @XmlAttribute(name = "d_county")
    private String d_county;//到件方所在县/区 石景山区

    @XmlAttribute(name = "d_company")
    private String d_company;//到件方公司名称

    @XmlAttribute(name="d_contact")
    private String d_contact;//到件方联系人

    @XmlAttribute(name="d_tel")
    private String d_tel;//到件方联系电话

    @XmlAttribute(name="d_mobile")
    private String d_mobile;//到件方联系手机

    @XmlAttribute(name = "d_address")
    private String d_address;//到件方详细地址

    @XmlAttribute(name = "express_type")
    private String express_type;//快件产品编码

    @XmlAttribute(name = "parcel_quantity")
    private String parcel_quantity;//包裹数，一个包裹对应一个运单号，如果是大于1个包裹，则返回则按照子母件的方式返回母运单号和子运单号。

    @XmlAttribute(name = "pay_method")
    private String pay_method;//付款方式：1:寄方付2:收方付3:第三方付

    @XmlAttribute(name = "tax_pay_type")
    private String tax_pay_type;//税金付款方式：1：寄付2：到付

    @XmlAttribute(name = "declared_value_currency")
    private String declared_value_currency;//如果目的地是中国大陆的，则默认为CNY，否则默认为USD  CNY: 人民币HKD: 港币USD: 美元

    @XmlAttribute(name = "custid")
    private String custid;//顺丰月结卡号

    @XmlAttribute(name = "is_docall")
    private String is_docall;//是否要求通过手持终端通知顺丰收派员收件：1：要求其它为不要求

    @XmlAttribute(name = "remark")
    private String remark;//备注

    @XmlElement(name = "Cargo")
    private Cargo Cargo;//货物信息

    @XmlElement(name = "AddedService")
    private AddedService AddedService;//增值服务

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public void setJ_province(String j_province) {
        this.j_province = j_province;
    }

    public void setJ_city(String j_city) {
        this.j_city = j_city;
    }

    public void setJ_company(String j_company) {
        this.j_company = j_company;
    }

    public void setJ_contact(String j_contact) {
        this.j_contact = j_contact;
    }

    public void setJ_mobile(String j_mobile) {
        this.j_mobile = j_mobile;
    }

    public void setJ_address(String j_address) {
        this.j_address = j_address;
    }

    public void setD_province(String d_province) {
        this.d_province = d_province;
    }

    public void setD_city(String d_city) {
        this.d_city = d_city;
    }

    public void setD_county(String d_county) {
        this.d_county = d_county;
    }

    public void setD_company(String d_company) {
        this.d_company = d_company;
    }

    public void setD_contact(String d_contact) {
        this.d_contact = d_contact;
    }

    public void setD_tel(String d_tel) {
        this.d_tel = d_tel;
    }

    public void setD_address(String d_address) {
        this.d_address = d_address;
    }

    public void setParcel_quantity(String parcel_quantity) {
        this.parcel_quantity = parcel_quantity;
    }

    public void setPay_method(String pay_method) {
        this.pay_method = pay_method;
    }

    public void setTax_pay_type(String tax_pay_type) {
        this.tax_pay_type = tax_pay_type;
    }

    public void setDeclared_value_currency(String declared_value_currency) {
        this.declared_value_currency = declared_value_currency;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public void setIs_docall(String is_docall) {
        this.is_docall = is_docall;
    }

    public void setAddedService(org.order.server.request.order.AddedService addedService) {
        AddedService = addedService;
    }

    public void setCargo(org.order.server.request.order.Cargo cargo) {
        Cargo = cargo;
    }

    public String getOrderid() {
        return orderid;
    }

    public String getJ_province() {
        return j_province;
    }

    public String getJ_city() {
        return j_city;
    }

    public String getJ_company() {
        return j_company;
    }

    public String getJ_contact() {
        return j_contact;
    }

    public String getJ_tel() {
        return j_tel;
    }

    public String getJ_mobile() {
        return j_mobile;
    }

    public String getJ_county() {
        return j_county;
    }

    public String getJ_address() {
        return j_address;
    }

    public String getD_province() {
        return d_province;
    }

    public String getD_city() {
        return d_city;
    }

    public String getD_county() {
        return d_county;
    }

    public String getD_company() {
        return d_company;
    }

    public String getD_contact() {
        return d_contact;
    }

    public String getD_tel() {
        return d_tel;
    }

    public String getD_mobile() {
        return d_mobile;
    }

    public String getD_address() {
        return d_address;
    }

    public String getExpress_type() {
        return express_type;
    }

    public String getParcel_quantity() {
        return parcel_quantity;
    }

    public String getPay_method() {
        return pay_method;
    }

    public String getTax_pay_type() {
        return tax_pay_type;
    }

    public String getDeclared_value_currency() {
        return declared_value_currency;
    }

    public String getCustid() {
        return custid;
    }

    public String getIs_docall() {
        return is_docall;
    }

    public String getRemark() {
        return remark;
    }

    public org.order.server.request.order.Cargo getCargo() {
        return Cargo;
    }

    public org.order.server.request.order.AddedService getAddedService() {
        return AddedService;
    }
}
