package com.enigma.studentpathfinder;

import com.enigma.studentpathfinder.config.JPAConfig;
import com.enigma.studentpathfinder.delivery.Server;
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

        log.info("Aplikasi dimulai");

        Server server = Server.serve();
        server.run();

        log.info("Aplikasi dihentikan");

    }
}
