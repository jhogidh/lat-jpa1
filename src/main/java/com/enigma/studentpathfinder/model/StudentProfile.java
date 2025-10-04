package com.enigma.studentpathfinder.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "studentprofiles", indexes = {
        @Index(name = "idx_profile_phone_number", columnList = "phone_number")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String address;

    @Column(name = "phone_number", length = 20, nullable = false)
    private String phoneNumber;



}
