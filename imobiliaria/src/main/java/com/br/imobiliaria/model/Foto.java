package com.br.imobiliaria.model;

import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
public class Foto {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idFoto;
	@NotNull
	private String name;

	private String tipo;

	 @Column(name = "picByte", length = 1000)
	 private byte[] picByte;

	 @ManyToOne
	 @JoinColumn(name = "imovel_id")
	 @JsonIgnoreProperties(value = {"fotos", "usuario"})
	 private Imovel imovel;
	
	
	

	
	

	public Foto(Integer idFoto, String name, String tipo, Imovel imovel) {
		super();
		this.idFoto = idFoto;
		this.name = name;
		this.tipo = tipo;
		this.imovel = imovel;
	}

	public Foto(String name, String tipo, byte[] picByte) {
		super();
		this.name = name;
		this.tipo = tipo;
		this.picByte = picByte;
	}

	public Foto() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}





	

	public Integer getIdFoto() {
		return idFoto;
	}

	public void setIdFoto(Integer idFoto) {
		this.idFoto = idFoto;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	@Override
	public String toString() {
		return "Foto [idFoto=" + idFoto + ", name=" + name + ", tipo=" + tipo + ", picByte=" + Arrays.toString(picByte)
				+ ", imovel=" + imovel + ", getName()=" + getName() + ", getTipo()=" + getTipo() + ", getPicByte()="
				+ Arrays.toString(getPicByte()) + ", getIdFoto()=" + getIdFoto() + ", getImovel()=" + getImovel()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
