package com.arnoldatse.authmanager.customers.rest;

import com.arnoldatse.authmanager.customers.dto.OrderResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @GetMapping
    public List<OrderResponseDto> orders(){
        List<OrderResponseDto> orders = new ArrayList<OrderResponseDto>();
        orders.add(new OrderResponseDto("1512", java.time.LocalDateTime.now(), 250000));
        orders.add(new OrderResponseDto("2519", java.time.LocalDateTime.now(), 250000));
        orders.add(new OrderResponseDto("9856", java.time.LocalDateTime.now(), 250000));

        return  orders;
    }
}
