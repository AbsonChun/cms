package com.dusk.cms.controller;

import com.dusk.cms.Payment8001;
import com.dusk.cms.pojo.CommonResult;
import com.dusk.cms.pojo.Payment;
import com.dusk.cms.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Integer id){
        //使用IService接口自带的方法
        Payment result = paymentService.getById(id);
        log.info("********结果为****" + result);
        if (result !=null) {
            return new CommonResult(200, "插入数据库成功" + ":" + serverPort, result);
        } else {
            return new CommonResult(400, "插入数据库失败", null);
        }
    }
}
