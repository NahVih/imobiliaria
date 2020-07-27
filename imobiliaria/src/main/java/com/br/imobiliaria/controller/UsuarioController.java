package com.br.imobiliaria.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.imobiliaria.dto.UsuarioDto;
import com.br.imobiliaria.form.UsuarioForm;
import com.br.imobiliaria.model.AuthRequest;
import com.br.imobiliaria.model.Usuario;
import com.br.imobiliaria.repository.UsuarioRepository;
import com.br.imobiliaria.util.JwtUtil;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping()
	public ResponseEntity<UsuarioDto> criarUsuario(@RequestBody UsuarioForm usuarioForm) {
		Usuario usuario = new Usuario(usuarioForm);
		usuario = usuarioRepository.save(usuario);
		UsuarioDto usuarioDto = new UsuarioDto(usuario.getNome());
		return new ResponseEntity<UsuarioDto>(usuarioDto, HttpStatus.OK);
	}

	 
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscaUsuario(@PathVariable("id") Integer id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if (usuario.isPresent()) {
			Usuario userDb = usuario.get();
			return new ResponseEntity(userDb, HttpStatus.OK);
		}
		return new ResponseEntity("Proprietario com id: " + id + "não localizado", HttpStatus.BAD_REQUEST);
	}

	@CrossOrigin("*")
	@PostMapping("/authenticate")
	public String genereteToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} catch (Exception e) {
			throw new Exception("invalid username/password ---> " + e);
		}
		return jwtUtil.generateToken(authRequest.getUsername());
	}
	
	
	
	


}
