package com.br.imobiliaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.br.imobiliaria.model.Foto;
 

public interface FotoRepository extends JpaRepository<Foto, Integer>{
	
	
	@Query(value = "SELECT * FROM foto f inner join imovel on f.imovel_id=imovel.id WHERE f.imovel_id = ?1", 
			  nativeQuery = true)
	List<Foto> buscarPorId(Integer id);
		
	
	@Query(value = "SELECT * FROM foto WHERE foto.imovel_id = ?1",
			nativeQuery = true)
	List<Foto> buscarPorIdDoImovel(Integer id);
		
}
