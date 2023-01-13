package com.autentication.autentication.TestUserController;

import com.autentication.autentication.model.User;
import com.autentication.autentication.repository.UserRepository;
import org.junit.jupiter.api.Test;

public class UserTest {

    private UserRepository userRepository;

    @Test
    public User adicionaUsuarioTeste(User user) {
        return userRepository.save(user);
    }

}
