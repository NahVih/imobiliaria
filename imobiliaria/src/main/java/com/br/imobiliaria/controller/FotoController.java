package com.br.imobiliaria.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.br.imobiliaria.model.Foto;
import com.br.imobiliaria.model.Imovel;
import com.br.imobiliaria.model.Usuario;
import com.br.imobiliaria.repository.FotoRepository;
import com.br.imobiliaria.repository.ImovelRepository;
import com.br.imobiliaria.util.UploadFotoUtil;

@RestController
@RequestMapping("/foto")
public class FotoController {

	@Autowired
	private ImovelRepository imovelRepository;

	@Autowired
	private FotoRepository fotoRepository;

	UploadFotoUtil uploadFotoUtil = new UploadFotoUtil();

	@SuppressWarnings({ "unchecked", "static-access" })
	@PostMapping("/criarFotoByIdImovel/{id}")
	public ResponseEntity<?> criarFoto(@RequestParam(required = false) MultipartFile file,
			@RequestParam(required = false) MultipartFile fileSecundary, @PathVariable(name = "id") Integer id)
			throws IOException {

		Optional<Imovel> imovelDb = imovelRepository.findById(id);
		Imovel imovel = new Imovel();
		imovel.setId(imovelDb.get().getId());
		Foto foto = null;
		if (file != null) {
			foto = new Foto(file.getOriginalFilename(), file.getContentType(),
					uploadFotoUtil.compressBytes(file.getBytes()));
			foto.setImovel(imovel);
			foto = fotoRepository.save(foto);

		}

		if (fileSecundary != null) {
			foto = new Foto(fileSecundary.getOriginalFilename(), fileSecundary.getContentType(),
					uploadFotoUtil.compressBytes(fileSecundary.getBytes()));
			foto.setImovel(imovel);
			foto = fotoRepository.save(foto);

		}
		return new ResponseEntity<>("Fotos salvas com sucesso", HttpStatus.OK);
	}

	@CrossOrigin(allowCredentials = "")
	@SuppressWarnings("static-access")
	@GetMapping("/buscarFotoById/{id}")
	public ResponseEntity<?> buscarFotoById(@PathVariable(name = "id") Integer id) {
		Optional<Foto> findByIdDb = fotoRepository.findById(id);
		Foto foto = new Foto();
		foto = (!findByIdDb.isEmpty()) ? findByIdDb.get() : null;
		if (foto != null) {
			foto.setPicByte(uploadFotoUtil.decompressBytes(foto.getPicByte()));
		} else {
			return new ResponseEntity<>("Foto com id -->" + id + " não localizada", HttpStatus.BAD_REQUEST);
		}
		foto.setImovel(new Imovel());
		return new ResponseEntity<>(foto, HttpStatus.OK);
	}

 

	@CrossOrigin(allowCredentials = "")
	@GetMapping("/buscarFotoPorIdImovel/{id}")
	public List<Foto> fotoByIdImovel(@PathVariable(name = "id") Integer id) {
		List<Foto> foto = fotoRepository.buscarPorId(id);
		for (Foto fotoDb : foto) {
			fotoDb.setImovel(new Imovel());
			fotoDb.setPicByte(uploadFotoUtil.decompressBytes(fotoDb.getPicByte()));
		}
		return foto;
	}

}
