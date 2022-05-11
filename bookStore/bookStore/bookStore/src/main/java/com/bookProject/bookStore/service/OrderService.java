package com.bookProject.bookStore.service;

import com.bookProject.bookStore.model.Book;
import com.bookProject.bookStore.model.Order;
import com.bookProject.bookStore.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderService {

    private final Logger logger = LoggerFactory.getLogger(OrderService.class);
    private final BookService bookService;
    private final OrderRepository orderRepository;

    public OrderService(BookService bookService, OrderRepository orderRepository) {
        this.bookService = bookService;
        this.orderRepository = orderRepository;
    }

    public Order putAnOrder(List<Integer> bookIdList, String userName) {
        List<Optional<Book>> bookList = bookIdList.stream()
                .map(bookService::findBookById).collect(Collectors.toList());

        Double totalPrice = bookList.stream()
                .map(optionalBook -> optionalBook.map(Book::getPrice).orElse(0.0))
                .reduce(0.0, Double::sum);

        Order order = Order.builder()
                .bookIdList(bookIdList)
                .totalPrice(totalPrice)
                .userName(userName)
                .build();
        return orderRepository.save(order);
    }

   /* Bir Stream içerisindeki verilerin teker teker işlenmesidir.
    Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç bir sonraki adıma girdi olarak sunulmaktadır.
    Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
 0 - 1
 1 - 2
 3 - 3
 6 - 4
10 - 5 gibi */
}
