package org.example;

import org.example.entity.Author;
import org.example.service.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

//@ContextConfiguration("classpath:SpringConfig.xml")
@Component("App")
public class App {

    @Autowired
    private AuthorServiceImpl authorServiceImpl;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
        App app = context.getBean("App", App.class);

        Author author = new Author();
        author.setName("Стивен");
        author.setBirthDate(LocalDate.of(1960, 10, 10));
        author.setNationality("американец");
        app.authorServiceImpl.save(author);
        System.out.println(author);


    }
}
