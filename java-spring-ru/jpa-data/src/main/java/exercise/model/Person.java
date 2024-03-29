package exercise.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import static jakarta.persistence.GenerationType.IDENTITY;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// BEGIN
@Setter
@Getter
@Entity
@Table(name = "persons")
//@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    //@EqualsAndHashCode.Include
    private Long id;
    private String firstName ;
    private String lastName;
}
// END
