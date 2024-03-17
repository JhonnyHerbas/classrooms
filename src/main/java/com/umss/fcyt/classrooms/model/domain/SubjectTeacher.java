package com.umss.fcyt.classrooms.model.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import static com.umss.fcyt.classrooms.util.constants.DatabaseConstants.*;

@Data
@Entity
@Table(name = SubjectTeacherDB.SUBJECT_TEACHER)
public class SubjectTeacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = SubjectTeacherDB.Id.ID)
    private Integer id;

    @Column(name = SubjectTeacherDB.Group.GROUP, length = SubjectTeacherDB.Group.LENGTH)
    private String group;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Teacher.class)
    @JoinColumn(name = TeacherDB.Id.ID, referencedColumnName = TeacherDB.Id.ID)
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Subject.class)
    @JoinColumn(name = SubjectDB.Id.ID, referencedColumnName = SubjectDB.Id.ID)
    private Subject subject;

    @OneToMany(mappedBy = "subjectTeacher", fetch = FetchType.LAZY, targetEntity = Booking.class)
    private List<Booking> bookings;
}
