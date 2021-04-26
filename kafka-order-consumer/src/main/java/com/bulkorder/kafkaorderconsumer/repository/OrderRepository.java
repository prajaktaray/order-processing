package com.bulkorder.kafkaorderconsumer.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bulkorder.kafkaorderconsumer.model.OrderModel;

@Repository
public interface OrderRepository extends CrudRepository<OrderModel,String>{
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE ecommerce.orders  SET order_status = :order_status WHERE order_id = :order_id", nativeQuery = true)
	void updateByOrderId(@Param("order_id") String order_id,@Param("order_status") String order_status);

}
