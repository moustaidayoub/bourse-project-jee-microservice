package com.moustaid.services.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.moustaid.entities.Societe;
import com.moustaid.metier.SocieteMetier;
import org.springframework.stereotype.Service;

@Component
@WebService(serviceName = "societes")
public class SocieteSoapService {
	@Autowired
	private SocieteMetier societeMetier;

	@WebMethod(operationName="addSociete")
	public Societe addSociete(@WebParam(name="societe")Societe societe) {
		return societeMetier.addSociete(societe);
	}
	@WebMethod(operationName="findSociete")
	public Societe findSociete(@WebParam(name="numeroSociete")Long numeroSociete) {
		return societeMetier.findSociete(numeroSociete);
	}
	@WebMethod(operationName="findByCode")
	public Societe findByCode(@WebParam(name="codeSociete")String codeSociete) {
		return societeMetier.findByCode(codeSociete);
	}

}
