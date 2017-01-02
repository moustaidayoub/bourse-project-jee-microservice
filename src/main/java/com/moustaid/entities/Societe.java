package com.moustaid.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Societe implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	   private Long numeroSociete;
	 private String codeSociete;
	   private String nomSociete;
		@OneToMany(mappedBy="societe",cascade=CascadeType.ALL)
	   private List<Ordre> orders;

	public Societe(String codeSociete, String nomSociete) {
		super();
		this.codeSociete = codeSociete;
		this.nomSociete = nomSociete;
	}

	public Societe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getNumeroSociete() {
		return numeroSociete;
	}

	public void setNumeroSociete(Long numeroSociete) {
		this.numeroSociete = numeroSociete;
	}

	public String getCodeSociete() {
		return codeSociete;
	}

	public void setCodeSociete(String codeSociete) {
		this.codeSociete = codeSociete;
	}

	public String getNomSociete() {
		return nomSociete;
	}

	public void setNomSociete(String nomSociete) {
		this.nomSociete = nomSociete;
	}
	@JsonIgnore
	public List<Ordre> getOrders() {
		if(orders==null)
			return new ArrayList();
		return orders;
	}
	@JsonSetter
	public void setOrders(List<Ordre> orders) {
		this.orders = orders;
	}
	   
}
