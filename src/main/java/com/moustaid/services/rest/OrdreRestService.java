package com.moustaid.services.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moustaid.entities.Ordre;
import com.moustaid.metier.OrdreMetier;

@RestController
@CrossOrigin("*")
@RequestMapping("/v1/ordres")
public class OrdreRestService {
	@Autowired
	private OrdreMetier ordreMetier;

	@RequestMapping(method=RequestMethod.POST)
	public Ordre addOrdre(Ordre ordre) {
		return ordreMetier.addOrdre(ordre);
	}

	@RequestMapping(value="/societe/{numeroSociete}",method=RequestMethod.GET)
	public Page<Ordre> findBySociete(@PathVariable("numeroSociete")Long numeroSociete,@RequestParam int page,@RequestParam int size) {
		return ordreMetier.findBySociete(numeroSociete, page,size);
	}

	@RequestMapping(value="/total-actions-vente/{numeroSociete}",method=RequestMethod.GET)
	public int totalActionsVente(@PathVariable("numeroSociete")Long numeroSociete) {
		return ordreMetier.totalActionsVente(numeroSociete);
	}
	@RequestMapping(value="/total-actions-achat/{numeroSociete}",method=RequestMethod.GET)
	public int totalActionsAchat(@PathVariable("numeroSociete")Long numeroSociete) {
		return ordreMetier.totalActionsAchat(numeroSociete);
	}
	@RequestMapping(value="/prix-moyen-vente/{numeroSociete}",method=RequestMethod.GET)
	public double moyenPrixVente(@PathVariable("numeroSociete")Long numeroSociete) {
		return ordreMetier.moyenPrixVente(numeroSociete);
	}
	@RequestMapping(value="/prix-moyen-achat/{numeroSociete}",method=RequestMethod.GET)
	public double moyenPrixAchat(@PathVariable("numeroSociete")Long numeroSociete) {
		return ordreMetier.moyenPrixAchat(numeroSociete);
	}
	

}
