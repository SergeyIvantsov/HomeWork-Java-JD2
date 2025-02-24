package org.example.service;

import org.example.entity.Book;
import org.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl {

    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public Book save(Book book) {
        String isbn = book.getIsbn();
        List<Book> byIsbnContaining = bookRepository.findByIsbnContaining(isbn);
        if (byIsbnContaining.isEmpty()) {
            return bookRepository.save(book);
        } else {
//            System.out.println("Такая {?} книга уже есть ", book.toString());//toDo это правильный подход, написать реализацию
            System.out.println("Такая книга уже есть " + book);//toDo дать уведомление пользователю
            return book;
        }

    }

    @Transactional
    public Iterable<Book> findByTitleContaining(String title) {
        return bookRepository.findByTitleContaining(title);
    }


}
