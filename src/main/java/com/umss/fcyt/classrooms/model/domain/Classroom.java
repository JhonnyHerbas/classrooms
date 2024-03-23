package com.umss.fcyt.classrooms.model.domain;

import com.umss.fcyt.classrooms.util.constants.DatabaseConstants;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import static com.umss.fcyt.classrooms.util.constants.DatabaseConstants.ClassroomDB;

@Data
@Entity
@Table(name = ClassroomDB.CLASSROOM)
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ClassroomDB.Id.ID, nullable = false)
    private Integer id;

    @Column(name = ClassroomDB.ClassroomNumber.NUMBER, length = ClassroomDB.ClassroomNumber.LENGTH, nullable = false)
    private String classroomNumber;

    @Column(name = ClassroomDB.Description.DESCRIPTION)
    private String description;

    @Column(name = ClassroomDB.Capacity.CAPACITY, nullable = false)
    private Integer capacity;

    @Column(name = ClassroomDB.Building.BUILDING, length = ClassroomDB.Building.LENGTH, nullable = false)
    private String building;

    @Column(name = ClassroomDB.Level.LEVEL, nullable = false)
    private Integer level;

    @Column(name = ClassroomDB.UrlGoogleMaps.URL)
    private String url;

    @OneToMany(mappedBy = ClassroomDB.CLASSROOM, fetch = FetchType.LAZY, targetEntity = PhotoClassroom.class)
    private List<PhotoClassroom> photos;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Booking.class)
    @JoinColumn(name = DatabaseConstants.BookingDB.Id.ID, referencedColumnName = DatabaseConstants.BookingDB.Id.ID)
    private Booking booking;

    @OneToMany(mappedBy = ClassroomDB.CLASSROOM, fetch = FetchType.LAZY, targetEntity = Booking.class)
    private List<Booking> bookings;
}
