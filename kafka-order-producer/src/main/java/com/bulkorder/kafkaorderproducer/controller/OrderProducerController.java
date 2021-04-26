package com.bulkorder.kafkaorderproducer.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bulkorder.kafkaorderproducer.model.OrderModel;
import com.bulkorder.kafkaorderproducer.service.OrderProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class OrderProducerController {
	private final OrderProducerService producerService;
	 
    @Autowired
    public OrderProducerController(OrderProducerService producerService) 
    {
        this.producerService = producerService;
    }
 
    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestBody List<OrderModel> models) throws JsonProcessingException 
    {
    	
    	for(OrderModel model : models) {
    		System.out.println(model.toString());
    		producerService.send(model);
    		
    	}
       
    }
    
    @PutMapping("/update-bulk-order") 
	  public ResponseEntity<OrderModel> cancelOrder(@RequestBody HashMap<String,String> orderList){ 
	
				
		  producerService.updateOrderStatus(orderList); 
		  return new ResponseEntity("Order cancelled successfully!", HttpStatus.OK);
		  }
}
