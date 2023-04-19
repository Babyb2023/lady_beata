package com.beata.beataCRUD.controller;

import com.beata.beataCRUD.entity.OrderTrackingEntity;
import com.beata.beataCRUD.exception.OrderTrackingException;
import com.beata.beataCRUD.repository.OrderTrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orderTracking")
public class OrderTrackingController {

    @Autowired
    private OrderTrackingRepository orderTrackingRepository;

    @GetMapping
    public List<OrderTrackingEntity> getAllOrder(){
        return orderTrackingRepository.findAll();
    }

    //build create employee REST API
    @PostMapping
    public OrderTrackingEntity createOder(@RequestBody OrderTrackingEntity orderTracking){
        return orderTrackingRepository.save(orderTracking);
    }

    //build get employee by id REST API
    @GetMapping({"id"})
    public ResponseEntity<OrderTrackingEntity> getOrderById(@PathVariable long id){
        OrderTrackingEntity employee = orderTrackingRepository.findById(id)
                .orElseThrow(() -> new OrderTrackingException("Order not exist with id:" + id));
        return ResponseEntity.ok(employee);
    }

    //build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<OrderTrackingEntity> updateOder(@PathVariable long id,@RequestBody OrderTrackingEntity orderTrackingDetails){
        OrderTrackingEntity updateOrder = orderTrackingRepository.findById(id)
                .orElseThrow(() -> new OrderTrackingException("Order not exist with id: " + id));

        updateOrder.setOrderNo(orderTrackingDetails.getOrderNo());
        updateOrder.setEmail(orderTrackingDetails.getEmail());
        updateOrder.setDeliveryDate(orderTrackingDetails.getDeliveryDate());
        updateOrder.setOrderSummary(orderTrackingDetails.getOrderSummary());
        updateOrder.setOrderStatus(orderTrackingDetails.getOrderStatus());
        updateOrder.setCustomerSupport(orderTrackingDetails.getCustomerSupport());

        orderTrackingRepository.save(updateOrder);
        return ResponseEntity.ok(updateOrder);
    }

    //build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable long id){

        OrderTrackingEntity orderTracking = orderTrackingRepository.findById(id)
                .orElseThrow(() -> new OrderTrackingException("Order not exist with id: " + id));

        orderTrackingRepository.delete(orderTracking);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
