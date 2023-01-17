package com.autentication.autentication;

import com.autentication.autentication.model.Role;
import com.autentication.autentication.model.User;
import com.autentication.autentication.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
public class UserRolesTest {

    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void UserRolesTest() {

        var user1 = User.builder().email("teste_1@t1.com").password("teste").role(Role.USER).build();
        var user2 = User.builder().email("teste_2@t2.com").password("teste").role(Role.ADMIN).build();
        var user3 = User.builder().email("teste_3@t3.com").password("teste").role(Role.USER).build();

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        Optional<User> user_1 = userRepository.findByEmail("teste_1@t1.com");
        Assertions.assertEquals(Role.USER, user_1.get().getRole());

        Optional<User> user_2 = userRepository.findByEmail("teste_2@t2.com");
        Assertions.assertEquals(Role.ADMIN, user_2.get().getRole());

        Optional<User> user_3 = userRepository.findByEmail("teste_3@t3.com");
        Assertions.assertEquals(Role.USER, user_3.get().getRole());

    }

}
