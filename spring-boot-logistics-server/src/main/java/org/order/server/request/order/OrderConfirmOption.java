package org.order.server.request.order;

import javax.xml.bind.annotation.*;

/**
 * Created by fx on 2019/1/18.
 * //订单确认可选项传递，如订单货物重量、体积
 *
 */
@XmlType(name = "OrderConfirmOption")
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class OrderConfirmOption {

    @XmlAttribute
    private double weight;//订单货物总重量，包含子母件，单位千克，精确到小数点后2位，如果提供此值，必须>0。

    @XmlAttribute
    private String volume;//货物的总体积（值为长，宽，高），包含子母件，以半角逗号分隔，单位厘米，精确到小数点后2位，会用于计抛（是否计抛具体商务沟通中双方约定）。

    @XmlAttribute(name = "return_tracking")
    private String return_tracking;

    @XmlAttribute(name = "express_type")
    private String express_type;//快件产品类别，详见附录《快件产品类别表》，只有在商务上与顺丰约定的类别方可使用。如果此字段为空，则以下单时的为准。

    @XmlAttribute(name = "children_nos")
    private String children_nos;//子单号（以半角逗号分隔）如果此字段为空，则以下订单时为准。

    @XmlAttribute(name = "waybill_size")
    private int waybill_size;//电子运单图片规格 1:A4 2:A5

    @XmlAttribute(name ="is_gen_eletric_pic" )
    private int is_gen_eletric_pic;//是否生成电子运单图片

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getReturn_tracking() {
        return return_tracking;
    }

    public void setReturn_tracking(String return_tracking) {
        this.return_tracking = return_tracking;
    }

    public String getExpress_type() {
        return express_type;
    }

    public void setExpress_type(String express_type) {
        this.express_type = express_type;
    }

    public String getChildren_nos() {
        return children_nos;
    }

    public void setChildren_nos(String children_nos) {
        this.children_nos = children_nos;
    }

    public int getWaybill_size() {
        return waybill_size;
    }

    public void setWaybill_size(int waybill_size) {
        this.waybill_size = waybill_size;
    }

    public int getIs_gen_eletric_pic() {
        return is_gen_eletric_pic;
    }

    public void setIs_gen_eletric_pic(int is_gen_eletric_pic) {
        this.is_gen_eletric_pic = is_gen_eletric_pic;
    }
}
