package com.enigma.studentpathfinder.delivery;

import com.enigma.studentpathfinder.config.JPAConfig;
import com.enigma.studentpathfinder.dao.StudentDAO;
import com.enigma.studentpathfinder.delivery.controller.StudentController;
import com.enigma.studentpathfinder.service.StudentService;

import java.util.Scanner;

public class Server {
    private final Scanner scanner = new Scanner(System.in);
    private final StudentService studentService;

    public Server(StudentService studentService) {
        this.studentService = studentService;
    }

    public void run(){
        while(true){
            System.out.println("======== Pathfinder ========");
            System.out.println("1. STUDENT MANAGEMENT");
            System.out.println("0. EXIT");
            System.out.print("Choose menu: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> new StudentController(studentService).showMenu();
                case 0 -> {
                    System.out.println("Bye...");
                    JPAConfig.disconnect();
                    return;
                }
                default -> System.out.println("Pilih menu (1 & 0) saja");
            }
        }
    }

    public static Server serve(){
        StudentDAO studentDAO = new StudentDAO(JPAConfig.getEm());
        StudentService studentService1 = new StudentService(studentDAO);
        return new Server(studentService1);
    }

}
