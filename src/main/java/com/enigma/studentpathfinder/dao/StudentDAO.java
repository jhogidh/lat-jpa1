package com.enigma.studentpathfinder.dao;

import com.enigma.studentpathfinder.config.JPAConfig;
import com.enigma.studentpathfinder.model.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class StudentDAO implements BaseDAO<Student, Long>{
    private final EntityManager em = JPAConfig.getEm();

    @Override
    public void save(Student student) {
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            if(student.getId() != null){
                student.setProfile(student.getProfile());
                em.persist(student);
            }else {
                em.merge(student);
            }
            et.commit();
        }catch (Exception e){
            if(et.isActive() && et != null) et.rollback();
            throw e;
        }
    }

    @Override
    public List<Student> list() {
        return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    @Override
    public Optional<Student> getById(Long id) {
        return Optional.ofNullable(em.find(Student.class, id));
    }
}
