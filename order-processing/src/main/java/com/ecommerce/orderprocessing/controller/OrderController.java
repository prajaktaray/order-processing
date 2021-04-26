package com.ecommerce.orderprocessing.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.Transient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.orderprocessing.exception.OrderNotFoundException;
import com.ecommerce.orderprocessing.model.OrderModel;
import com.ecommerce.orderprocessing.repository.OrderRepository;
import com.ecommerce.orderprocessing.services.OrderServices;

@RestController
public class OrderController {

	@Autowired
	OrderServices order_services;
	
	@Autowired
	OrderRepository order_repo;
	
	@Transient 
	private UUID uuid;
	
	@LocalServerPort
	private int port;
	
	private static Logger logger = LogManager.getLogger();

	@GetMapping("/get-order-by-id/{order_id}")
	public ResponseEntity<OrderModel> getOrderById(@PathVariable String order_id) {

		logger.info("Get Request");
		//if(order_services.getOrderByOrderId(order_id))
		List<OrderModel> orders = order_services.getOrderByOrderId(order_id);
		if(!order_repo.findById(order_id).isPresent()) throw new OrderNotFoundException();
		return new ResponseEntity(orders, HttpStatus.FOUND);
	}

	@PostMapping("/create-order")
	public ResponseEntity<OrderModel> addData(@RequestBody OrderModel model) throws UnknownHostException {

		
		if (model == null)
			return new ResponseEntity("Insert failed", HttpStatus.BAD_REQUEST);

		String uuid = String.valueOf(Math.abs(UUID.randomUUID().hashCode()));
		String ip = InetAddress.getLocalHost().getHostAddress().replace(".","");
		String order_id = uuid+"-"+ip;
		//System.out.println(order_id);
		model.setOrder_id(order_id);
		model.setOrder_status("NEW");
	
	      
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd");
	    LocalDateTime now = LocalDateTime.now();
	   // System.out.println(dtf.format(now));
	    dtf.format(now);
	    Date finalDate = Date.from(now.toInstant(ZoneOffset.UTC));
	    System.out.println(finalDate);
		model.setOrder_created_date(finalDate);
		model.setOrder_modified_date(finalDate);
		
		System.out.println(model.toString());
		OrderModel response = order_services.createNewOrder(model);

		if (response != null)
			return new ResponseEntity("Row inserted", HttpStatus.CREATED);
		return new ResponseEntity("Insert Failed", HttpStatus.BAD_REQUEST);
	}

	
	  @PutMapping("/cancel-order/{order_id}") 
	  public ResponseEntity<OrderModel> cancelOrder(@RequestBody OrderModel order, @PathVariable String order_id){ 
		
		  Optional<OrderModel> orderOptional = order_repo.findById(order_id); 
		  if(!orderOptional.isPresent()) {  
			  return new ResponseEntity("No Orders Deleted!", HttpStatus.NOT_FOUND);		  
		  }
		 
		  order_repo.cancelByOrderId(order_id); 
		  //order_services.cancelOrderByOrderId(order_id); 
		  return new ResponseEntity("Order cancelled successfully!", HttpStatus.OK);
		  }
	 

}
