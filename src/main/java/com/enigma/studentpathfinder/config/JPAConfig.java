package com.enigma.studentpathfinder.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JPAConfig {
    private final static String PERSISTENCE_UNIT_NAME = "lat-jpa-pu";
    private static EntityManagerFactory emf;
    private JPAConfig(){}

    private static EntityManagerFactory getEmf(){
        try {
            if(emf == null){
                emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
                log.info("succesfully connected");
            }
        }catch (Exception e){
            log.error("Failed to create Entity Manager Factory {}", e.getCause());
            throw new RuntimeException("Could not crate EntityManagerFactory", e);
        }
            return emf;
    }

    public static EntityManager getEm(){
        return getEmf().createEntityManager();
    }

    public static void disconnect(){
        if(emf != null && emf.isOpen()){
            emf.close();
            log.info("succesfully disconnected");
        }
    }

}
