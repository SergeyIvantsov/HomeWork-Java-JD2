package org.example.test2;


import org.example.entity.Author;
import org.example.service.AuthorServiceImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

@Ignore
@ContextConfiguration("classpath:SpringConfig.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AuthorTest {

    @Autowired
    private AuthorServiceImpl authorServiceImpl;

    @Test
    public void createAuthor() {
        Author author = new Author();
        author.setName("Джек2");
        author.setBirthDate(LocalDate.of(1960, 10, 10));
        author.setNationality("американец");
        authorServiceImpl.save(author);

    }

    @Test
    public void findAuthorByNationality() {
        List<Author> nation = authorServiceImpl.findNationality("американец");

    }


}
