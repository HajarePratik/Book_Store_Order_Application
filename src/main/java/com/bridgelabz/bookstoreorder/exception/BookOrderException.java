package com.bridgelabz.bookstoreorder.exception;

import org.springframework.http.HttpStatus;

public class BookOrderException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BookOrderException(String message)
	{
		super(message);
	}
	public BookOrderException(int statusCode, String statusmessage)
	{
		super(statusmessage);
	}
	public BookOrderException(String string, HttpStatus ok, Object object, String string2) {
		// TODO Auto-generated constructor stub
	}
	

	

}
