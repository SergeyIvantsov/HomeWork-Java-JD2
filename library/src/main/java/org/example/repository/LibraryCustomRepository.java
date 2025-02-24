package org.example.repository;


import org.example.entity.Reader;

import java.util.List;


public interface LibraryCustomRepository {
    List<Reader> findReadersByAuthorName(String authorName);


}
