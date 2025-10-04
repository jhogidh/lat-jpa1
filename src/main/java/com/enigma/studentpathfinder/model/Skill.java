package com.enigma.studentpathfinder.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="skils")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

}
