package net.codejava.CodeJavaApp;

import org.assertj.core.api.AbstractBigDecimalAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("ravi@email.com");
        user.setPassword("teribil");
        user.setFirstName("Ravi");
        user.setLastName("Kumar");

        User savedUser = repo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        asserThat(existUser.getEmail()).isEqualTo(user.getEmail());
    }

    private <SELF extends AbstractBigDecimalAssert<SELF>> AbstractBigDecimalAssert<SELF> asserThat(String email) {
        return null;
    }
}
