package com.capgemini.order.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ordertable")
public class Order {
	
	private int customerId;
	private int orderId;
	private float ordersTotal;
	@DateTimeFormat(pattern="YYYY-MM-DD")
	private LocalDate date;
	public Order() {
		super();

	}
	public Order(int orderId, float ordersTotal, LocalDate date) {
		super();
		this.orderId = orderId;
		this.ordersTotal = ordersTotal;
		this.date = date;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public float getOrdersTotal() {
		return ordersTotal;
	}
	public void setOrdersTotal(float ordersTotal) {
		this.ordersTotal = ordersTotal;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", ordersTotal=" + ordersTotal + ", date=" + date + "]";
	}
	
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Entity
	@Table(name="items")
	public class LineItem {
		
		private int productId;
		private int lineItemId;
		private int ordersQuantity;
		public LineItem() {
			super();
			// TODO Auto-generated constructor stub
		}
		public LineItem(int lineItemId, int ordersQuantity) {
			super();
			this.lineItemId = lineItemId;
			this.ordersQuantity = ordersQuantity;
		}
		public int getLineItemId() {
			return lineItemId;
		}
		public void setLineItemId(int lineItemId) {
			this.lineItemId = lineItemId;
		}
		public int getOrdersQuantity() {
			return ordersQuantity;
		}
		public void setOrdersQuantity(int ordersQuantity) {
			this.ordersQuantity = ordersQuantity;
		}
		public int getProductId() {
			return productId;
		}
		public void setProductId(int productId) {
			this.productId = productId;
		}
		
		
	}
	

}
