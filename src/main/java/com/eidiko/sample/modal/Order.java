package com.eidiko.sample.modal;

public class Order {

	private String orderName;
	private String cardType;
	private int discount;
	private int price;
	public Order(String orderName, String cardType, int discount, int price) {
		super();
		this.orderName = orderName;
		this.cardType = cardType;
		this.discount = discount;
		this.price = price;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
