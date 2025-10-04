package com.enigma.studentpathfinder;

import com.enigma.studentpathfinder.config.JPAConfig;
import lombok.extern.slf4j.Slf4j;

/**
 * Hello world!
 */
@Slf4j
public class App {
    public static void main(String[] args) {
        // command compile clean maven
        // mvn clean compile --% exec:java -Dexec.mainClass=*App package name*
        // For this project :
        // mvn clean compile --% exec:java -Dexec.mainClass=com.enigma.studentpathfinder.App

        try(var db = JPAConfig.getEm()){
            log.info("ini udah konek");
        }catch (Exception e){
            JPAConfig.disconnect();
            log.error("gagal konek nih ");
        }

    }
}
