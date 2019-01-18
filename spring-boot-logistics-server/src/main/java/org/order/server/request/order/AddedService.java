package org.order.server.request.order;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by fx on 2019/1/17.
 * 增值服务
 * 1:代收货款COD value为货款，以原寄地所在区域币种为准，如中国大陆为人民币，香港为港币，保留3位小数。value1为代收货款卡号
 * 2:保价INSURE value为声明价值以原寄地所在区域币种为准，如中国大陆为人民币，香港为港币，保留3位小数。
 * 3:签收短信通知MSG value为手机号码
 * 4:包装服务PKFEE value为包装费费用，单位与主运费一致
 * 5:特殊保价SINSURE value为服务费，单位与主运费一致
 * 6:特殊配送SDELIVERY value为服务费，单位与主运费一致
 * 7:特殊增值服务 SADDSERVICE value 为服务费，单位与主运费一致
 * 8:定时派送TDELIVERY value为派送日期（格式：YYYYMMDD），value1为派送时间段调整为09:00-12:00、12:01-18:00、18:01-21:00三个选项（分别用快捷键1、2、3代表）Value和value1必填
 * 10:电子签收IN91 Value 为图片类型：1、身份证，2、军官证，3、护照，4、其他 Value1 为照片张数
 * 11:拍照验证Psign Value 为图片类型：1、身份证，2、军官证，3、护照，4、其他 Value1 为照片张数
 * 12:保鲜服务FRESH
 * 13:大闸蟹IN98
 * 14:票据专送 IN99
 * 15:散单代收货款 XCOD value为货款，以原寄地所在区域币种为准，如中国大陆为人民币，香港为港币，保留3位小数。value1为代收货款卡号.value2为散单代收货款服务费
 */
@XmlType(name = "AddedService",propOrder ={"name","value","value1","value2"} )
@XmlRootElement
public class AddedService {
    @XmlAttribute
    private String name;//增值服务名，如COD等 COD:代收货款 MSG:签收短信通知
    @XmlAttribute
    private String value;//增值服务扩展属性
    @XmlAttribute
    private String value1;//增值服务扩展属性1
    @XmlAttribute
    private String value2;//增值服务扩展属性2

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }
}
