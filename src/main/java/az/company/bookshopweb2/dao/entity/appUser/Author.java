package az.company.bookshopweb2.dao.entity.appUser;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private Integer bornTime;

    private String bornArea;

    public Author(String name, String surname, Integer bornTime, String bornArea) {
        this.firstName = name;
        this.lastName = surname;
        this.bornTime = bornTime;
        this.bornArea = bornArea;
    }
}
