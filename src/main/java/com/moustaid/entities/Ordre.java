package com.moustaid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typeOrdre",discriminatorType=DiscriminatorType.STRING,length=10)
public abstract class Ordre implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long numeroOrdre;
	protected Date dateOrdre;
	   protected int nombreActions;
	   protected double prixAction;
	   @ManyToOne
	   protected Societe societe;
	  @Column(name="typeOrdre", length=10, insertable=false, updatable=false)
	  protected String typeOrdre;
	public Ordre(Date dateOrdre, int nombreActions, double prixAction,Societe societe) {
		super();
		this.dateOrdre = dateOrdre;
		this.nombreActions = nombreActions;
		this.prixAction = prixAction;
		this.societe=societe;
	}
	public Ordre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getNumeroOrdre() {
		return numeroOrdre;
	}
	public void setNumeroOrdre(Long numeroOrdre) {
		this.numeroOrdre = numeroOrdre;
	}
	public Date getDateOrdre() {
		return dateOrdre;
	}
	public void setDateOrdre(Date dateOrdre) {
		this.dateOrdre = dateOrdre;
	}
	public int getNombreActions() {
		return nombreActions;
	}
	public void setNombreActions(int nombreActions) {
		this.nombreActions = nombreActions;
	}
	public double getPrixAction() {
		return prixAction;
	}
	public void setPrixAction(double prixAction) {
		this.prixAction = prixAction;
	}
	public Societe getSociete() {
		return societe;
	}
	public void setSociete(Societe societe) {
		this.societe = societe;
	}

	public String getTypeOrdre() {
		return typeOrdre;
	}
	public void setTypeOrdre(String typeOrdre) {
		this.typeOrdre = typeOrdre;
	}
	
	   

}
