package loginPage.pageForLogin;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.util.Objects;

/**
 * Represents a user entity in the system.
 */
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "users")
public class User {

    /**
     * The unique identifier of the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The email address of the user.
     * It must be unique and have a maximum length of 45 characters.
     */
    @Column(nullable = false, unique = true, length = 45)
    private String email;

    /**
     * The password of the user.
     * It has a maximum length of 64 characters.
     */
    @Column(nullable = false, length = 64)
    private String password;

    /**
     * The first name of the user.
     * It must have a maximum length of 20 characters.
     */
    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    /**
     * The last name of the user.
     * It must have a maximum length of 20 characters.
     */
    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;

    /**
     * Compares this user with another object for equality.
     *
     * @param o the object to compare
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return getId() != null && Objects.equals(getId(), user.getId());
    }

    /**
     * Generates the hash code value for this user.
     *
     * @return the hash code value
     */
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

