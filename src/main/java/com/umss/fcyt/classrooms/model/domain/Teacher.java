package com.umss.fcyt.classrooms.model.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import static com.umss.fcyt.classrooms.util.constants.DatabaseConstants.TeacherDB;

@Data
@Entity
@Table(name = TeacherDB.TEACHER)
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = TeacherDB.Id.ID, nullable = false)
    private Integer id;

    @Column(name = TeacherDB.Name.NAME, length = TeacherDB.Name.LENGTH, nullable = false)
    private String name;

    @Column(name = TeacherDB.LastName.LAST_NAME, length = TeacherDB.LastName.LENGTH, nullable = false)
    private String lastName;

    @Column(name = TeacherDB.Email.EMAIL, length = TeacherDB.Email.LENGTH, nullable = false)
    private String email;

    @Column(name = TeacherDB.Username.USERNAME, length = TeacherDB.Username.LENGTH, nullable = false)
    private String username;

    @Column(name = TeacherDB.Password.PASSWORD, nullable = false)
    private String password;

    @Lob
    @Column(name = TeacherDB.ProfilePicture.PROFILE)
    private String profilePicture;

    @OneToMany(mappedBy = TeacherDB.TEACHER, fetch = FetchType.LAZY, targetEntity = SubjectTeacher.class)
    private List<SubjectTeacher> subjectTeachers;
}
