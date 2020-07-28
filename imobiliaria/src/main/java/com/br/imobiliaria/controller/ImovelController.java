package com.br.imobiliaria.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.br.imobiliaria.form.ImovelForm;
import com.br.imobiliaria.model.Foto;
import com.br.imobiliaria.model.Imovel;
import com.br.imobiliaria.model.Usuario;
import com.br.imobiliaria.repository.FotoRepository;
import com.br.imobiliaria.repository.ImovelRepository;
import com.br.imobiliaria.repository.UsuarioRepository;
import com.br.imobiliaria.util.UploadFotoUtil;

@RestController
@RequestMapping("/imovel")
public class ImovelController {

	@Autowired
	private ImovelRepository imovelRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	FotoRepository fotoRepository;
	UploadFotoUtil uploadFotoUtil = new UploadFotoUtil();

	@CrossOrigin(allowedHeaders = "*")
	@PostMapping("/criarImovelComFotos/{categoriaImovel}/{tipoProposta}/{endereco}/{bairro}/{condominio}/{descricao}/{valorImovel}")
	public ResponseEntity<Imovel> criarImovelComFoto(@RequestParam(required = false) MultipartFile file,
			@RequestParam(required = false) MultipartFile fileSecundary,
			@PathVariable(name = "categoriaImovel") String categoriaImovel,
			@PathVariable(name = "tipoProposta") String tipoProposta, @PathVariable(name = "endereco") String endereco,
			@PathVariable(name = "bairro") String bairro, @PathVariable(name = "condominio") String condominio,
			@PathVariable(name = "descricao") String descricao, @PathVariable(name = "valorImovel") Double valorImovel)
			throws IOException {

		Usuario proprietario = usuarioRepository
				.findByNome(SecurityContextHolder.getContext().getAuthentication().getName());
		Imovel imovel = new Imovel(categoriaImovel, tipoProposta, valorImovel, endereco, bairro, condominio, descricao);
		imovel.setUsuario(new Usuario());
		imovel.getUsuario().setIdUsuario(proprietario.getIdUsuario());
		Imovel imovelSaved = imovelRepository.save(imovel);

		List<Foto> fotos = new ArrayList<>();
		Foto foto;
		if (file != null) {
			foto = new Foto(file.getOriginalFilename(), file.getContentType(),
					uploadFotoUtil.compressBytes(file.getBytes()));

			foto.setImovel(new Imovel());
			foto.setImovel(imovelSaved);
			foto = fotoRepository.save(foto);
			Foto fotoDb = new Foto();
			fotoDb.setIdFoto(foto.getIdFoto());
			fotos.add(fotoDb);
		}
		imovelSaved.setFotos(new ArrayList<>(fotos));
		
		return new ResponseEntity<Imovel>(imovelSaved, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<Imovel> criarImovel(@RequestBody ImovelForm imovelForm) {
		Usuario proprietario = usuarioRepository
				.findByNome(SecurityContextHolder.getContext().getAuthentication().getName());

		Imovel imovel = new Imovel(imovelForm);
		imovel.setUsuario(new Usuario());
		// imovel.setUsuario(proprietario);
		imovel.getUsuario().setIdUsuario(proprietario.getIdUsuario());
		imovel = imovelRepository.save(imovel);

		return new ResponseEntity<Imovel>(imovel, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/buscarBy/{id}")
	public ResponseEntity<Imovel> criarImovel(@PathVariable(name = "id") Integer id) {
		Optional<Imovel> imovelDb = imovelRepository.findById(id);
		if (imovelDb.isPresent()) {
			return new ResponseEntity(imovelDb, HttpStatus.OK);
		}
		return new ResponseEntity("Imovel com id: " + id + " não localizado", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/buscarTodos")
	public List<Imovel> listarImoveis() {
		ArrayList<Imovel> listaImovel = new ArrayList<>();
		listaImovel = (ArrayList<Imovel>) imovelRepository.findAll();
		return listaImovel;
	}

}
