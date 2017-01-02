package com.moustaid.metier;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.moustaid.entities.Ordre;
import com.moustaid.entities.Societe;

import java.util.List;

public interface SocieteMetier  {
	Societe addSociete(Societe societe);
	Societe findSociete(Long numeroSociete);
	Societe findByCode(String codeSociete);
	public Page<Societe> findAll(int page,int size);
	public List<Societe> findAll();
	public void deleteAll();
}
