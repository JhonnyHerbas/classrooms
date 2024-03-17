package com.umss.fcyt.classrooms.model.domain;

import jakarta.persistence.*;
import lombok.Data;

import static com.umss.fcyt.classrooms.util.constants.DatabaseConstants.ClassroomDB;
import static com.umss.fcyt.classrooms.util.constants.DatabaseConstants.PhotoClassroomDB;

@Data
@Entity
@Table(name = PhotoClassroomDB.PHOTO_CLASSROOM)
public class PhotoClassroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = PhotoClassroomDB.Id.ID)
    private Integer id;

    @Lob
    @Column(name = PhotoClassroomDB.Image.FILE)
    private String image;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Classroom.class)
    @JoinColumn(name = ClassroomDB.Id.ID, referencedColumnName = ClassroomDB.Id.ID)
    private Classroom classroom;
}
