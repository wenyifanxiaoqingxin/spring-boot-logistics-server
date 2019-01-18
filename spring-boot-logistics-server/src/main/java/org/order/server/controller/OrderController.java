package org.order.server.controller;

import org.order.server.common.ajax.AjaxResult;
import org.order.server.common.constant.SfExpressConstant;
import org.order.server.request.order.OrderConfirm;
import org.order.server.request.order.OrderSearch;
import org.order.server.response.CallExpressResponse;
import org.order.server.service.OrderService;
import org.order.server.common.util.UUIDUtils;
import org.order.server.request.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by fx on 2019/1/16.
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/add")
    @ResponseBody
    public AjaxResult addOrder(@RequestBody  Order order){
        AjaxResult ajaxResult = new AjaxResult();
        try{
            order.setOrderid(UUIDUtils.generateUUID());
            CallExpressResponse callExpressResponse = orderService.addOrder(order);
            if(SfExpressConstant.SfEXPRESS_ERR.equals(callExpressResponse.getHead())){
                ajaxResult.setCode(AjaxResult.FAIL);
                ajaxResult.setMessage("下单失败:"+callExpressResponse.getERROR().getText());
            }else{
                ajaxResult.setCode(AjaxResult.SUCCESS);
                ajaxResult.setMessage("下单成功");
                ajaxResult.setData(callExpressResponse.getBody());
            }

        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setCode(AjaxResult.SUCCESS);
            ajaxResult.setMessage("下单失败");
        }
        return ajaxResult;
    }

    @RequestMapping("/queryResult")
    @ResponseBody
    public AjaxResult queeryResult(@RequestBody OrderSearch orderSearch){
        AjaxResult ajaxResult = new AjaxResult();
        try{
            CallExpressResponse callExpressResponse = orderService.queryOrderResult(orderSearch);

            if(SfExpressConstant.SfEXPRESS_ERR.equals(callExpressResponse.getHead())){
                ajaxResult.setCode(AjaxResult.FAIL);
                ajaxResult.setMessage("查询失败:"+callExpressResponse.getERROR());
            }else{
                ajaxResult.setCode(AjaxResult.SUCCESS);
                ajaxResult.setMessage("查询成功");
                ajaxResult.setData(callExpressResponse.getBody());
            }
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setCode(AjaxResult.SUCCESS);
            ajaxResult.setMessage("查询失败");
        }
        return ajaxResult;

    }

    @RequestMapping("/confirmOrder")
    @ResponseBody
    public AjaxResult confirmOrder(@RequestBody OrderConfirm orderConfirm){
        AjaxResult ajaxResult = new AjaxResult();
        try{
            CallExpressResponse callExpressResponse = orderService.confirmOrder(orderConfirm);

            if(SfExpressConstant.SfEXPRESS_ERR.equals(callExpressResponse.getHead())){
                ajaxResult.setCode(AjaxResult.FAIL);
                ajaxResult.setMessage("查询失败:"+callExpressResponse.getERROR());
            }else if(SfExpressConstant.RETURN_CODE_TWO.equals(callExpressResponse.getBody().getOrderConfirmResponse().getRes_status())){
                ajaxResult.setCode(AjaxResult.SUCCESS);
                ajaxResult.setMessage("查询成功");
                ajaxResult.setData(callExpressResponse.getBody());
            }else{
                ajaxResult.setCode(AjaxResult.FAIL);
                ajaxResult.setMessage("操作失败，客户订单号与顺丰运单不匹配");
            }
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setCode(AjaxResult.SUCCESS);
            ajaxResult.setMessage("查询失败");
        }
        return ajaxResult;

    }
}
