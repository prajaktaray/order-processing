package com.bulkorder.kafkaorderproducer.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

/*
@Entity
@Table(name = "orders", schema = "ecommerce")*/
//@Component
public class OrderModel implements Serializable{
	
	//@Id
	//@Column(name = "order_id")
	private String order_id;
	//@Column(name = "order_status")
	private String order_status;
	//@Column(name = "order_customer_id")
	private String order_customer_id;
	//@Column(name = "order_item_name")
	private String order_item_name;
	//@Column(name = "order_item_qty")
	private int order_item_qty;
	//@Column(name = "order_subtotal")
	private double order_subtotal;
	//@Column(name = "order_tax")
	private double order_tax;
	//@Column(name = "order_shipping_charges")
	private double order_shipping_charges;
	//@Column(name = "order_total")
	private double order_total;
	//private String order_payment_method;
	//private Date order_payment_date;
	
	
	//@Column(name = "order_payment_confirmation_number")
	private String order_payment_confirmation_number;
	//@Column(name = "order_payment_details", columnDefinition = "json")
	//@Convert(converter = PaymentModelConverter.class)
	private PaymentModel order_payment_details;
	
	//@Column(name = "order_shipping_delivery_method")
	private String order_shipping_delivery_method;
	//@Column(name = "order_shipping_addressline1")
	private String order_shipping_addressline1;
	//@Column(name = "order_shipping_addressline2")
	private String order_shipping_addressline2;
	//@Column(name = "order_shipping_city")
	private String order_shipping_city;
	//@Column(name = "order_shipping_state")
	private String order_shipping_state;
	//@Column(name = "order_shipping_zip")
	private int order_shipping_zip;
	//@Column(name = "ordermodel0_.order_createdDate")
	//@Transient
	private Date order_created_date;
	//@Column(name = "order_modified_date")
	//@Transient
	private Date order_modified_date;
	
	
	
	public OrderModel() {
	}



	public OrderModel(String order_id, String order_status, String order_customer_id, String order_item_name,
			int order_item_qty, double order_subtotal, double order_tax, double order_shipping_charges,
			double order_total, String order_payment_confirmation_number, PaymentModel order_payment_details,
			String order_shipping_delivery_method, String order_shipping_addressline1,
			String order_shipping_addressline2, String order_shipping_city, String order_shipping_state,
			int order_shipping_zip, Date order_created_date, Date order_modified_date) {
		super();
		this.order_id = order_id;
		this.order_status = order_status;
		this.order_customer_id = order_customer_id;
		this.order_item_name = order_item_name;
		this.order_item_qty = order_item_qty;
		this.order_subtotal = order_subtotal;
		this.order_tax = order_tax;
		this.order_shipping_charges = order_shipping_charges;
		this.order_total = order_total;
		this.order_payment_confirmation_number = order_payment_confirmation_number;
		this.order_payment_details = order_payment_details;
		this.order_shipping_delivery_method = order_shipping_delivery_method;
		this.order_shipping_addressline1 = order_shipping_addressline1;
		this.order_shipping_addressline2 = order_shipping_addressline2;
		this.order_shipping_city = order_shipping_city;
		this.order_shipping_state = order_shipping_state;
		this.order_shipping_zip = order_shipping_zip;
		this.order_created_date = order_created_date;
		this.order_modified_date = order_modified_date;
	}





	public String getOrder_id() {
		return order_id;
	}



	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}



	public String getOrder_status() {
		return order_status;
	}



	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}



	public String getOrder_customer_id() {
		return order_customer_id;
	}



	public void setOrder_customer_id(String order_customer_id) {
		this.order_customer_id = order_customer_id;
	}






	public String getOrder_shipping_delivery_method() {
		return order_shipping_delivery_method;
	}



	public void setOrder_shipping_delivery_method(String order_shipping_delivery_method) {
		this.order_shipping_delivery_method = order_shipping_delivery_method;
	}



	public int getOrder_item_qty() {
		return order_item_qty;
	}



	public void setOrder_item_qty(int order_item_qty) {
		this.order_item_qty = order_item_qty;
	}



	public double getOrder_subtotal() {
		return order_subtotal;
	}



	public void setOrder_subtotal(double order_subtotal) {
		this.order_subtotal = order_subtotal;
	}



	public double getOrder_tax() {
		return order_tax;
	}



	public void setOrder_tax(double order_tax) {
		this.order_tax = order_tax;
	}



	public double getOrder_shipping_charges() {
		return order_shipping_charges;
	}



	public void setOrder_shipping_charges(double order_shipping_charges) {
		this.order_shipping_charges = order_shipping_charges;
	}



	public double getOrder_total() {
		return order_total;
	}



	public void setOrder_total(double order_total) {
		this.order_total = order_total;
	}



	/*
	 * public String getOrder_payment_method() { return order_payment_method; }
	 * 
	 * 
	 * 
	 * public void setOrder_payment_method(String order_payment_method) {
	 * this.order_payment_method = order_payment_method; }
	 * 
	 * 
	 * 
	 * public Date getOrder_payment_date() { return order_payment_date; }
	 * 
	 * 
	 * 
	 * public void setOrder_payment_date(Date order_payment_date) {
	 * this.order_payment_date = order_payment_date; }
	 */



	public String getOrder_payment_confirmation_number() {
		return order_payment_confirmation_number;
	}



	public void setOrder_payment_confirmation_number(String order_payment_confirmation_number) {
		this.order_payment_confirmation_number = order_payment_confirmation_number;
	}



	public String getOrder_shipping_addressline1() {
		return order_shipping_addressline1;
	}



	public void setOrder_shipping_addressline1(String order_shipping_addressline1) {
		this.order_shipping_addressline1 = order_shipping_addressline1;
	}



	public String getOrder_shipping_addressline2() {
		return order_shipping_addressline2;
	}



	public void setOrder_shipping_addressline2(String order_shipping_addressline2) {
		this.order_shipping_addressline2 = order_shipping_addressline2;
	}



	public String getOrder_shipping_city() {
		return order_shipping_city;
	}



	public void setOrder_shipping_city(String order_shipping_city) {
		this.order_shipping_city = order_shipping_city;
	}



	public String getOrder_shipping_state() {
		return order_shipping_state;
	}



	public void setOrder_shipping_state(String order_shipping_state) {
		this.order_shipping_state = order_shipping_state;
	}



	public int getOrder_shipping_zip() {
		return order_shipping_zip;
	}



	public void setOrder_shipping_zip(int order_shipping_zip) {
		this.order_shipping_zip = order_shipping_zip;
	}


	




	public String getOrder_item_name() {
		return order_item_name;
	}



	public void setOrder_item_name(String order_item_name) {
		this.order_item_name = order_item_name;
	}



	public PaymentModel getOrder_payment_details() {
		return order_payment_details;
	}



	public void setOrder_payment_details(PaymentModel order_payment_details) {
		this.order_payment_details = order_payment_details;
	}



	public Date getOrder_created_date() {
		return order_created_date;
	}




	public void setOrder_created_date(Date order_created_date) {
		this.order_created_date = order_created_date;
	}




	public Date getOrder_modified_date() {
		return order_modified_date;
	}




	public void setOrder_modified_date(Date order_modified_date) {
		this.order_modified_date = order_modified_date;
	}



	@Override
	public String toString() {
		return "OrderModel [order_id=" + order_id + ", order_status=" + order_status + ", order_customer_id="
				+ order_customer_id + ", order_item_name="// + Arrays.toString(order_item_name) + ", order_item_qty="
				+ order_item_qty + ", order_subtotal=" + order_subtotal + ", order_tax=" + order_tax
				+ ", order_shipping_charges=" + order_shipping_charges + ", order_total=" + order_total
				+ ", order_payment_confirmation_number=" + order_payment_confirmation_number
				+ ", order_payment_details=" //+ Arrays.toString(order_payment_details)
				+ ", order_shipping_delivery_method=" + order_shipping_delivery_method
				+ ", order_shipping_addressline1=" + order_shipping_addressline1 + ", order_shipping_addressline2="
				+ order_shipping_addressline2 + ", order_shipping_city=" + order_shipping_city
				+ ", order_shipping_state=" + order_shipping_state + ", order_shipping_zip=" + order_shipping_zip
				+ ", order_created_date=" + order_created_date + ", order_modified_date=" + order_modified_date + "]";
	}



}
