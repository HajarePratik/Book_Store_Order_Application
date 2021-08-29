package com.bridgelabz.bookstoreorder.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="BookOrders")
@Data
public class BookOrderModel
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int orderId;
	private LocalDate orderDate;
	private long orderQuantity;
	private double orderPrice;
	private String address;
	private int userId;
	private int bookId;
}
