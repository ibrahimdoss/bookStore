package com.bookProject.bookStore.controller;

import com.bookProject.bookStore.dto.BookOrderRequest;
import com.bookProject.bookStore.model.Order;
import com.bookProject.bookStore.service.BookService;
import com.bookProject.bookStore.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/bookstore")
public class BookStoreController {

    private OrderService orderService;
    private BookService bookService;

    public BookStoreController(OrderService orderService, BookService bookService) {
        this.orderService = orderService;
        this.bookService = bookService;
    }

    public BookStoreController() {
    }


    @PostMapping
    public ResponseEntity<Order> putAnOrder(@RequestBody BookOrderRequest bookOrderRequest){
        Order order = orderService.putAnOrder(bookOrderRequest.getBookIdList(), bookOrderRequest.getUserName());
        return ResponseEntity.ok(order);
    }
}
