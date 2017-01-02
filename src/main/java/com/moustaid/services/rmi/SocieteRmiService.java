package com.moustaid.services.rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.moustaid.entities.Societe;
import com.moustaid.metier.SocieteMetier;

@Component
public class SocieteRmiService implements ISocieteRemote {

	private static final long serialVersionUID = 1L;
	@Autowired
private SocieteMetier societeMetier;

	public SocieteRmiService(){
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public Societe addSociete(Societe societe) {
		// TODO Auto-generated method stub
		return societeMetier.addSociete(societe);
	}

	@Override
	public Societe findSociete(Long numeroSociete) {
		// TODO Auto-generated method stub
		return societeMetier.findSociete(numeroSociete);
	}

	@Override
	public Societe findByCode(String codeSociete) {
		// TODO Auto-generated method stub
		return societeMetier.findByCode(codeSociete);
	}
	@Override
	public List<Societe> findAll(){
		return societeMetier.findAll();
	}

}
