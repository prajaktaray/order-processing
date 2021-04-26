package com.bulkorder.kafkaorderproducer.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.bulkorder.kafkaorderproducer.model.OrderModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OrderProducerService {
	private static final Logger logger = 
            LoggerFactory.getLogger(OrderProducerService.class);
	
	public static final String TOPIC_NAME = "orders";
	public static final String TOPIC_NAME2 = "orders-update";
	
	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
	
	@Autowired
	ObjectMapper objectMapper;
	
	public void send( OrderModel model) throws JsonProcessingException 
    {
        String key = model.getOrder_id();
        String value = objectMapper.writeValueAsString(model);
       // System.out.println("Key" + key);
        ProducerRecord<String,String> producerRecord =buildProducerRecord(key,value);
		//logger.info(String.format("Message sent from producer -> %s", model));
        ListenableFuture<SendResult<String, String>> listenablefuture = kafkaTemplate.send(producerRecord);
        listenablefuture.addCallback(new ListenableFutureCallback<SendResult<String,String>>() {

			@Override
			public void onSuccess(SendResult<String, String> result) {
				handleSuccess(key,value,result);
				
			}

			@Override
			public void onFailure(Throwable ex) {
				handleFailure(key,value,ex);
				
			}
        	
        });
    }



	private ProducerRecord<String,String> buildProducerRecord(String key, String value) {
		return new ProducerRecord<>(TOPIC_NAME, null, key,value,null);
		
	}
	
	protected void handleFailure(String key, String value, Throwable ex) {
		logger.info(String.format("Message sent failed -> %s", ex));
	}

	protected void handleSuccess(String key, String value, SendResult<String, String> result) {
		logger.info(String.format("Message sent  successfully -> %s", result));
	}



	public void updateOrderStatus(HashMap<String, String> orderList) {
		for(Entry<String, String> order : orderList.entrySet()) {
			String key = order.getKey();
			String value = order.getValue();
			ProducerRecord<String,String> producerRecord =buildProducerRecordUpdate(key,value);
			ListenableFuture<SendResult<String, String>> listenablefuture = kafkaTemplate.send(producerRecord);
	        listenablefuture.addCallback(new ListenableFutureCallback<SendResult<String,String>>() {

				@Override
				public void onSuccess(SendResult<String, String> result) {
					handleSuccess(key,value,result);
					
				}

				@Override
				public void onFailure(Throwable ex) {
					handleFailure(key,value,ex);
					
				}
	        	
	        });
		}
		
		
	}



	private ProducerRecord<String, String> buildProducerRecordUpdate(String key, String value) {
		return new ProducerRecord<>(TOPIC_NAME2, null, key,value,null);
	}

}
