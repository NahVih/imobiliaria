package com.br.imobiliaria.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CollectionType;
import org.springframework.beans.factory.annotation.Value;

import com.br.imobiliaria.form.UsuarioForm;
import com.fasterxml.jackson.core.sym.Name;
import com.sun.istack.NotNull;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idUsuario;
	@NotNull
	private String nome;
	
	@NotNull
	private String senha;
	 
	private String role = "user";
	
	@NotNull
	private String email;
	
	@NotNull
	private String telefone;
	
	
	private LocalDateTime dataCriacao = LocalDateTime.now();
	
	@OneToMany(targetEntity = Imovel.class,mappedBy="usuario" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Imovel> imoveis;
	//@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	
	
	
	
	
	
	public Usuario() {
		super();
	}

	
	
	public Usuario(UsuarioForm usuarioForm) {
		super();
		this.nome = usuarioForm.getNome();
		this.senha = usuarioForm.getSenha();
		this.email = usuarioForm.getEmail();
		this.telefone = usuarioForm.getTelefone();
	}



	public Usuario(Integer idUsuario, String nome, String senha, String role, String email, String telefone) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.senha = senha;
		this.role = role;
		this.email = email;
		this.telefone = telefone;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String roles) {
		this.role = roles;
	}
	
	public Integer getIdUsuario() {
		return idUsuario;
	}



	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}



	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
 
	

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nome=" + nome + ", senha=" + senha + ", role=" + role + ", email="
				+ email + ", telefone=" + telefone + ", dataCriacao=" + dataCriacao + ", getSenha()=" + getSenha()
				+ ", getRole()=" + getRole() + ", getIdUsuario()=" + getIdUsuario() + ", getNome()=" + getNome()
				+ ", getEmail()=" + getEmail() + ", getTelefone()=" + getTelefone() + ", getDataCriacao()="
				+ getDataCriacao() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	 
	
	
}
