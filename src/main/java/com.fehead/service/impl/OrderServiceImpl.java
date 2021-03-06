package com.fehead.service.impl;

import com.fehead.controller.vo.OrderDetailVO;
import com.fehead.controller.vo.OrderListVO;
import com.fehead.model.DeliveryPointModel;
import com.fehead.model.OrderModel;
import com.fehead.model.StatusModel;
import com.fehead.service.CloudService;
import com.fehead.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private CloudService cloudService;


    @Override
    public List<OrderListVO> selectItemByStatusOk(Integer page,Integer pagesize) {


        List<OrderModel> orderModelList=cloudService.getAcceptableOrder(page,pagesize);

        List<OrderListVO> realOrderListVOList=orderModelList.stream().map(orderModel -> {
            OrderListVO orderListVO=new OrderListVO();
            BeanUtils.copyProperties(orderModel,orderListVO);
            return orderListVO;
        }).collect(Collectors.toList());

        return realOrderListVOList;
    }

    public void updateStatus(Integer orderId,Integer statusId){

        cloudService.updateStatus(orderId,statusId);

        return;
    }

    //查找该订单详细信息
    @Override
    public OrderDetailVO getDetailOrder(Integer id) {
        OrderModel orderModel=new OrderModel();
        orderModel=cloudService.getOrderById(id);
        OrderDetailVO orderDetailVO=new OrderDetailVO();
        BeanUtils.copyProperties(orderModel,orderDetailVO);
        return orderDetailVO;
    }


}
