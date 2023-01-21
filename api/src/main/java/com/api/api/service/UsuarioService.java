package com.api.api.service;

import com.api.api.model.Role;
import com.api.api.model.Usuario;
import com.api.api.repository.RoleRepository;
import com.api.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RoleRepository roleRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository,
                          RoleRepository roleRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Usuario findByUsername(String username) {
        return usuarioRepository.findUsuarioByUsername(username);
    }

    public Usuario saveUsuario(Usuario usuario){
        usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
        usuario.setUsername(usuario.getUsername());
        Role role = roleRepository.findByRole("ADMIN");
        usuario.setRole(new HashSet<Role>(Arrays.asList(role)));
        return usuarioRepository.save(usuario);
    }
}
