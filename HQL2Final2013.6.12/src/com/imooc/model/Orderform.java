package com.imooc.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Orderform entity. @author MyEclipse Persistence Tools
 */

public class Orderform implements java.io.Serializable {

	// Fields

	private Integer id;
	private Customer customer;
	private Date tradedate;
	private String status;
	private double amount;
	// 一个订单主表有多个订单明细
	private Set orderitems = new HashSet(0);

	// Constructors

	/** default constructor */
	public Orderform() {
	}

	/** full constructor */
	public Orderform(Customer customer, Date tradedate, String status,
			double amount, Set orderitems) {
		this.customer = customer;
		this.tradedate = tradedate;
		this.status = status;
		this.amount = amount;
		this.orderitems = orderitems;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getTradedate() {
		return this.tradedate;
	}

	public void setTradedate(Date tradedate) {
		this.tradedate = tradedate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Set getOrderitems() {
		return this.orderitems;
	}

	public void setOrderitems(Set orderitems) {
		this.orderitems = orderitems;
	}

}