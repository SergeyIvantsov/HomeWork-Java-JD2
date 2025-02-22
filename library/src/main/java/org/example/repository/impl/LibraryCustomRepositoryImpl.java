package org.example.repository.impl;

import org.example.entity.Reader;
import org.example.repository.LibraryCustomRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class LibraryCustomRepositoryImpl implements LibraryCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Reader> findReadersByAuthorName(String authorName) {
        String query = "SELECT DISTINCT r FROM Reader r JOIN r.booksForReaders b WHERE b.author.name = :authorName";
        return entityManager.createQuery(query, Reader.class)
                .setParameter("authorName", authorName).getResultList();
    }
}
