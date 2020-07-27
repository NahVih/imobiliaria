package com.br.imobiliaria.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.br.imobiliaria.controller.UsuarioController;
import com.br.imobiliaria.model.Usuario;
import com.br.imobiliaria.repository.UsuarioRepository;
 

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario user = usuarioRepository.findByNome(username);  
		
		
		return new
				org.springframework.security.core.userdetails.User
				//	(user.getUsername(), user.getPassword(), new ArrayList<>());
				(user.getNome(), user.getSenha(), getAuthority(user));
		
		
	}

	private Set getAuthority(Usuario user) {
        Set authorities = new HashSet<>();
        if(user.getRole() != null) {
		 
            authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
		 
        }
		return authorities;
	}
	
}

