package com.umss.fcyt.classrooms.model.domain;

import com.umss.fcyt.classrooms.util.constants.BookingStatus;
import com.umss.fcyt.classrooms.util.constants.DatabaseConstants;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static com.umss.fcyt.classrooms.util.constants.DatabaseConstants.BookingDB;
import static com.umss.fcyt.classrooms.util.constants.DatabaseConstants.SubjectTeacherDB;

@Data
@Entity
@Table(name = BookingDB.BOOKING)
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = BookingDB.Id.ID, nullable = false)
    private Integer id;

    @Column(name = BookingDB.DateTimeRequest.DATE_TIME_REQUEST, nullable = false)
    private LocalDateTime dateRequest;

    @Column(name = BookingDB.DateBooking.DATE_BOOKING, nullable = false)
    private LocalDate dateBooking;

    @Column(name = BookingDB.StartTimeBooking.START_TIME_BOOKING, nullable = false)
    private LocalTime startTimeBooking;

    @Column(name = BookingDB.EndTimeBooking.END_TIME_BOOKING, nullable = false)
    private LocalTime endTimeBooking;

    @Column(name = BookingDB.Description.DESCRIPTION)
    private String description;

    @Column(name = BookingDB.NumberStudents.NUMBER_STUDENTS)
    private Integer numberStudents;

    @Column(name = BookingDB.Status.STATUS, length = BookingDB.Status.LENGTH)
    private BookingStatus status;

    @Column(name = BookingDB.DescriptionResponse.DESCRIPTION_RESPONSE)
    private String descriptionResponse;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = SubjectTeacher.class)
    @JoinColumn(name = SubjectTeacherDB.Id.ID, referencedColumnName = SubjectTeacherDB.Id.ID)
    private SubjectTeacher subjectTeacher;

    @OneToMany(mappedBy = BookingDB.BOOKING, fetch = FetchType.LAZY, targetEntity = Classroom.class)
    private List<Classroom> classrooms;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Classroom.class)
    @JoinColumn(name = DatabaseConstants.ClassroomDB.Id.ID, referencedColumnName = DatabaseConstants.ClassroomDB.Id.ID)
    private Classroom classroom;
}
