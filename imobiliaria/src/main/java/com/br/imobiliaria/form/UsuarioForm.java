package com.br.imobiliaria.form;

import com.sun.istack.NotNull;

public class UsuarioForm {
	
	@NotNull
	private String nome;
	
	@NotNull
	private String senha;
	
	@NotNull
	private String email;
	
	@NotNull
	private String telefone;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	@Override
	public String toString() {
		return "UsuarioForm [nome=" + nome + ", senha=" + senha + ", email=" + email + ", telefone=" + telefone
				+ ", getNome()=" + getNome() + ", getSenha()=" + getSenha() + ", getEmail()=" + getEmail()
				+ ", getTelefone()=" + getTelefone() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	

}
