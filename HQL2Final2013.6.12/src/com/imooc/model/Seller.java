package com.imooc.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Seller entity. @author MyEclipse Persistence Tools
 */

public class Seller implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String tel;
	private String address;
	private String website;
	private Integer star;
	private String business;
	// 一个卖家有多个商品 set集合不允许重复
	private Set commodities = new HashSet(0);

	// Constructors

	/** default constructor */
	public Seller() {
	}

	/** full constructor */
	public Seller(String name, String tel, String address, String website,
			Integer star, String business, Set commodities) {
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.website = website;
		this.star = star;
		this.business = business;
		this.commodities = commodities;
	}

	// Property accessors

	public Seller(String name, String tel) {
		super();
		this.name = name;
		this.tel = tel;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Integer getStar() {
		return this.star;
	}

	public void setStar(Integer star) {
		this.star = star;
	}

	public String getBusiness() {
		return this.business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public Set getCommodities() {
		return this.commodities;
	}

	public void setCommodities(Set commodities) {
		this.commodities = commodities;
	}

}