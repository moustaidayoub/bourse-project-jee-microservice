package com.moustaid.services.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.moustaid.entities.Ordre;
import com.moustaid.metier.OrdreMetier;
import org.springframework.stereotype.Service;

@Component
@WebService(serviceName = "ordres")
public class OrdreSoapService {
	@Autowired
	private OrdreMetier ordreMetier;

	@WebMethod(operationName="addOrdre")
	public Ordre addOrdre(@WebParam(name="ordre")Ordre ordre) {
		return ordreMetier.addOrdre(ordre);
	}

	@WebMethod(operationName="totalActionsVente")
	public int totalActionsVente(@WebParam(name="numeroSociete")Long numeroSociete) {
		return ordreMetier.totalActionsVente(numeroSociete);
	}
	@WebMethod(operationName="totalActionsAchat")
	public int totalActionsAchat(@WebParam(name="numeroSociete")Long numeroSociete) {
		return ordreMetier.totalActionsAchat(numeroSociete);
	}
	@WebMethod(operationName="moyenPrixVente")
	public double moyenPrixVente(@WebParam(name="numeroSociete")Long numeroSociete) {
		return ordreMetier.moyenPrixVente(numeroSociete);
	}
	@WebMethod(operationName="moyenPrixAchat")
	public double moyenPrixAchat(@WebParam(name="numeroSociete")Long numeroSociete) {
		return ordreMetier.moyenPrixAchat(numeroSociete);
	}

}
