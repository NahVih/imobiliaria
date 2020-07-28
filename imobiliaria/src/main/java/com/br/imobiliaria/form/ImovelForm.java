package com.br.imobiliaria.form;

import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import com.br.imobiliaria.model.CategoriaImovel;
import com.br.imobiliaria.model.Foto;
import com.br.imobiliaria.model.TipoProposta;
import com.sun.istack.NotNull;

public class ImovelForm {

	
	
	@Enumerated(EnumType.STRING)
	private CategoriaImovel categoriaImovel = CategoriaImovel.CASA;
	@Enumerated(EnumType.STRING)
	private TipoProposta tipoProposta = TipoProposta.VENDA;
	@NotNull
	private Double valorImovel;
	@NotNull
	private String endereco;
	@NotNull
	private String bairro;
	@NotNull
	private String condominio;
	@NotNull
	private String descricao;
	@OneToMany(mappedBy = "imovel")
	private List<Foto> fotos;
	
	
	
	
	
	
	public CategoriaImovel getCategoriaImovel() {
		return categoriaImovel;
	}
	public void setCategoriaImovel(CategoriaImovel categoriaImovel) {
		this.categoriaImovel = categoriaImovel;
	}
	public TipoProposta getTipoProposta() {
		return tipoProposta;
	}
	public void setTipoProposta(TipoProposta tipoProposta) {
		this.tipoProposta = tipoProposta;
	}
	public Double getValorImovel() {
		return valorImovel;
	}
	public void setValorImovel(Double valorImovel) {
		this.valorImovel = valorImovel;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCondominio() {
		return condominio;
	}
	public void setCondominio(String condominio) {
		this.condominio = condominio;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Foto> getFotos() {
		return fotos;
	}
	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}
	@Override
	public String toString() {
		return "ImovelForm [categoriaImovel=" + categoriaImovel + ", tipoProposta=" + tipoProposta + ", valorImovel="
				+ valorImovel + ", endereco=" + endereco + ", bairro=" + bairro + ", condominio=" + condominio
				+ ", descricao=" + descricao + ", fotos=" + fotos + ", getCategoriaImovel()=" + getCategoriaImovel()
				+ ", getTipoProposta()=" + getTipoProposta() + ", getValorImovel()=" + getValorImovel()
				+ ", getEndereco()=" + getEndereco() + ", getBairro()=" + getBairro() + ", getCondominio()="
				+ getCondominio() + ", getDescricao()=" + getDescricao() + ", getFotos()=" + getFotos()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	
	
}
