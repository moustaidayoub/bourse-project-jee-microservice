package com.moustaid.services.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moustaid.entities.Societe;
import com.moustaid.metier.SocieteMetier;

@RestController
@CrossOrigin("*")
@RequestMapping("/v1/societes")
public class SocieteRestService {
	@Autowired
	private SocieteMetier societeMetier;

	@RequestMapping(method=RequestMethod.POST)
	public Societe addSociete(Societe societe) {
		return societeMetier.addSociete(societe);
	}
	@RequestMapping(value="/{numeroSociete}",method=RequestMethod.GET)
	public Societe findSociete(@PathVariable Long numeroSociete) {
		return societeMetier.findSociete(numeroSociete);
	}

	@RequestMapping(value="/find-by-code/{codeSociete}",method=RequestMethod.GET)
	public Societe findByCode(@PathVariable String codeSociete) {
		return societeMetier.findByCode(codeSociete);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public Page<Societe> findAll(@RequestParam int page, @RequestParam int size) {
		return societeMetier.findAll(page, size);
	}

}
