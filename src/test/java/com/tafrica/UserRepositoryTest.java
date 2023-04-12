package com.tafrica;

import com.tafrica.user.User;
import com.tafrica.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {
    @Autowired
    private UserRepository repository;

    @Test
    public void testAddNew() {
        User user = new User();
        user.setEmail("chrissy@gmail.com");
        user.setPassword("140989chrissy");
        user.setFirstName("Christel");
        user.setLastName("Tokwe");

        User savedUser = repository.save(user);

        //assertions
        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll() {
        Iterable<User> users = repository.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);

        for (User user : users) {
            System.out.println(user);
        }
    }

    //Test for updating the user
    @Test
    public void testUpdate() {
        Integer userId = 1;
        Optional<User> userOptional = repository.findById(userId);
        User user = userOptional.get();
        user.setPassword("hello2000");
        repository.save(user);

        User updatedUser = repository.findById(userId).get();
        Assertions.assertThat(updatedUser.getPassword()).isEqualTo("hello2000");

    }

    //
    @Test
    public void testGet(){
        Integer userId = 4;
        Optional<User> optionalUser = repository.findById(userId);
        Assertions.assertThat(optionalUser).isPresent();
        System.out.println(optionalUser.get());
    }

    @Test
    public void testToDelete(){
        Integer userId = 4;
        repository.deleteById(userId);

        Optional<User> optionalUser = repository.findById(userId);
        Assertions.assertThat(optionalUser).isNotPresent();
    }
}
