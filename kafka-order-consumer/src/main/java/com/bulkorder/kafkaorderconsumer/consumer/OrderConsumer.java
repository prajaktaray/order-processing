package com.bulkorder.kafkaorderconsumer.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bulkorder.kafkaorderconsumer.service.OrderConsumerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Component
public class OrderConsumer {
	private final Logger logger = 
            LoggerFactory.getLogger(OrderConsumer.class);
	public static final String TOPIC_NAME = "orders";
	public static final String TOPIC_NAME2 = "orders-update";
	public static final String GROUP_ID = "group_id";
	
	@Autowired
	OrderConsumerService consumerService;
 
    @KafkaListener(topics = TOPIC_NAME, 
            groupId = GROUP_ID)
    public void consume(ConsumerRecord<String,String> consumerRecord) throws JsonMappingException, JsonProcessingException 
    {
    	System.out.println("In consumer");
        logger.info(String.format("Message recieved -> %s", consumerRecord));
        consumerService.createOrders(consumerRecord);
        
    }
    
    @KafkaListener(topics = TOPIC_NAME2, 
            groupId = GROUP_ID)
    public void consumeOrderUpdate(ConsumerRecord<String,String> consumerRecord) throws JsonMappingException, JsonProcessingException 
    {
    	System.out.println("In consumer");
        logger.info(String.format("Message recieved -> %s", consumerRecord));
       // logger.
        consumerService.updateOrders(consumerRecord);
        
    }

}
