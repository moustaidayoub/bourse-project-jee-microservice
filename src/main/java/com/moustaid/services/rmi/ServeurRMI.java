package com.moustaid.services.rmi;


import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.stereotype.Component;

@Configuration
public class ServeurRMI {
	/*@Autowired
	private IOrdreRemote ordreRemote;
	@Autowired
	private ISocieteRemote societeRemote;
*/
    @Bean
    public RmiServiceExporter getRmiSocieteServiceExporter(ApplicationContext context) {

        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setService(context.getBean(SocieteRmiService.class));
        exporter.setRegistryPort(1099);
        exporter.setServiceName("societeRmiService");
        exporter.setServiceInterface(ISocieteRemote.class);
        System.out.println("societes service exporter : "+exporter);
        return exporter;
    }

	/*/@Bean
	public RmiServiceExporter getRmiServiceExporter(){
        RmiServiceExporter exporter = new RmiServiceExporter();
	try {

       // exporter.setService(societeRemote);
       // exporter.setRegistryPort(1099);
        //exporter.setServiceName("societeRmiService");
        //exporter.setServiceInterface(ISocieteRemote.class);
        //System.out.print("RMI : "+exporter.toString());
        //ISocieteRemote stub = (ISocieteRemote) UnicastRemoteObject.exportObject(societeRemote, 1099); // Génère un stub vers notre service.
       //Registry reg=LocateRegistry.createRegistry(1099);
        //reg.bind("societeRmiService", stub);
        //Naming.rebind("rmi://localhost:2055/ordreService", ordreRemote);
        //Naming.rebind("rmi://localhost:1099/societeRmiService", skeleton);

       // System.out.println(/*"ref ordre : "+ordreRemote+" -- ref societe : "+stub);
       // System.err.println("Server ready !");
    } catch (Exception ex) {
        Logger.getLogger(ServeurRMI.class.getName()).log(Level.SEVERE, null, ex);
    }
        return exporter;
	}*/
}
