package com.br.imobiliaria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.br.imobiliaria.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	Usuario findByNome(String username);
	
//	@Query("select * from usuario_roles where usuario_id=?1")
//	Usuario findByIdUsuario(Integer id);
	
	
	Optional<Usuario> findById(Integer id);
	

}
