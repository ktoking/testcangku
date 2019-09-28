package com.fehead.controller;

import com.fehead.controller.vo.OrderDetailVO;
import com.fehead.controller.vo.OrderListVO;
import com.fehead.error.BusinessException;
import com.fehead.error.EmBusinessError;
import com.fehead.model.StatusModel;
import com.fehead.response.CommonReturnType;
import com.fehead.service.OrderService;
import com.fehead.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.omg.CORBA.ORB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/{version}/SUSTDelivery/view")
@RestController
public class OrderController extends BaseController{
    public static Log logger = LogFactory.getLog(OrderController.class);
    @Autowired
    OrderService orderService;

    /**
     * 分页查找订单（只返回可接订单）
     * @param page
     * @param pagesize
     * @return
     * @throws BusinessException
     */
    @GetMapping("/order/lists")
    public CommonReturnType selectItemByStatusOk(@RequestParam(value = "page") Integer page,
                                                 @RequestParam("pagesize") Integer pagesize) throws BusinessException {
        logger.info("PARAM: 第几页 " + page);
        logger.info("PARAM: 页面数量 " + pagesize);

        List<OrderListVO> realOrderListVOList=new ArrayList<>();
        try {
            realOrderListVOList=orderService.selectItemByStatusOk(page,pagesize);
            logger.info("SUCCESS: selectItemByStatusOk" );
        }catch (Exception ex){
            logger.info("EXCEPTION: " + EmBusinessError.DATA_SELECT_ERROR.getErrorCode() + " " + EmBusinessError.DATA_SELECT_ERROR.getErrorMsg());
            throw new BusinessException(EmBusinessError.DATA_SELECT_ERROR);
        }
        return  CommonReturnType.creat(realOrderListVOList);

    }

    /**
     * 修改订单状态
     * @param orderId
     * @param statusId
     * @return
     * @throws BusinessException
     */
    @PutMapping("/order/lists/{order_id}/status/{status_id}")
    public CommonReturnType updateItemStatus(@PathVariable("order_id") Integer orderId,
                                             @PathVariable("status_id") Integer statusId) throws BusinessException {

        logger.info("PARAM: 订单ID " + orderId);
        logger.info("PARAM: 订单状态ID " + statusId);
        try{
            orderService.updateStatus(orderId,statusId);
            logger.info("SUCCESS: updateItemStatus" );
        }catch (Exception ex){
            logger.info("EXCEPTION: " + EmBusinessError.DATA_UPDATE_ERROR.getErrorCode() + " " + EmBusinessError.DATA_UPDATE_ERROR.getErrorMsg());
            throw new BusinessException(EmBusinessError.DATA_UPDATE_ERROR);
        }
        return CommonReturnType.creat(null);
    }
    @GetMapping("/order/lists/{id}/info")
    public CommonReturnType getOrderInfo(@PathVariable("id") Integer id) throws Exception {
        logger.info("PARAM: id "+id);
        OrderDetailVO orderDetailVO=new OrderDetailVO();
        try {
            orderDetailVO = orderService.getDetailOrder(id);
        }catch (Exception e){
            logger.info("EXCEPTION: " + EmBusinessError.DATA_SELECT_ERROR.getErrorCode() + " "
                    + EmBusinessError.DATA_SELECT_ERROR.getErrorMsg());
            throw new BusinessException(EmBusinessError.DATA_SELECT_ERROR,"获取详细订单异常");
        }
        logger.info("SUCCESS: putOrderInfo ");
        return CommonReturnType.creat(orderDetailVO);

    }



}
