package com.moustaid.metier;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.moustaid.entities.Ordre;
import com.moustaid.entities.Societe;

public interface OrdreMetier {
	Ordre addOrdre(Ordre ordre);
     Page<Ordre> findBySociete(Long numeroSociete,int page,int size);
     int totalActionsVente(Long numeroSociete);
     int totalActionsAchat(Long numeroSociete);
     double moyenPrixVente(Long numeroSociete);
     double moyenPrixAchat(Long numeroSociete);
     double estimationPrix(Long numeroSociete);
     void deleteAll();
     
}
