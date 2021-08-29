package com.bridgelabz.bookstoreorder.dto;

import lombok.Data;

@Data
public class BookOrderDTO 
{
	private long orderQuantity;
	private int orderPrice;
	private String address;
}
