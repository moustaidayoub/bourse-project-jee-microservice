package com.moustaid.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.moustaid.dao.OrdreRepository;
import com.moustaid.dao.SocieteRepository;
import com.moustaid.entities.Societe;

import java.io.Serializable;
import java.util.List;

@Service
public class SocieteMetierImp implements SocieteMetier {
@Autowired
private SocieteRepository societeRepository;


@Override
public Societe findByCode(String code) {
	return societeRepository.findByCodeSociete(code);
}

@Override
public Societe addSociete(Societe societe) {
	return societeRepository.save(societe);
}
@Override
public Societe findSociete(Long numeroSociete) {
	return societeRepository.findOne(numeroSociete);
}

@Override
public Page<Societe> findAll(int page, int size) {
	// TODO Auto-generated method stub
	return societeRepository.findAll(new PageRequest(page, size));
}
	@Override
	public List<Societe> findAll() {
		return societeRepository.findAll();
	}
	@Override
	public void deleteAll() {
		societeRepository.deleteAll();
	}



}
