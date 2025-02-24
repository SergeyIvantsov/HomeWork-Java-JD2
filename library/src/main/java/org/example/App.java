package org.example;

import org.example.entity.Author;
import org.example.entity.Book;
import org.example.service.AuthorServiceImpl;
import org.example.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

//@ContextConfiguration("classpath:SpringConfig.xml")
@Component("App")
public class App {

    @Autowired
    private AuthorServiceImpl authorServiceImpl;

    @Autowired
    private BookServiceImpl bookServiceImpl;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
        App app = context.getBean("App", App.class);

        Author author = new Author();
        author.setName("Стивен");
        author.setBirthDate(LocalDate.of(1960, 10, 10));
        author.setNationality("американец");
        app.authorServiceImpl.save(author);
        System.out.println("1-е:" + author);
        List<Author> nation = app.authorServiceImpl.findNationality("американец");
        System.out.println("1-е:" + nation);


        Book book = new Book();
        book.setTitle("Книга");
        book.setIsbn("OP567");
        book.setAuthor(author);
        book.setPublishedDate(LocalDate.of(1990, 02, 04));
        app.bookServiceImpl.save(book);

        Iterable<Book> booksOfTitles = app.bookServiceImpl.findByTitleContaining("Книга");
        //booksOfTitles.forEach(System.out::println);

        Book book2 = new Book();
        book2.setTitle("Книга2");
        book2.setIsbn("OP567");
        book2.setAuthor(author);
        book2.setPublishedDate(LocalDate.of(1990, 2, 4));
        app.bookServiceImpl.save(book2);


    }
}
