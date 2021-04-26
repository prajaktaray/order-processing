package com.bulkorder.kafkaorderconsumer.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class PaymentModel  implements Serializable{
	
	
	private String order_payment_confirmation_number;
	private String order_method; // CC/DC/Cash
	private double order_payment_amount;
	private Date order_payment_date;
	private String order_billing_addressline1;
	private String order_billing_addressline2;
	private String order_billing_city;
	private String order_billing_state;
	private int order_billing_zip;
	
	public PaymentModel() {	}

	public PaymentModel(String order_payment_confirmation_number, String order_method, double order_payment_amount,
			Date order_payment_date, String order_billing_addressline1, String order_billing_addressline2,
			String order_billing_city, String order_billing_state, int order_billing_zip) {
		super();
		this.order_payment_confirmation_number = order_payment_confirmation_number;
		this.order_method = order_method;
		this.order_payment_amount = order_payment_amount;
		this.order_payment_date = order_payment_date;
		this.order_billing_addressline1 = order_billing_addressline1;
		this.order_billing_addressline2 = order_billing_addressline2;
		this.order_billing_city = order_billing_city;
		this.order_billing_state = order_billing_state;
		this.order_billing_zip = order_billing_zip;
	}

	public String getOrder_payment_confirmation_number() {
		return order_payment_confirmation_number;
	}

	public void setOrder_payment_confirmation_number(String order_payment_confirmation_number) {
		this.order_payment_confirmation_number = order_payment_confirmation_number;
	}

	public String getOrder_method() {
		return order_method;
	}

	public void setOrder_method(String order_method) {
		this.order_method = order_method;
	}

	public double getOrder_payment_amount() {
		return order_payment_amount;
	}

	public void setOrder_payment_amount(double order_payment_amount) {
		this.order_payment_amount = order_payment_amount;
	}

	public Date getOrder_payment_date() {
		return order_payment_date;
	}

	public void setOrder_payment_date(Date order_payment_date) {
		this.order_payment_date = order_payment_date;
	}

	public String getOrder_billing_addressline1() {
		return order_billing_addressline1;
	}

	public void setOrder_billing_addressline1(String order_billing_addressline1) {
		this.order_billing_addressline1 = order_billing_addressline1;
	}

	public String getOrder_billing_addressline2() {
		return order_billing_addressline2;
	}

	public void setOrder_billing_addressline2(String order_billing_addressline2) {
		this.order_billing_addressline2 = order_billing_addressline2;
	}

	public String getOrder_billing_city() {
		return order_billing_city;
	}

	public void setOrder_billing_city(String order_billing_city) {
		this.order_billing_city = order_billing_city;
	}

	public String getOrder_billing_state() {
		return order_billing_state;
	}

	public void setOrder_billing_state(String order_billing_state) {
		this.order_billing_state = order_billing_state;
	}

	public int getOrder_billing_zip() {
		return order_billing_zip;
	}

	public void setOrder_billing_zip(int order_billing_zip) {
		this.order_billing_zip = order_billing_zip;
	}

	@Override
	public String toString() {
		return "PaymentModel [order_payment_confirmation_number=" + order_payment_confirmation_number
				+ ", order_method=" + order_method + ", order_payment_amount=" + order_payment_amount
				+ ", order_payment_date=" + order_payment_date + ", order_billing_addressline1="
				+ order_billing_addressline1 + ", order_billing_addressline2=" + order_billing_addressline2
				+ ", order_billing_city=" + order_billing_city + ", order_billing_state=" + order_billing_state
				+ ", order_billing_zip=" + order_billing_zip + "]";
	}
	
	
	

}
