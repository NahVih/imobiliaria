package com.br.imobiliaria.dto;

import java.util.List;

import com.br.imobiliaria.model.Foto;

public class FotoDto {

	
	private Integer idImovel;
	private String descricaoImovel;
	private List<Foto> fotos;
	
	
	
	
	public FotoDto(Integer idImovel, String descricaoImovel, List<Foto> fotos) {
		super();
		this.idImovel = idImovel;
		this.descricaoImovel = descricaoImovel;
		this.fotos = fotos;
	}
	public Integer getIdImovel() {
		return idImovel;
	}
	public void setIdImovel(Integer idImovel) {
		this.idImovel = idImovel;
	}
	public String getDescricaoImovel() {
		return descricaoImovel;
	}
	public void setDescricaoImovel(String descricaoImovel) {
		this.descricaoImovel = descricaoImovel;
	}
	public List<Foto> getFotos() {
		return fotos;
	}
	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}
	@Override
	public String toString() {
		return "FotoDto [idImovel=" + idImovel + ", descricaoImovel=" + descricaoImovel + ", fotos=" + fotos
				+ ", getIdImovel()=" + getIdImovel() + ", getDescricaoImovel()=" + getDescricaoImovel()
				+ ", getFotos()=" + getFotos() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}
