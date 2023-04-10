package com.tafrica;

import com.tafrica.user.User;
import com.tafrica.user.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {
    @Autowired private UserRepository repository;

    @Test
    public void testAddNew(){
        User user = new User();
        user.setEmail("tokwepedzi@gmail.com");
        user.setPassword("140989pedzi");
        user.setFirstName("Pedzisai");
        user.setLastName("Tokwe");

        User savedUser = repository.save(user);

        //assertions
        //Assertions.assertThat(savedUser).isNotNull();
    }
}
