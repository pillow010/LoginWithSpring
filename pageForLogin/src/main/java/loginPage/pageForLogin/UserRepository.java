package loginPage.pageForLogin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Repository interface for performing CRUD operations on User entities.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Retrieves a user by the given email.
     *
     * @param email the email of the user
     * @return the user with the specified email
     */
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);
}

