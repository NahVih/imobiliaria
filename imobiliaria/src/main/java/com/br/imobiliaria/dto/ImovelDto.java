package com.br.imobiliaria.dto;

import java.time.LocalDateTime;

public class ImovelDto {

	private Integer id;
	private String descricao;
	private Double valorImovel;
	private LocalDateTime dataCriacao;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValorImovel() {
		return valorImovel;
	}
	public void setValorImovel(Double valorImovel) {
		this.valorImovel = valorImovel;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	@Override
	public String toString() {
		return "ImovelDto [id=" + id + ", descricao=" + descricao + ", valorImovel=" + valorImovel + ", dataCriacao="
				+ dataCriacao + ", getId()=" + getId() + ", getDescricao()=" + getDescricao() + ", getValorImovel()="
				+ getValorImovel() + ", getDataCriacao()=" + getDataCriacao() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}
