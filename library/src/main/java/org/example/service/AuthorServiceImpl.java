package org.example.service;

import org.example.entity.Author;
import org.example.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl {

    @Autowired
    private AuthorRepository authorRepository;

    public Author save(Author author) {
        Author saveAuthor = authorRepository.save(author);
        return saveAuthor;
    }

    public List<Author> findNationality(String nationality) {
        return authorRepository.findByNationality(nationality);
    }


}
