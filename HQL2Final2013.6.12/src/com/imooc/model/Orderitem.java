package com.imooc.model;

/**
 * Orderitem entity. @author MyEclipse Persistence Tools
 */

public class Orderitem implements java.io.Serializable {

	// Fields

	private Integer id;
	private Commodity commodity;
	private Orderform orderform;
	private double discount;
	private double actprice;
	private double amount;

	// Constructors

	/** default constructor */
	public Orderitem() {
	}

	/** full constructor */
	public Orderitem(Commodity commodity, Orderform orderform, double discount,
			double actprice, double amount) {
		this.commodity = commodity;
		this.orderform = orderform;
		this.discount = discount;
		this.actprice = actprice;
		this.amount = amount;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Commodity getCommodity() {
		return this.commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public Orderform getOrderform() {
		return this.orderform;
	}

	public void setOrderform(Orderform orderform) {
		this.orderform = orderform;
	}

	public double getDiscount() {
		return this.discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getActprice() {
		return this.actprice;
	}

	public void setActprice(double actprice) {
		this.actprice = actprice;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}