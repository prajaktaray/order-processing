package com.ecommerce.orderprocessing.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.orderprocessing.model.OrderModel;

@Repository
public interface OrderRepository extends CrudRepository<OrderModel, String> {
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE ecommerce.orders  SET order_status = 'CANCELLED' WHERE order_id = :order_id", nativeQuery = true)
	void cancelByOrderId(@Param("order_id") String order_id);
	
	@Query(value ="SELECT * FROM ecommerce.orders o WHERE o.order_id = :order_id",
			nativeQuery = true)
	List<OrderModel> findByOrderId(@Param("order_id") String order_id);
	
	
	

}
