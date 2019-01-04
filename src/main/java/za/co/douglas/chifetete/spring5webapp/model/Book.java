package za.co.douglas.chifetete.spring5webapp.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String isbn;
    private String publisher;
    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    public Book(final String title, final String isbn, final String publisher) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
    }

    public Book(final String title, final String isbn, final String publisher, final Set<Author> authors) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.authors = authors;
    }

}





