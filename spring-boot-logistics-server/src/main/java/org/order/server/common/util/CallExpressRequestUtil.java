package org.order.server.common.util;

import com.sf.csim.express.service.CallExpressServiceTools;
import org.order.server.common.constant.SfExpressConstant;
import org.springframework.stereotype.Component;

/**
 * Created by fx on 2019/1/16.
 * 请求丰桥接口并返回
 */
@Component
public class CallExpressRequestUtil {



    //请求顺丰服务方法
    public String getOrder(String reqXml) {

        CallExpressServiceTools client = CallExpressServiceTools.getInstance();
        System.out.println("请求报文：" + reqXml);
        String respXml = client.callSfExpressServiceByCSIM(SfExpressConstant.PLACE_ORDER, reqXml, SfExpressConstant.CLIENT_CODE, SfExpressConstant.CHECKWORD);

        if (respXml != null) {
            System.out.println("--------------------------------------");
            System.out.println("返回报文: " + respXml);
            System.out.println("--------------------------------------");
        }
        return respXml;
    }
}
