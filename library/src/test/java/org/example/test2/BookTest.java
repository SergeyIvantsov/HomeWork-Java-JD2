package org.example.test2;


import org.example.entity.Author;
import org.example.entity.Book;
import org.example.service.BookServiceImpl;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;

@Ignore
@ContextConfiguration("classpath:SpringConfig.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BookTest {

    @Autowired
    private BookServiceImpl bookServiceImpl;


    @Test
    public void createBook() {
        Book book = new Book();
        book.setTitle("Книга");
        book.setIsbn("OP567");
        book.setAuthor(new Author());
        book.setPublishedDate(LocalDate.of(1990, 02, 04));
        bookServiceImpl.save(book);
    }

    @Test
    public void findBooksByTitle() {
        Iterable<Book> booksOfTitles = bookServiceImpl.findByTitleContaining("Книга");
        //toDo достать из БД книгу с названием "Книга" и сравнить  в assert
//        Assert.assertEquals(booksOfTitles, book);
    }

    @Test
    public void checkedOnUniqueSbn() {
        Book book2 = new Book();
        book2.setTitle("Книга2");
        book2.setIsbn("OP567");
        book2.setAuthor(new Author());
        book2.setPublishedDate(LocalDate.of(1990, 2, 4));
        Book saveBook = bookServiceImpl.save(book2);
        Assert.assertNull(saveBook.getId());

    }


}
