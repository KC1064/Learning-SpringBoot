package com.example.collegeManagementSystem.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "professor_table")
public class ProfessorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professor_id")
    private Long id;

    @Column(name = "professor_name")
    private String name;

    @OneToMany(mappedBy = "professorEntity",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<SubjectEntity> subjectEntityList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "professor_student",
            joinColumns = @JoinColumn(name = "professor_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<StudentEntity> studentEntityList;

}
