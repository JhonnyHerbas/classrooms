package com.umss.fcyt.classrooms.model.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import static com.umss.fcyt.classrooms.util.constants.DatabaseConstants.SubjectDB;

@Data
@Entity
@Table (name = SubjectDB.SUBJECT)
public class Subject {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = SubjectDB.Id.ID, nullable = false)
    private Integer id;

    @Column(name = SubjectDB.NameSubject.NAME, length = SubjectDB.NameSubject.LENGTH, nullable = false)
    private String name;

    @Column(name = SubjectDB.Semester.SEMESTER)
    private Character semester;

    @OneToMany(mappedBy = SubjectDB.SUBJECT, fetch = FetchType.LAZY, targetEntity = SubjectTeacher.class)
    private List<SubjectTeacher> subjectTeachers;
}
