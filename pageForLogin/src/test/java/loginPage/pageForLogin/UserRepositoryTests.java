package loginPage.pageForLogin;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

/**
 * Unit test class for UserRepository.
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repo;

    /**
     * Tests the creation of a user.
     */
    @Test
    public void testCreateUser() {
        // Create a new user
        User user = new User();
        user.setEmail("9a06satria@gmail.com");
        user.setPassword("123456");
        user.setFirstName("satria");
        user.setLastName("bagus");

        // Save the user
        User savedUser = repo.save(user);

        // Retrieve the user from the entity manager
        User existUser = entityManager.find(User.class, savedUser.getId());

        // Assert that the saved user matches the retrieved user
        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
    }
}

