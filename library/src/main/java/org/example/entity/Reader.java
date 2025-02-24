package org.example.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(exclude = "booksForReaders")
@ToString(exclude = "booksForReaders")
@Table(name = "readers")
public class Reader implements Comparable<Reader> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private LocalDate registrationDate;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "reader_book",
            joinColumns = {@JoinColumn(name = "reader_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")})
    private Set<Book> booksForReaders = new HashSet<>();

    @Override
    public int compareTo(Reader r) {
        return registrationDate.compareTo(r.registrationDate);
    }
}
