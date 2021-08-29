package com.bridgelabz.bookstoreorder.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.bookstoreorder.model.BookOrderModel;

@Repository
public interface BookOrderRepository extends JpaRepository<BookOrderModel, Integer> {
	
}
