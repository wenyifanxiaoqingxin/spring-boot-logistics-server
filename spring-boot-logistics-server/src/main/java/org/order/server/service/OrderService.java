package org.order.server.service;

import org.order.server.request.order.Order;
import org.order.server.request.order.OrderConfirm;
import org.order.server.request.order.OrderSearch;
import org.order.server.request.order.RouteRequest;
import org.order.server.response.CallExpressResponse;

/**
 * Created by fx on 2019/1/16.
 */
public interface OrderService {

    CallExpressResponse addOrder(Order order);

    CallExpressResponse queryOrderResult(OrderSearch orderSearch);

    CallExpressResponse confirmOrder(OrderConfirm orderConfirm);

    CallExpressResponse queryRouteInfo(RouteRequest routeRequest);
}
