package com.br.imobiliaria.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
 

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Value;

import com.br.imobiliaria.form.ImovelForm;
import com.br.imobiliaria.repository.UsuarioRepository;
 
import com.sun.istack.NotNull;

@Entity
public class Imovel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@ManyToOne
	private Usuario usuario;
	
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
	
	@OneToMany(targetEntity = Foto.class,mappedBy="imovel" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Foto> fotos;
	
	//@OneToMany(cascade = CascadeType.ALL, mappedBy = "imovel")
	private LocalDateTime dataCriacao = LocalDateTime.now();
	
	
	
	
	
	
	
	
	
	public Imovel() {
		super();
	}
	
	
	
	
	
	public Imovel(String categoriaImovel, String tipoProposta, Double valorImovel, String endereco,
			String bairro, String condominio, String descricao) {
		super();
		this.categoriaImovel = this.categoriaImovel.valueOf(categoriaImovel);
		this.tipoProposta = this.tipoProposta.valueOf(tipoProposta);
		this.valorImovel = valorImovel;
		this.endereco = endereco;
		this.bairro = bairro;
		this.condominio = condominio;
		this.descricao = descricao;
		
	}


 





	public Imovel(ImovelForm imovelForm) {
		this.categoriaImovel = imovelForm.getCategoriaImovel();
		this.tipoProposta = imovelForm.getTipoProposta();
		this.valorImovel = imovelForm.getValorImovel();
		this.endereco = imovelForm.getEndereco();
		this.bairro = imovelForm.getBairro();
		this.condominio = imovelForm.getCondominio();
		this.descricao = imovelForm.getDescricao();
		this.usuario = new Usuario();
		this.usuario.setIdUsuario(imovelForm.getIdProprietario());
		}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@OneToMany(mappedBy="imovel")
	public List<Foto> getFotos() {
		return fotos;
	}





	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}





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
	 
	
	
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}




	@Override
	public String toString() {
		return "Imovel [id=" + id + ", usuario=" + usuario + ", categoriaImovel=" + categoriaImovel + ", tipoProposta="
				+ tipoProposta + ", valorImovel=" + valorImovel + ", endereco=" + endereco + ", bairro=" + bairro
				+ ", condominio=" + condominio + ", descricao=" + descricao + ", dataCriacao=" + dataCriacao + "]";
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	
	
	
	
}
