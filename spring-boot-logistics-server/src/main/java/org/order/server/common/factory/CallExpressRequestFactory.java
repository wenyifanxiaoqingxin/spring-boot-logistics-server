package org.order.server.common.factory;

import org.order.server.common.constant.ServiceName;
import org.order.server.common.constant.SfExpressConstant;
import org.order.server.request.CallExpressRequest;
import org.order.server.request.body.Body;
import org.order.server.request.order.Order;
import org.order.server.request.order.OrderConfirm;
import org.order.server.request.order.OrderSearch;
import org.order.server.request.order.RouteRequest;
import org.springframework.stereotype.Component;
/**
 * Created by fx on 2019/1/16.
 * 请求丰桥服务xml实体封装
 */
@Component
public class CallExpressRequestFactory {

    //封装实体类方法
    public  CallExpressRequest createRequestBean(Object object, ServiceName serviceName) {
        CallExpressRequest callExpressRequest = new CallExpressRequest();
        callExpressRequest.setLang(SfExpressConstant.LANG_CODE);
        Body body = new Body();
        switch (serviceName){
            case OrderService:
                //下订单
                body.setOrder((Order) object);
                break;
            case OrderSearchService:
                //订单结果查询
                body.setOrderSearch((OrderSearch) object);
                break;
            case OrderConfirmService:
                //订单确认/取消
                body.setOrderConfirm((OrderConfirm) object);
                break;
            case RouteService:
                //订单确认/取消
                body.setRouteRequest((RouteRequest) object);
                break;
            default:
        }
        callExpressRequest.setService(String.valueOf(serviceName));
        callExpressRequest.setBody(body);
        callExpressRequest.setHead(SfExpressConstant.CLIENT_CODE);
        return callExpressRequest;
    }
}
