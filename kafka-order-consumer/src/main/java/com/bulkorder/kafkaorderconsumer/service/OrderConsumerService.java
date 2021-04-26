package com.bulkorder.kafkaorderconsumer.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bulkorder.kafkaorderconsumer.model.OrderModel;
import com.bulkorder.kafkaorderconsumer.model.PaymentModel;
import com.bulkorder.kafkaorderconsumer.repository.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OrderConsumerService {
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
	OrderRepository order_repo;
	
	public void createOrders(ConsumerRecord<String,String> consumerRecord) throws JsonMappingException, JsonProcessingException {
		OrderModel order = objectMapper.readValue(consumerRecord.value(), OrderModel.class);
		//PaymentModel paymentmodel = objectMapper.readValue(consumerRecord.value()., valueType)
		//System.out.println(order.getOrder_payment_details().toString());
		//PaymentModel x = order.getOrder_payment_details();
		//order.setOrder_payment_details(x);
		OrderModel response = order_repo.save(order);
		//return null;
	}

	private OrderModel save(OrderModel order) {
		PaymentModel x = order.getOrder_payment_details();
		//order.setOrder_payment_details(objectMapper.writeValueAsString(x));
		//System.out.println(x);
		return null;
	}

	public void updateOrders(ConsumerRecord<String, String> consumerRecord) {
		String order_id = consumerRecord.key();
		String order_status = consumerRecord.value();
		//System.out.println(key + " \t" + order);
		order_repo.updateByOrderId(order_id,order_status);
		
	}

}
