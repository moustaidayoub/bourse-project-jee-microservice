package com.moustaid;

import com.moustaid.entities.Ordre;
import com.moustaid.entities.Societe;
import com.moustaid.metier.ScrapingShedule;
import com.moustaid.services.rmi.ISocieteRemote;
import com.moustaid.services.rmi.SocieteRmiService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.moustaid.metier.OrdreMetier;
import com.moustaid.metier.SocieteMetier;
import com.moustaid.metier.WafaBourseMetier;
import com.moustaid.services.rmi.ServeurRMI;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class ProjetBourseApplication {
	

	public static void main(String[] args) throws IOException {

		ApplicationContext context=SpringApplication.run(ProjetBourseApplication.class, args);

		//OrdreMetier ordreMetier=context.getBean(OrdreMetier.class);
		//WafaBourseMetier wbMetier=context.getBean(WafaBourseMetier.class);
		//List<Societe> societes=new ArrayList<>();
		//societes=wbMetier.doScraping();
		//societes.forEach(societe -> {System.out.println("Societe : "+societe.getNomSociete());
		//	System.out.println("Ordres : "+societe.getOrders().size());});
		//ajout societe
		/*Societe societe=new Societe("II","IntellijIDEA");

		//creation Ordres
		Ordre ordre1=new OrdreAchat(new Date(),10,4.5,societe);
		Ordre ordre2=new OrdreAchat(new Date(),5,8,societe);
		Ordre ordre3=new OrdreVente(new Date(),8,11,societe);
		Ordre ordre4=new OrdreVente(new Date(),10,5,societe);
		List<Ordre> ordres=new ArrayList<>();
		ordres.add(ordre1);
		ordres.add(ordre2);
		ordres.add(ordre3);
		ordres.add(ordre4);
		societe.setOrders(ordres);

		societeMetier.addSociete(societe);
		ordreMetier.addOrdre(ordre1);
		ordreMetier.addOrdre(ordre2);
		ordreMetier.addOrdre(ordre3);
		ordreMetier.addOrdre(ordre4);
		//test des methodes
		/*
		//recuperer societe
		Societe societeTest=societeMetier.findByCode("OR10");
		System.out.println("societe nom : "+societeTest.getNomSociete());
		//recuprer ordres de societe
		System.out.println("Ordres de societes : "+ordreMetier.findBySociete(2L, 0,2));
		//total actions
		System.out.println("total actions vente : "+ordreMetier.totalActionsVente(2L) );
		System.out.println("total actions achat : "+ordreMetier.totalActionsAchat(2L) );
		//prix moyen
		System.out.println("prix moyen achats : "+ordreMetier.moyenPrixVente(2L) );
		System.out.println("prix moyen ventes : "+ordreMetier.moyenPrixVente(2L) );
		*/
		//execution serveur RMI
		//ServeurRMI serveurRmi=context.getBean(ServeurRMI.class);
		//ServeurRMI serveurRmi=new ServeurRMI();
		//serveurRmi.getRmiServiceExporter();








	}
}
