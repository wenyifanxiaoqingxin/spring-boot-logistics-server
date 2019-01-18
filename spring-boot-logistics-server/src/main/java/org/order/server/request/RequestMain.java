package org.order.server.request;

import com.sf.csim.express.service.CallExpressServiceTools;
import org.order.server.common.constant.SfExpressConstant;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by fx on 2019/1/16.
 */
public class RequestMain {

    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        String reqXml = "";
        try{
            @SuppressWarnings("resource")
            InputStream is = new FileInputStream("/Users/crionline/Desktop/1.order.txt");//下订单
            //     InputStream is = new FileInputStream("2.order_query.txt");//查订单
            //     InputStream is = new FileInputStream("3.order_confirm.txt");//订单取消
            //     InputStream is = new FileInputStream("4.order_filter.txt");//订单筛选
            //	 InputStream is = new FileInputStream("5.route_queryByMailNo.txt");//路由查询-通过运单号
            //     InputStream is = new FileInputStream("5.route_queryByOrderNo.txt");//路由查询-通过订单号
            //     InputStream is = new FileInputStream("7.orderZD.txt");  //子单号申请
            byte[] bs = new byte[is.available()];
            is.read(bs);
            reqXml = new String(bs);


        }catch(Exception e){

        }
        //丰桥平台公共测试账号
        //SLKJ2019
        //FBIqMkZjzxbsZgo7jTpeq7PD8CVzLT4Q
        String reqURL="https://bsp-oisp.sf-express.com/bsp-oisp/sfexpressService";
        CallExpressServiceTools client=CallExpressServiceTools.getInstance();
        System.out.println("请求报文："+reqXml);
        String respXml= client.callSfExpressServiceByCSIM(reqURL, reqXml, SfExpressConstant.CLIENT_CODE, SfExpressConstant.CHECKWORD);

        if (respXml != null) {
            System.out.println("--------------------------------------");
            System.out.println("返回报文: "+ respXml);
            System.out.println("--------------------------------------");
        }
    }

}
