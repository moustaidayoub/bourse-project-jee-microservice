package com.moustaid.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.moustaid.dao.OrdreRepository;
import com.moustaid.entities.Ordre;
import com.moustaid.entities.Societe;

@Service
public class OrdreMetierImp implements OrdreMetier {
	@Autowired
	private OrdreRepository ordreRepository;


	@Override
	public Page<Ordre> findBySociete(Long numeroSociete, int page,int size) {
		return ordreRepository.findBySocieteNumeroSociete(numeroSociete, new PageRequest(page,size));
	}

	@Override
	public int totalActionsVente(Long numeroSociete) {
		int total = 0;
		for (Ordre ordre : ordreRepository.findOrdreVente(numeroSociete)) {
			total += ordre.getNombreActions();
		}
		return total;
	}

	@Override
	public int totalActionsAchat(Long numeroSociete) {
		int total = 0;
		for (Ordre ordre : ordreRepository.findOrdreAchat(numeroSociete)) {
			total += ordre.getNombreActions();
		}
		return total;
	}

	@Override
	public double moyenPrixVente(Long numeroSociete) {
		int somme = 0;
		List<Ordre> ordres = ordreRepository.findOrdreVente(numeroSociete);
		if (ordres.size() == 0)
			return 0;
		for (Ordre ordre : ordres) {
			somme += ordre.getPrixAction();
		}
		return somme / ordres.size();
	}

	@Override
	public double moyenPrixAchat(Long numeroSociete) {
		int somme = 0;
		List<Ordre> ordres = ordreRepository.findOrdreAchat(numeroSociete);
		if (ordres.size() == 0)
			return 0;
		for (Ordre ordre : ordres) {
			somme += ordre.getPrixAction();
		}
		return somme / ordres.size();
	}

	@Override
	public double estimationPrix(Long numeroSociete) {
		return 0;
	}

	@Override
	public Ordre addOrdre(Ordre ordre) {
		return ordreRepository.save(ordre);
	}
	@Override
	public void deleteAll() {
		ordreRepository.deleteAll();
	}

}
