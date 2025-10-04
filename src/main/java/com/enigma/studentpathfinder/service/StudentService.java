package com.enigma.studentpathfinder.service;

import com.enigma.studentpathfinder.dao.StudentDAO;
import com.enigma.studentpathfinder.model.Student;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class StudentService {
    private StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO){
        this.studentDAO = studentDAO;
    }

    public boolean isEmailExist(String email){
        return studentDAO.list().stream().anyMatch(s -> s.getEmail().equalsIgnoreCase(email));
    }

    public void createStudent(Student student){
        if(isEmailExist(student.getEmail())){
            throw new IllegalArgumentException("email telah digunakan " + student.getEmail());
        }
        studentDAO.save(student);
    }

    public void updateStudent(Student student){
        if(student.getId() == null){
            throw new IllegalArgumentException("Id tidak boleh kosong" );
        }
        findById(student.getId());
        studentDAO.save(student);
    }

    public List<Student> findAllStudent(){
        return studentDAO.list();
    }

    public Student findById(Long id){
        return studentDAO.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student tidak ditemukan dengan id: " + id));
    }

}
