package com.moustaid.metier;

import java.io.IOException;
import java.util.List;

import com.moustaid.entities.Ordre;
import com.moustaid.entities.Societe;

public interface WafaBourseMetier {

	List<Societe> doScraping();

	
}
