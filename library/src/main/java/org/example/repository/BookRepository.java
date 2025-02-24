package org.example.repository;

import org.example.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    Iterable<Book> findByTitleContaining(String title);

    List<Book> findByIsbnContaining(String isbn);


}
