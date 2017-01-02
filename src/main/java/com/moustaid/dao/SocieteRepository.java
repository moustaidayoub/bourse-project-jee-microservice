package com.moustaid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moustaid.entities.Societe;

@Repository
public interface SocieteRepository extends JpaRepository<Societe,Long>{
	Societe findByCodeSociete(String code);
}
