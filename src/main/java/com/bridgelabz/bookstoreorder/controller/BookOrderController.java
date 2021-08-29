package com.bridgelabz.bookstoreorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.bookstoreorder.dto.BookOrderDTO;
import com.bridgelabz.bookstoreorder.dto.ResponseDTO;
import com.bridgelabz.bookstoreorder.service.IBookOrderService;


@RestController
public class BookOrderController 
{
	
	@Autowired
	IBookOrderService bookOrderService;
	
	
	@PostMapping("/placeorder/{token}/{bookid}")
	public ResponseEntity<ResponseDTO> placeOrder(@PathVariable String token,@RequestBody BookOrderDTO orderDTO,@RequestParam int bookid)
	{
		ResponseDTO respDTO = bookOrderService.placeOrder(token,orderDTO,bookid);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@GetMapping("/getallorder/{token}")
	public ResponseEntity<ResponseDTO> getAllOrders(@PathVariable String token)
	{
		ResponseDTO respDTO = bookOrderService.getAllOrders(token);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@GetMapping("/getorder/{token}/{orderid}")
	public ResponseEntity<ResponseDTO> getOrder(@PathVariable String token,@PathVariable int orderid)
	{
		ResponseDTO respDTO = bookOrderService.getOrder(token,orderid);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@DeleteMapping("/cancelorder/{token}/{orderid}")
	public ResponseEntity<ResponseDTO> cancelorder(@PathVariable String token,@PathVariable int orderid)
	{
		ResponseDTO respDTO = bookOrderService.cancelOrder(token,orderid);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

		
}
