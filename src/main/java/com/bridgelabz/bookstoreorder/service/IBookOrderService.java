package com.bridgelabz.bookstoreorder.service;

import org.springframework.stereotype.Service;

import com.bridgelabz.bookstoreorder.dto.BookOrderDTO;
import com.bridgelabz.bookstoreorder.dto.ResponseDTO;


@Service
public interface IBookOrderService {

	ResponseDTO placeOrder(String token, BookOrderDTO orderDTO,int bookid);

	ResponseDTO getAllOrders(String token);

	ResponseDTO getOrder(String token, int orderid);

	ResponseDTO cancelOrder(String token, int orderid);
	
}
