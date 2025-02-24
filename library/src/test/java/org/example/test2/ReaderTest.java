package org.example.test2;


import org.example.entity.Author;
import org.example.entity.Book;
import org.example.entity.Reader;
import org.example.service.ReaderServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@ContextConfiguration("classpath:SpringConfig.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ReaderTest {
    public static final Long ID = 7l;
    Reader reader = new Reader();
    Reader reader2 = new Reader();
    Reader reader3 = new Reader();
    Book book = new Book();
    Author author = new Author();
    public static final String NAME = "А.С. Пушкин";

    @Autowired
    private ReaderServiceImpl readerService;

    @Before
    public void setUp() {
        reader.setName("Иван");
        reader.setEmail("@mold");
        reader.setRegistrationDate(LocalDate.of(2010, 5, 2));

        author.setName("А.С. Пушкин");
        author.setBirthDate(LocalDate.of(1778, 10, 3));
        author.setNationality("русский");

        book.setTitle("Евгений Онегин");
        book.setIsbn("ЕI98T0");
        book.setAuthor(author);
        book.setPublishedDate(LocalDate.of(2000, 6, 7));

        reader2.setName("Сергей");
        reader2.setEmail("@serg");
        reader2.setRegistrationDate(LocalDate.of(2000, 1, 22));

        reader3.setName("Женя");
        reader3.setEmail("@ogj7");
        reader3.setRegistrationDate(LocalDate.of(1995, 5, 14));
    }

    @Test
    public void save2Add() {
        reader2.getBooksForReaders().add(new Book());
        readerService.save(reader2);
    }

    @Test
    public void save3Add() {
        reader3.getBooksForReaders().add(book);
        readerService.save(reader3);
    }

    @Test
    public void save() {
        reader.getBooksForReaders().add(book);
        Reader saveReader = readerService.save(reader);
        Assert.assertNotNull(saveReader.getId());
    }

    @Test
    public void findByEmail() {
        save();
        Reader reader2 = readerService.find("@mold");
        Assert.assertEquals(reader3, reader2);
    }

    @Test
    public void findAndPagingAndSorting() {
        List<Reader> byId = new ArrayList<>();
        Iterable<Reader> all = readerService.findAll();
        List<Reader> collect = StreamSupport.stream(all.spliterator(), false)
                .collect(Collectors.toList());
        byId.addAll(collect);
        Collections.sort(byId);
        List<Reader> list = readerService.findAllAndPagingAndSorting();
        list.forEach(System.out::println);
        Assert.assertEquals(byId, list);
    }

    @Test
    public void findReaders() {
        List<Reader> listRead = new ArrayList<>();
        Reader reader1 = readerService.findById(24l).get();
        Reader reader2 = readerService.findById(25l).get();
        listRead.add(reader1);
        listRead.add(reader2);
        List<Reader> readers = readerService.findReaders(NAME);
        Assert.assertEquals(readers, listRead);
    }


}
