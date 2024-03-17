package com.umss.fcyt.classrooms.model.domain;

import jakarta.persistence.*;
import lombok.Data;

import static com.umss.fcyt.classrooms.util.constants.DatabaseConstants.*;

@Data
@Entity
@Table(name = BookingClassroomDB.BOOKING_CLASSROOM)
public class BookingClassroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = BookingClassroomDB.Id.ID, nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Booking.class)
    @JoinColumn(name = BookingDB.Id.ID, referencedColumnName = BookingDB.Id.ID)
    private Booking booking;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Classroom.class)
    @JoinColumn(name = ClassroomDB.Id.ID, referencedColumnName = ClassroomDB.Id.ID)
    private Classroom classroom;
}
