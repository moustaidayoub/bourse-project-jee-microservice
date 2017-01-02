package com.moustaid.metier;

import com.moustaid.entities.Societe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

/**
 * Created by Ayoub on 01/01/2017.
 */

@Component
public class ScrapingShedule {

    @Autowired
    private WafaBourseMetier wafaBourseMetier;

    @Autowired
    private SocieteMetier societeMetier;
    @Autowired
    private OrdreMetier ordreMetier;

    private final String NODE_JS_URL="http://localhost:8300/societes";

    @Scheduled(fixedRate = 1000000000)
    public void updateData() throws IOException {
        System.out.println("Sheduled Scraping is started !");
        //delete all data

        //ordreMetier.deleteAll();
        //societeMetier.deleteAll();
       // List<Societe> societes = wafaBourseMetier.doScraping();
        //societes.forEach(s -> {
          //  societeMetier.addSociete(s);
        //});
        //send data to nodesJs Server
        List<Societe> societes = societeMetier.findAll();
        RestTemplate restTemplate=new RestTemplate();
        restTemplate.postForObject(NODE_JS_URL,societes,societes.getClass());
    }
}
