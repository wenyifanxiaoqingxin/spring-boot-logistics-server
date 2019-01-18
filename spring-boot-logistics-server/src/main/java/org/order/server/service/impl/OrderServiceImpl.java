package org.order.server.service.impl;

import org.order.server.common.constant.ServiceName;
import org.order.server.common.factory.CallExpressRequestFactory;
import org.order.server.request.order.*;
import org.order.server.service.OrderService;
import org.order.server.common.util.CallExpressRequestUtil;
import org.order.server.common.util.XmlBuilder;
import org.order.server.response.CallExpressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fx on 2019/1/16.
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private XmlBuilder xmlBuilder;

    @Autowired
    private CallExpressRequestUtil callExpressRequestUtil;

    @Autowired
    private CallExpressRequestFactory callExpressRequestFactory;

    //下订单接口根据客户需要，可提供以下两个功能：1) 客户系统向顺丰下发订单。2) 为订单分配运单号。
    @Override
    public CallExpressResponse addOrder(Order order) {

        //增值服务
        AddedService addedService =new AddedService();
        addedService.setName("COD");
        addedService.setValue("3000");
        addedService.setValue1("7551234567");
        order.setAddedService(addedService);

        //货物详细信息
        Cargo cargo = new Cargo();
        cargo.setName("手机");
        cargo.setAmount(1);
        cargo.setCurrency("USD");
        cargo.setCount(1);
        order.setCargo(cargo);

        String reqXml = xmlBuilder.convertToXml(callExpressRequestFactory.createRequestBean(order, ServiceName.OrderService));
        String respXml = callExpressRequestUtil.getOrder(reqXml);
        CallExpressResponse callExpressResponse =xmlBuilder.convertToObject(respXml,CallExpressResponse.class);
        return callExpressResponse;
    }

    //因Internet环境下，网络不是绝对可靠，用户系统下订单到顺丰后，不一定可以收到顺丰系统返回的数据，此接口用于在未收到返回数据时，查询下订单（含筛选）接口客户订单当前的处理情况。
    @Override
    public CallExpressResponse queryOrderResult(OrderSearch orderSearch) {
        String reqXml = xmlBuilder.convertToXml(callExpressRequestFactory.createRequestBean(orderSearch,ServiceName.OrderSearchService));
        String respXml = callExpressRequestUtil.getOrder(reqXml);
        CallExpressResponse callExpressResponse =xmlBuilder.convertToObject(respXml,CallExpressResponse.class);
        return callExpressResponse;
    }

    //该接口用于：• 客户在确定将货物交付给顺丰托运后，将运单上的一些重要信息，如快件重量通过此接口发送给顺丰。• 客户在发货前取消订单。
    @Override
    public CallExpressResponse confirmOrder(OrderConfirm orderConfirm) {

        String reqXml = xmlBuilder.convertToXml(callExpressRequestFactory.createRequestBean(orderConfirm,ServiceName.OrderConfirmService));
        String respXml = callExpressRequestUtil.getOrder(reqXml);
        CallExpressResponse callExpressResponse =xmlBuilder.convertToObject(respXml,CallExpressResponse.class);
        return callExpressResponse;
    }
}
