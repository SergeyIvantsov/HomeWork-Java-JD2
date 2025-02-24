package org.example.service;

import org.example.entity.Reader;
import org.example.repository.ReaderRepository;
import org.example.repository.impl.LibraryCustomRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ReaderServiceImpl {

    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private LibraryCustomRepositoryImpl libraryCustomRepository;

    public Reader save(Reader reader) {
        return readerRepository.save(reader);
    }

    public Reader find(String email) {
        Optional<Reader> byEmail = readerRepository.findByEmail(email);
        if (byEmail.isPresent()) {
            return byEmail.get();
        } else {
            return null;//toDo нельзя возвращать null. Вернуть пользователю уведомление, что не найден читатель
        }
    }

    public List<Reader> findAllAndPagingAndSorting() {
        Pageable page = new PageRequest(0, 10, Sort.by(Sort.Direction.ASC, "registrationDate"));
        Iterable<Reader> all = readerRepository.findAll(page);
        List<Reader> readerList = StreamSupport.stream(all.spliterator(), false)
                .collect(Collectors.toList());
        return readerList;
    }

    public Optional<Reader> findById(Long id) {
        return readerRepository.findById(id);
    }

    public Iterable<Reader> findAll() {
        return readerRepository.findAll();
    }


    public List<Reader> findReaders(String authorName) {
        return libraryCustomRepository.findReadersByAuthorName(authorName);
    }

}
