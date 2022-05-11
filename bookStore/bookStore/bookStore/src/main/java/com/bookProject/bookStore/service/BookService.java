package com.bookProject.bookStore.service;

import com.bookProject.bookStore.model.Book;
import com.bookProject.bookStore.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Optional<Book> findBookById(Integer bookId){
        return bookRepository.findById(bookId);
    }
}


/*
Mülakat soruları :

veritabanında product tutuluyor, bir tane stok kaldı iki tane müşteri aynı anda sipariş vermek istedi
nasıl karar verilecek? hangisine bu ürünü nasıl dağıtacaksın?
bunu çözmenin yolu  @Transactional bunu eklediğimizde uygulama ayağa kalkarken
        bu bookservice ait bütün methodları transactional yapıyor
ilk gelen request işleniyor diğerleri bekliyor bu şekilde threadsafe sağlanmış oluyor.
Senkron çalışır yani transactional.*/
