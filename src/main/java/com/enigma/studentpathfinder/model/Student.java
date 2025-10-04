package com.enigma.studentpathfinder.model;

import jakarta.persistence.*;
import lombok.*;
import org.postgresql.shaded.com.ongres.stringprep.Profile;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student", indexes = {
        //bikin index @Index(name, column)
        @Index(name = "idx_student_name", columnList = "name"),
        @Index(name = "idx_student_email", columnList = "email")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private StudentProfile profile;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Project> project = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "student_skills",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name="skill_id")
    )
    private List<Skill> skills = new ArrayList<>();

    public void setProfile(StudentProfile profile){
        this.profile = profile;
        if(profile != null) profile.setStudent(this);
    }

}
