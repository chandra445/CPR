package com.shoppingmall.pojo;

import java.util.Date;

public class OrderDetails {
	private String ordid;
	private String custid;
	private String uname;
	private double bill;
	private Date orderDate;
	private String strname;
	private String productName;
	private double price;
	private int quantity;
	private double totalPriceForProduct;
	public String getOrdid() {
		return ordid;
	}
	public void setOrdid(String ordid) {
		this.ordid = ordid;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public double getBill() {
		return bill;
	}
	public void setBill(double bill) {
		this.bill = bill;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getStrname() {
		return strname;
	}
	public void setStrname(String strname) {
		this.strname = strname;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPriceForProduct() {
		return totalPriceForProduct;
	}
	public void setTotalPriceForProduct(double totalPriceForProduct) {
		this.totalPriceForProduct = totalPriceForProduct;
	}
	

}
