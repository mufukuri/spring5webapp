package za.co.douglas.chifetete.spring5webapp.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books  = new HashSet<>();

    public Author(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author(final String firstName, final String lastName, final Set<Book> books) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = books;
    }

}

