package com.bridgelabz.bookstoreorder.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bridgelabz.bookstoreorder.dto.BookOrderDTO;
import com.bridgelabz.bookstoreorder.dto.ResponseDTO;
import com.bridgelabz.bookstoreorder.exception.BookOrderException;
import com.bridgelabz.bookstoreorder.model.BookOrderModel;
import com.bridgelabz.bookstoreorder.repository.BookOrderRepository;

@Service
public class BookOrderService implements IBookOrderService
{
	@Autowired
	BookOrderRepository orderRepository;
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public ResponseDTO placeOrder(String token, BookOrderDTO orderDTO, int bookid)
	{
		
		boolean verify = restTemplate.getForObject("http://userbook-store/verifyemail/" + token,Boolean.class);
		if (verify) 
		{
			boolean verifybook = restTemplate.getForObject("http://book-store/verifybook/" + token+"/" +bookid,Boolean.class);
			if(verifybook)
			{
				BookOrderModel orderDetails = modelMapper.map(orderDTO, BookOrderModel.class);
				orderDetails.setBookId(bookid);
				orderDetails.setOrderDate(LocalDate.now());
				orderRepository.save(orderDetails);
				return new ResponseDTO("Order Place Successfully", orderDetails);
			}
			else
			{
				throw new BookOrderException(400, "Book Id is Not Present");
			}
		}
		else 
		{
			throw new BookOrderException(400, "User not Login, Please Check");
		}
	}
	@Override
	public ResponseDTO getAllOrders(String token)
	{
		
		boolean verify = restTemplate.getForObject("http://userbook-store/verifyemail/" + token,Boolean.class);
		if (verify) 
		{
			List<BookOrderModel> orderList = orderRepository.findAll();
			return new ResponseDTO("List of All Orders ",orderList);
		}
		else
		{
			throw new BookOrderException(400, "User not Login, Please Check");
		}
	}
	@Override
	public ResponseDTO getOrder(String token, int orderid) 
	{
		
		boolean verify = restTemplate.getForObject("http://userbook-store/verifyemail/" + token,Boolean.class);
		if (verify) 
		{
			Optional<BookOrderModel> orderList = orderRepository.findById(orderid);
			return new ResponseDTO("User Id of this Order : "+orderid, orderList);
		}
		else
		{
			throw new BookOrderException(400, "User not Login, Please Check");
		}
	}
	@Override
	public ResponseDTO cancelOrder(String token, int orderid) 
	{
		
		boolean verify = restTemplate.getForObject("http://userbook-store/verifyemail/" + token,Boolean.class);
		if (verify) 
		{
			orderRepository.deleteById(orderid);
			return new ResponseDTO("Order is Cancelled","Order id is:" +orderid);
		}
		else
		{
			throw new BookOrderException(400, "User not Login, Please Check");
		}
	}
	
	
	
}
