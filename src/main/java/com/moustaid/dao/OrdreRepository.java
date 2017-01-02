package com.moustaid.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.moustaid.entities.Ordre;
import com.moustaid.entities.Societe;
@Repository
public interface OrdreRepository extends JpaRepository<Ordre,Long>{
     Page<Ordre> findBySocieteNumeroSociete(Long numeroSociete,Pageable pageable);
     @Query(value="select oa from OrdreAchat oa where oa.societe.numeroSociete=:x")
     List<Ordre> findOrdreAchat(@Param("x")Long numeroSociete);
     @Query(value="select ov from OrdreVente ov where ov.societe.numeroSociete=:x")
     List<Ordre> findOrdreVente(@Param("x")Long numeroSociete);
}
