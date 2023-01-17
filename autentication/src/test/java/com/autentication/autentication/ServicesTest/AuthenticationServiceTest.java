package com.autentication.autentication.ServicesTest;


import com.autentication.autentication.config.JwtService;
import com.autentication.autentication.model.Role;
import com.autentication.autentication.model.User;
import com.autentication.autentication.model.auth.AuthenticantionResponse;
import com.autentication.autentication.model.auth.AuthenticationRequest;
import com.autentication.autentication.model.auth.RegisterRequest;
import com.autentication.autentication.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
public class AuthenticationServiceTest {

    private MockMvc mockMvc;

    RegisterRequest request = new RegisterRequest();

    private AuthenticationRequest authenticationRequest = new AuthenticationRequest();

    private AuthenticantionResponse authenticantionResponse = new AuthenticantionResponse();

    @Autowired
    AuthenticationManager authenticationManager;

    private JwtService jwtService;
    @Autowired
    private UserRepository userRepository;



    @Test
    public void registerTest() {

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        var user = User.builder()
                .firstname("teste")
                .lastname("teste")
                .email("teste@teste.com")
                .password(encoder.encode("teste"))
                .role(Role.ADMIN)
                .build();

        userRepository.save(user);
        Assertions.assertEquals("teste", user.getFirstname());
        Assertions.assertEquals("teste", user.getLastname());
        Assertions.assertEquals("teste@teste.com", user.getEmail());
    }

    @Test
    public void registerNotNullPasswordTest() {

        String message = null;

        var user = User.builder()
                .firstname("teste")
                .lastname("nullpointer")
                .email("teste@testenullpointerexception.com")
                .password(" ")
                .role(Role.ADMIN)
                .build();

        if (user.getPassword() == null || user.getPassword().startsWith(" ")) {
            message = "Password não pode ser null" +
                    "\n" + "Password não pode conter espaços em branco";
        }
        else {
            userRepository.save(user);
        }
        
        Assertions.assertEquals("Password não pode ser null"  +
                "\n" + "Password não pode conter espaços em branco", message);
    }

    @Test
    public void authenticateTest() {

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String message = null;

        var user = User.builder()
                .firstname("teste")
                .lastname("teste")
                .email("teste-14@teste.com")
                .password(encoder.encode("teste"))
                .role(Role.ADMIN)
                .build();
        userRepository.save(user);

        authenticationRequest.setEmail(user.getEmail());
        authenticationRequest.setPassword(user.getPassword());

        System.out.println(authenticationRequest.getEmail());
        System.out.println(authenticationRequest.getPassword());


        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getEmail(),
                            authenticationRequest.getPassword()
                    )
            );

            var user_autheticate = userRepository.findByEmail(authenticationRequest.getEmail())
                    .orElseThrow();

            var jwtToken = jwtService.generateToken(user_autheticate);

            AuthenticantionResponse.builder()
                    .token(jwtToken)
                    .build();

            message = "User autenticado";
        }catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        Assertions.assertEquals("User autenticado", message);
    }

}
