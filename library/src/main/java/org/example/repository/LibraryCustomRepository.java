package org.example.repository;


import org.example.entity.Reader;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryCustomRepository {
    List<Reader> findReadersByAuthorName(String authorName);


}
