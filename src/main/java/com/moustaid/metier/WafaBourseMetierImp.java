package com.moustaid.metier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;

import com.moustaid.entities.OrdreAchat;
import com.moustaid.entities.OrdreVente;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.moustaid.entities.Ordre;
import com.moustaid.entities.Societe;
@Service
public class WafaBourseMetierImp implements WafaBourseMetier {
	private final String BOURSE_URL= "https://www.wafabourse.com/marches/actions/r";
	@Override
	public List<Societe> doScraping() {
		Document doc = null;
		List<Societe> societes=new ArrayList<>();
		try {
			doc = Jsoup.connect(BOURSE_URL).get();
			Elements links = doc.select("td a[href]");
			for (Element link : links) {
				Document societeDoc = Jsoup.connect(link.absUrl("href")).get();
				Element infosSociete = societeDoc.select("div[class=titre]").first();
				Societe societe = new Societe(infosSociete.select("div[class=markettitleisin]").text(), infosSociete.select("h1").text());
				//recuperation des ordres
				Element divOrdres = societeDoc.select("div[class=orderBookDiv]").first();
				Element tableOrdreAchat = divOrdres.select("table").stream().filter((e) -> e.hasAttr("bid_qty")).findFirst().get().select("tbody").first();
				Element tableOrdreVente = divOrdres.select("table").stream().filter((e) -> e.hasAttr("ask_px")).findFirst().get().select("tbody").first();
				addOrdresToSociete(tableOrdreAchat, tableOrdreVente, societe);
				societes.add(societe);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}


		return societes;
	}

	private void addOrdresToSociete(Element tableOrdreAchat, Element tableOrdreVente, Societe societe) {
		List<Ordre> ordres=new ArrayList<>();
		ordres.addAll(getOrdres(tableOrdreAchat, OrdreAchat::new, () -> "bid", societe));//Achat
		ordres.addAll(getOrdres(tableOrdreVente, OrdreVente::new, () -> "ask", societe));//Vente
		societe.setOrders(ordres);
	}


	private List<Ordre> getOrdres(Element tableOrdre, Supplier<Ordre> ordreSupplier, Supplier<String> tdClassSupplier, Societe societe) {
		Iterator<Element> rows = tableOrdre.select("tr")
				.stream()
				.filter(e -> !e.select("td").first().text().equals("-"))
				.iterator();
		Element row = null;
		List<Ordre> ordres=new ArrayList<>();
		while (rows.hasNext()) {
			row = rows.next();
			int nbrActions = Integer.parseInt(row.select("td[class=" + tdClassSupplier.get() + "Volume]").text().replaceAll(" ", ""));
			double prixAction = Double.parseDouble(row.select("td[class=" + tdClassSupplier.get() + "Price]").text().replace(",", ".").replaceAll(" ", ""));
			Ordre ordre = ordreSupplier.get();
			ordre.setDateOrdre(new Date());
			ordre.setNombreActions(nbrActions);
			ordre.setPrixAction(prixAction);
			ordre.setSociete(societe);
			ordres.add(ordre);
		}
		return ordres;
	}



}
