package com.enigma.studentpathfinder.delivery.controller;

import com.enigma.studentpathfinder.model.Student;
import com.enigma.studentpathfinder.model.StudentProfile;
import com.enigma.studentpathfinder.service.StudentService;

import java.util.Scanner;

public class StudentController {
    private Scanner scanner = new Scanner(System.in);
    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    public void showMenu(){
        System.out.println("==== Welcome ====");
        System.out.println("1. Add");
        System.out.println("2. Get All");
        System.out.println("3. Get Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("0. Exit");
        System.out.print("Choose Menu");

        int choose = Integer.parseInt(scanner.nextLine());
        switch (choose){
            case 1 -> createHandler();
            case 2 -> listHandler();
            case 0 -> {
                System.out.println("Bye");
                return;
            }
            default -> System.out.println("choose the right menu! ");
        }
    }

    public void createHandler(){
        System.out.println("========== FORM STUDENT ==========");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        var payload = Student.builder()
                .name(name)
                .email(email)
                .profile(StudentProfile.builder().address(address).phoneNumber(phone).build())
                .build();

        studentService.createStudent(payload);
    }


    public void listHandler(){
        studentService.findAllStudent().forEach(System.out::println);
    }

}
